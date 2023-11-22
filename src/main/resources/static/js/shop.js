






















//------------------------------------------------------------------------------------------------------------
// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("form").addEventListener("submit", memberRegister);
document.querySelector('#memberId').addEventListener('input' ,idCheck);

async function memberRegister(event) {
    event.preventDefault();
    const form = event.target;
    // 유효성 검증
    if(checkValidate(form)){
        const member = {
            memberId : form.memberId.value,
            passwd   : form.passwd.value,
            name     : form.name.value,
            email    : form.email.value
        };

        const result = await  requestRegister(member);
        const target = document.querySelector("#register-result");
        if(result){
            showGlobalMessage(target, `${member.name}님 회원 가입을 축하합니다.`, "success");
        }else{
            showGlobalMessage(target, `서버 장애 발생, 다시 한번 시도해 주세요.`, "fail");
        }
    }
}

function checkValidate(form){
    // 필드 입력 여부
    if(!hasText(form.memberId.value)){
        showFieldMessage("#memberId-message", "아이디는 필수 입력항목입니다.", "fail");
        form.memberId.focus();
        return false;
    }else{
        showFieldMessage("#memberId-message", "");
    }

    if(!hasText(form.passwd.value)){
        showFieldMessage("#passwd-message", "비밀번호는 필수 입력항목입니다.", "fail");
        form.passwd.focus();
        return false;
    }else{
        showFieldMessage("#passwd-message", "");
    }

    if(!hasText(form.name.value)){
        showFieldMessage("#name-message", "이름은 필수 입력항목입니다.", "fail");
        form.name.focus();
        return false;
    }else{
        showFieldMessage("#name-message", "");
    }

    if(!hasText(form.email.value)){
        showFieldMessage("#email-message", "이메일은 필수 입력항목입니다.", "fail");
        form.email.focus();
        return false;
    }else{
        showFieldMessage("#email-message", "");
    }

    // 아이디 사용 가능 여부
    if(!isId(form.memberId.value)){
        showFieldMessage("#memberId-message", "아이디는 영문자,숫자 포함 6~8자입니다.", "fail");
        form.memberId.focus();
        return false;
    }else{
        showFieldMessage("#memberId-message", "");
    }
    return true;
}

function showFieldMessage(selector, message, messageType){
    const target = document.querySelector(selector);
    if(messageType === 'success'){
        target.className = 'text-success';
    }else {
        target.className = 'text-danger';
    }
    target.innerHTML = message;
}

function showGlobalMessage(target, message, messageType){
    if(messageType === 'success'){
        target.className = 'alert alert-success  my-3 text-center';
    }else {
        target.className = 'alert alert-danger  my-3 text-center';
    }
    target.innerHTML = message;
}

// 회원 등록 비동기 요청
function requestRegister(member) {
    const url = "/member/register";
    const option = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(member)
    };

    return fetch(url, option)
        .then((response) => {
            return response.json();
        });
}

// 회원 등록 여부 요청
function requestIdDupCheck(inputId) {
    const url = `/member/idcheck?id=${inputId}`;
    return fetch(url)
        .then((response) => {
            return response.json();
        });
}

async function idCheck(event) {
    let inputId = event.target.value;
    // console.log(inputId);
    if (inputId.length >= 6 && inputId.length <= 8) {
        const result = await requestIdDupCheck(inputId);
        console.log(result);
        // 아이디 중복 경우..
        if (result) {
            showFieldMessage("#memberId-message", "이미 사용중인 아이디입니다.", "fail");
        } else {
            showFieldMessage("#memberId-message", "사용 가능한 아이디입니다.", "success");
        }
    } else {
        showFieldMessage("#memberId-message", "아이디는 6~8자 사이의 영문자,숫자입니다.", "fail");
    }
}







