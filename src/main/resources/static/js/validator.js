/**
 * 값 입력 여부
 * @param {string} 입력 문자열
 * @returns 문자열 입력 여부
 */
function hasText(value) {
    if (value === undefined || value.length === 0) {
        return false;
    }
    return true;
}

/**
 * 아이디(6~8자) 사용 가능 여부
 * @param {string} 입력 아이디
 * @returns 아이디 사용 가능 여부
 */
function isId(value) {
    const regExp = /^[a-zA-Z]+[0-9a-zA-Z]{5,7}$/g;
    return regExp.test(value);
}


/**
 * 비밀번호(숫자) 입력 여부
 * @param {string} 입력 문자열
 * @returns 숫자 여부
 */
function isNumber(value) {
    let regExp = /^[0-9]*$/;
    return regExp.test(value);
}


/**
 * 한글 이름 입력 여부
 * @param {string} 입력 문자열
 * @returns 이름 입력 여부
 */
function isName(value) {
    let regExp = /^[가-힣]+$/;
    if (!regExp.test(value)) {
        return false;
    } else if (value.length < 2 || value.length > 10) {
        return false;
    }
    return true;
}


/**
 * 핸드폰 번호 입력 여부
 * @param {string} 입력 문자열
 * @returns 핸드폰 번호 사용 가능 여부
 */
function isHp(value) {
    var regExp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
    if (!regExp.test(value)) {
        return false;
    } else if (value.length < 11 || value.length > 11) {
        return false;
    }
    return true;
}

/**
 * 이메일 사용 가능 여부
 * @param {string} 입력 이메일
 * @returns 이메일 사용 가능 여부
 */
function isEmail(value) {
    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    return regExp.test(value);
}



