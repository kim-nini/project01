// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("form").addEventListener("submit", memberRegister);
document.querySelector("form").addEventListener("submit", checkValidate);
document.querySelector('#memberId').addEventListener('input', idCheck);
document.querySelector('#password').addEventListener('input', pwCheck);
document.querySelector('#hp').addEventListener('input', hpCheck);
document.querySelector('#name').addEventListener('input', nameCheck);
document.querySelector('#email').addEventListener('input', emailCheck);


async function memberRegister(event) {
	event.preventDefault();
	const form = event.target;
	// 유효성 검증
	// if (checkValidate(form)) {
	// 	form.submit();
	// }

	form.submit();
}

function checkValidate(form) {
	// 필드 입력 여부
	if (!hasText(form.memberId.value)) {
		showFieldMessage('#memberId-message', "아이디는 필수 입력항목입니다.", "fail");
		form.memberId.focus();
		return false;
	} else {
		showFieldMessage("#memberId-message", "");
	}

	if (!hasText(form.passwd.value)) {
		showFieldMessage("#passwd-message", "비밀번호는 필수 입력항목입니다.", "fail");
		form.passwd.focus();
		return false;
	} else {
		showFieldMessage("#passwd-message", "");
	}

	if (!hasText(form.name.value)) {
		showFieldMessage("#name-message", "이름은 필수 입력항목입니다.", "fail");
		form.name.focus();
		return false;
	} else {
		showFieldMessage("#name-message", "");
	}

	if (!hasText(form.email.value)) {
		showFieldMessage("#email-message", "이메일은 필수 입력항목입니다.", "fail");
		form.email.focus();
		return false;
	} else {
		showFieldMessage("#email-message", "");
	}

	// 아이디 사용 가능 여부
	if (!isId(form.memberId.value)) {
		showFieldMessage("#memberId-message", "아이디는 영문자, 숫자 조합 6~8자입니다.", "fail");
		form.memberId.focus();
		return false;
	} else {
		showFieldMessage("#memberId-message", "");
	}
	return true;

	// 비밀번호 사용 가능 여부
	if (!isNumber(form.passwd.value)) {
		showFieldMessage("#passwd-message", "비밀번호는 숫자 1~10자입니다.", "fail");
		form.passwd.focus();
		return false;
	} else {
		showFieldMessage("#passwd-message", "");
	}
	return true;


	// 핸드폰 번호 사용 가능 여부
	if (!isNumber(form.passwd.value)) {
		showFieldMessage("#passwd-message", "비밀번호는 숫자 1~10자입니다.", "fail");
		form.passwd.focus();
		return false;
	} else {
		showFieldMessage("#passwd-message", "");
	}
	return true;


	// 이메일 사용 가능 여부
	if (!isEmail(form.email.value)) {
		showFieldMessage("#email-message", "올바른 이메일 형식으로 작성해주세요", "fail");
		form.email.focus();
		return false;
	} else {
		showFieldMessage("#email-message", "");
	}
	return true;


	// 이름 사용 가능 여부
	if (!isName(form.name.value)) {
		showFieldMessage("#name-message", "이름은 한글 2~10자입니다.", "fail");
		form.name.focus();
		return false;
	} else {
		showFieldMessage("#name-message", "");
	}
	return true;


}

function showFieldMessage(selector, message, messageType) {
	const target = document.querySelector(selector);
	if (messageType === 'success') {
		target.className = 'text-success';
	} else {
		target.className = 'text-danger';
	}
	target.innerHTML = message;
}

function showGlobalMessage(target, message, messageType) {
	if (messageType === 'success') {
		target.className = 'alert alert-success  my-3 text-center';
	} else {
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

// 아이디 중복 여부 요청
function requestIdDupCheck(inputId) {
	const url = `/member/idcheck?id=${inputId}`;
	return fetch(url)
		.then((response) => {
			return response.json();
		});
}

// 이메일 중복 여부 요청
function requestEmailDupCheck(inputEmail) {
	const url = `/member/emailcheck?email=${inputEmail}`;
	return fetch(url)
		.then((response) => {
			return response.json();
		});
}


// 아이디 메세지 처리
async function idCheck(event) {
	let inputId = event.target.value;
	// console.log(inputId);
	if (!isId(inputId)) {
		showFieldMessage("#memberId-message", "아이디는 6~8자 사이의 영문자+숫자 조합입니다.", "fail");
	} else if (inputId.length >= 6 && inputId.length <= 8) {
		const result = await requestIdDupCheck(inputId);
		console.log(result);
		// 아이디 중복 경우..
		if (result) {
			showFieldMessage("#memberId-message", "이미 사용중인 아이디입니다.", "fail");
		} else if (!result) {
			showFieldMessage("#memberId-message", "사용 가능한 아이디입니다.", "success");
		}
	}
}

// 비밀번호 메세지 처리
async function pwCheck(event) {
	let inputPw = event.target.value;
	// console.log(inputId);
	if (!isNumber(inputPw)) {
		showFieldMessage("#passwd-message", "비밀번호는 4~8자 사이의 숫자입니다.", "fail");
	} else if (inputPw.length >= 4 && inputPw.length <= 8) {
		showFieldMessage("#passwd-message", "사용 가능한 비밀번호입니다.", "success");
	}
}

// 이름 메세지 처리
async function nameCheck(event) {
	let inputName = event.target.value;
	// console.log(inputId);
	if (!isName(inputName)) {
		showFieldMessage("#name-message", "이름은 2~10자 사이의 한글입니다.", "fail");
	} else if (inputName.length >= 2 && inputName.length <= 10) {
		showFieldMessage("#name-message", "사용 가능한 이름입니다.", "success");
	}
}

// 이메일 메세지 처리
async function emailCheck(event) {
	let inputEmail = event.target.value;
	if (!isEmail(inputEmail)) {
		showFieldMessage("#email-message", "올바른 이메일 형식으로 작성해주세요.", "fail");
	} else if (inputEmail.length >= 6 && inputEmail.length <= 30) {
		const result = await requestEmailDupCheck(inputEmail);
		console.log(result);
		// 이메일 중복 경우..
		if (result) {
			showFieldMessage("#email-message", "이미 사용중인 이메일입니다.", "fail");
		} else if (!result) {
			showFieldMessage("#email-message", "사용 가능한 이메일입니다.", "success");

		}
	}
}

// 핸드폰 번호 메세지 처리
async function hpCheck(event) {
	let inputHp = event.target.value;
	if (!isHp(inputHp)) {
		showFieldMessage("#hp-message", "번호를 11자로 작성해주세요.", "fail");
	} else if (inputHp.length >= 2 && inputName.length <= 10) {
		showFieldMessage("#hp-message", "사용 가능한 번호입니다.", "success");
	}
}




