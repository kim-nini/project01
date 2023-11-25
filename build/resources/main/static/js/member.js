// 이벤트 타겟에 이벤트 리스너 등록(id 셀렉터)
document.querySelector("form").addEventListener("submit", checkValidate);
document.querySelector('#memberId').addEventListener('input', idCheck);
document.querySelector('#password').addEventListener('input', pwCheck);
document.querySelector('#passwordCheck').addEventListener('input', pwSameCheck);
document.querySelector('#hp').addEventListener('input', hpCheck);
document.querySelector('#name').addEventListener('input', nameCheck);
document.querySelector('#email').addEventListener('input', emailCheck);


function checkValidate(event) {
    event.preventDefault();
    let form = event.target;
    // 필드 입력 여부

    // 아이디 필수 입력 메세지
    if (!hasText(form.memberId.value)) {
        showFieldMessage('#memberId-message', "아이디는 필수 입력항목입니다.", "fail");
        form.memberId.focus();
        return;
    }

    // 비밀번호 필수 입력 메세지
    if (!hasText(form.password.value)) {
        showFieldMessage("#passwd-message", "비밀번호는 필수 입력항목입니다.", "fail");
        form.password.focus();
        return;
    }

    // 비밀번호 확인 필수 입력 메세지
    if (!hasText(form.loginPwConfirm.value)) {
        showFieldMessage("#passwdCheck-message", "비밀번호를 한번 더 작성해주세요. ", "fail");
        form.password.focus();
        return;
    }

    // 이름 필수 입력 메세지
    if (!hasText(form.name.value)) {
        showFieldMessage("#name-message", "이름은 필수 입력항목입니다.", "fail");
        form.name.focus();
        return;
    }

    // 전화번호 필수 입력 메세지
    if (!hasText(form.hp.value)) {
        showFieldMessage("#hp-message", "전화번호는 필수 입력항목입니다.", "fail");
        form.hp.focus();
        return;
    }

    // 이메일 필수 입력 메세지
    if (!hasText(form.email.value)) {
        showFieldMessage("#email-message", "이메일은 필수 입력항목입니다.", "fail");
        form.email.focus();
        return;
    }

    form.submit();
}

// 아이디 메세지 처리
async function idCheck(event) {
    let inputId = event.target.value;
    if (!isId(inputId)) {
        showFieldMessage("#memberId-message", "아이디는 6~8자 사이의 영문자+숫자 조합입니다.", "fail");
    } else if (inputId.length >= 6 && inputId.length <= 8) {
        const result = await requestIdDupCheck(inputId);
        console.log(result);
        // 아이디 중복 경우
        if (result) {
            showFieldMessage("#memberId-message", "이미 사용중인 아이디입니다.", "fail");
        } else {
            showFieldMessage("#memberId-message", "사용 가능한 아이디입니다.", "success");
        }
    }
}

// 아이디 중복 여부 요청
function requestIdDupCheck(inputId) {
    const url = `/grrreung/idcheck?memberId=${inputId}`;
    return fetch(url)
        .then((response) => {
            return response.json();
        });
}


// 비밀번호 메세지 처리
async function pwCheck(event) {
    let inputPw = event.target.value;
    if (!isPasswd(inputPw)) {
        showFieldMessage("#passwd-message", "비밀번호는 8~16자 사이의 숫자 + 영문 + 특수문자 조합입니다.", "fail");
    } else if (inputPw.length >= 8 && inputPw.length <= 16) {
        showFieldMessage("#passwd-message", "사용 가능한 비밀번호입니다.", "success");
    }
}


// 비밀번호 동일 여부 메세지 처리
async function pwSameCheck(event) {
    const inputPw = document.getElementById('password').value;
    let checkPw = event.target.value;
	if (inputPw == checkPw ) {
        showFieldMessage("#passwdCheck-message", "비밀번호가 일치합니다.", "success");
    } else{
        showFieldMessage("#passwdCheck-message", "비밀번호가 일치하지 않습니다.", "fail");
    }
}


// 이름 메세지 처리
async function nameCheck(event) {
    let inputName = event.target.value;
    if (!isName(inputName)) {
        showFieldMessage("#name-message", "이름은 2~10자 사이의 한글입니다.", "fail");
    } else if (inputName.length >= 2 && inputName.length <= 10) {
        showFieldMessage("#name-message", "사용 가능한 이름입니다.", "success");
    }
}


// 이메일 메세지 처리
async function emailCheck(event) {
    let inputEmail = event.target.value;g
    if (!isEmail(inputEmail)) {
        showFieldMessage("#email-message", "올바른 이메일 형식으로 작성해주세요.", "fail");
    } else if (inputEmail.length >= 6 && inputEmail.length <= 30) {
        showFieldMessage("#email-message", "사용 가능한 이메일입니다.", "success");
    }

}

// 핸드폰 번호 메세지 처리
async function hpCheck(event) {
    let inputHp = event.target.value;
    if (!isHp(inputHp)) {
        showFieldMessage("#hp-message", "올바른 전화번호를 작성해주세요.", "fail");
    } else if (inputHp.length = 11) {
        showFieldMessage("#hp-message", "사용 가능한 번호입니다.", "success");
    }

}

// 회원가입 오류 메세지
function showFieldMessage(selector, message, messageType) {
    const target = document.querySelector(selector);
    if (messageType === 'success') {
        target.className = 'text-success';
    } else {
        target.className = 'text-danger';
    }
    target.innerHTML = message;
}
