
    const mainCate = document.querySelector(".mainCategory");
    const subCategory = document.querySelector(".subCategory");

    mainCate.addEventListener("change", selectCategory);


    // db에서 불러온 서브 카테고리 화면에 추가해주기
    // option 동적 생성
   async function selectCategory(event){
        let array  = await categoryRequest();

        // for (category  of  array){
        //     console.log(category.cateName);
        // }

       array.forEach(category => {
           console.log(category.cateName);
       });

       array.forEach(category => {
       subCategory.innerHTML=
           "<option value='category.cateName'></option>";
       });

    }


    // 카테고리
    function categoryRequest() {
        const category = mainCate.options[mainCate.selectedIndex].value;

        const url =`/grrreung/sub-category?category=${category}`;

        return fetch(url)
            .then((response) => {
                return response.json();
            });
    }






// 카테고리명 출력
// function categoryRequest(mainCategory) {
//     const url = "/sub-category?category=${category.cateTop}";
//
//     return fetch(url)
//         .then((response) => {
//             return response.json();
//         });
// }

// // id 중복 체크 함수
// function idCheck(member) {
//     const url = "/idCheck?id=`${member.memberId}";
//     return fetch(url)
//         .then((response) => {
//             return response.json();
//         });
// }

// // 멤버 등록 함수 이벤트
// async function registerItem(event) {
//     event.preventDefault();
//     const form = event.target;
//
//     // 폼 필드에서 데이터 읽기
//
//     // 폼 데이터에 대한 유효성 검증 넣어줘야함***********************
//     const registerMember  = {// member 객체 생성
//         memberId: form.memberId.value,
//         passwd: form.passwd.value,
//         name: form.name.value,
//         email: form.email.value
//     };
//
//     const result = await registerRequest(registerMember);   // 비동기 통신하는 registerRequest함수호출
//     // console.log(memberJson);
//     // if(result) {
//     //
//     //     showResultMessage(target, `${member.name} 님 회원가입을 축하드립니다!!!`);
//     // } else {
//     //     showResultMessage(target, '서버 통신 오류!');
//     // }
// }
//
// // 회원 정보 등록 결과 보여주는 함수 이벤트
// async function showResultMessage(member) {
//     const resultDiv = document.querySelector("#resultDiv");
//     resultDiv.innerHTML=`${member.name} 님 회원가입을 축하드립니다!!!`;
// }
