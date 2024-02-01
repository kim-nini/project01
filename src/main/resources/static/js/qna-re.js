// 전역 변수로 선언
const reContBox = $('textarea[name="reCont"]');
const reBox = $('.re-div');
const reCreateBtn = $('button[name="reCreateBtn"]');
const exNewReBox = $('.qna-re-style:last');

// qna 답변 로직
async function sendQnaRe() {
        const thisBtn = $(event.currentTarget);
    console.log("thisBtn : " + thisBtn.closest('.re-div').text())


    // 버튼이 속한 .re-div 요소에서 reCont 값을 가져옴
    let reCont = thisBtn.siblings('textarea[name="reCont"]').val();
    console.log("reCont : " + reCont)


    // 수정된 부분: 버튼이 속한 .re-div 요소에서 qnaCode 값을 가져옴
    const qnaCode = thisBtn.closest('.re-div').attr('value');
    console.log("qnaCode : " + qnaCode)

    try {
        const response = await $.ajax({
            url: "/itemqna/re-create",
            method: "GET",
            data: {
                reCont: reCont,
                qnaCode: qnaCode
            }
        });

        let newBox = handleNewResponse(response, false);
        thisBtn.siblings('textarea[name="reCont"]').val('');
        thisBtn.siblings('textarea[name="reCont"]').before(newBox);

    } catch (error) {
        console.error("실패", error);
    }
}

// 동적 태그 생성
function handleNewResponse(response, isUpdate) {
    const newReBox = $('<div class="qna-re-style" value="' + response.reCode + '"></div>');
    const updateBtn = $('<button name="reUpdateBtn">수정</button>').click(updateQnaRe);
    const deleteBtn = $('<button>삭제</button>').click(deleteQnaRe);

    newReBox.append('<p class="re-cont">' + response.reCont + '</p>');
    newReBox.append('<p class="re-date" >' + response.reDate + '</p>');
    newReBox.append(updateBtn);
    newReBox.append(deleteBtn);
    newReBox.append('<hr>');
    newReBox.addClass('qna-re-style');

    // 수정인 경우
    if (isUpdate) {

        return newReBox;
    } else {
        console.log(exNewReBox.length)
        // if (exNewReBox.length > 0) {
        //     exNewReBox.before(newReBox);
        // } else {
        //     reContBox.before(newReBox);
        // }
        return newReBox;
    }
}

// 삭제버튼 클릭시
async function deleteQnaRe() {
    const thisBtn = $(event.currentTarget);
    const reCode = thisBtn.parent().attr('value');
    // const qnaCode = reBox.attr('value');
    // 수정된 부분: 버튼이 속한 .re-div 요소에서 qnaCode 값을 가져옴
    const qnaCode = thisBtn.closest('.re-div').attr('value');
    console.log("qnaCode : " + qnaCode)

    try {
        const response = await $.ajax({
            url: "/itemqna/re-delete",
            method: "GET",
            data: {
                qnaCode: qnaCode,
                reCode: reCode
            }
        });

        thisBtn.parent().remove();
        exNewReBox.length=exNewReBox.length-1;

    } catch (error) {
        console.error("실패", error);
    }

}

// 수정 버튼 클릭시
function updateQnaRe() {
    const thisBtn = $(event.currentTarget);
    const pTag = thisBtn.parent().find('.re-cont');
    console.log("re-cont" + pTag)
    const pText = pTag.text();

    thisBtn.attr('onclick', 'submitUpdate()').text('수정완료');

    const newTextArea = $('<textarea></textarea>').attr({
        'name': 'reCont',
        'class': 're-ip',
        'type': 'text'
    }).val(pText);

    pTag.replaceWith(newTextArea);
}

// 수정 완료 버튼 클릭 시
async function submitUpdate() {
    const thisBtn = $(event.currentTarget);
    const reCode = thisBtn.parent().attr('value');
    const reContBox = thisBtn.parent().find('textarea');
    const reCont = reContBox.val();
    // 수정된 부분: 버튼이 속한 .re-div 요소에서 qnaCode 값을 가져옴
    const qnaCode = thisBtn.closest('.re-div').attr('value');

    try {
        const response = await $.ajax({
            url: "/itemqna/re-update",
            method: "GET",
            data: {
                reCode: reCode,
                reCont: reCont,
                qnaCode: qnaCode
            }
        });

        let newBox = handleNewResponse(response, true);
        thisBtn.parent().replaceWith(newBox);
    } catch (error) {
        console.error("실패", error);
    }
}
