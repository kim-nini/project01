


async function sendQnaRe() {
    var reData = $('input[name="reCont"]').val();
    var reQnaCode = $('.re-div').attr('value');
    let reContBox = $('input[name="reCont"]');
    let reBox = $('.re-div');

    try {
        const response = await $.ajax({
            url: "/grrreung/itemqna/qna-re",
            method: "GET",
            data: {
                reCont: reData,
                qnaCode: reQnaCode
            }
        });
        const updateBtn = document.createElement('button');
        updateBtn.textContent = '수정';
        // 리드온리로 변경
        reBox.append(updateBtn);
        reContBox.textContent = data.reCont;
        reContBox.prop('readonly',true);
        // getReCont(response);





        // 받은 데이터를 사용하여 업데이트할 요소 생성
        // const pTag = document.createElement('p');
        // pTag.textContent = response.reCont // 예시: 서버에서 'Success'를 전달하면 'Success'가 출력되도록 변경
        //
        // // 기존 요소에 추가
        // reBox.append(pTag);

        // 원하는 추가적인 처리 작업 수행 가능

    } catch (error) {
        console.error("실패", error);
    }
}

function getReCont(data){


}