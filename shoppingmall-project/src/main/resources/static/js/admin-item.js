document.querySelector("button").addEventListener('click', function() {
    console.log('버튼이 클릭되었습니다.');
}, false);

    const mainCate = document.querySelector(".mainCategory");
    const subCategory = document.querySelector(".subCategory");

    // 메인 카테고리 select box에 change 이벤트 추가
    mainCate.addEventListener("change", selectCategory);


    // db에서 불러온 서브 카테고리 화면에 추가해주기
    // option 동적 생성
   async function selectCategory(event){
       subCategory.innerHTML = "";

       let array  = await categoryRequest();

        for (category  of  array) {
            // console.log(category.cateName);
            const option = document.createElement('option');
            option.value = category.cateCode;
            option.textContent = category.cateName;
            subCategory.appendChild(option);
        }

       // subCategory.value.innerHTML = `${category.cateName}`;
       //  array.forEach(category => {
       //     console.log(category.cateName);
       // });
    }

    // 상세 카테고리이름 불러오기
   function categoryRequest() {
        const category = mainCate.options[mainCate.selectedIndex].value;
        const url =`/grrreung/sub-category?category=${category}`;
        return fetch(url)
            .then((response) => {
                return response.json();
            });
   }



//==========================================================================================================

document.querySelector('#uploadfiles1').addEventListener('change', previewImages1);
document.querySelector('#uploadfiles2').addEventListener('change', previewImages2);
var selectedThumbnail = null;

const previewContainer1 = document.querySelector('#image-container1>ul');
const previewContainer2 = document.querySelector('#image-container2>ul');
function previewImages1(event) {
    previewContainer1.innerHTML = ""; // 기존에 있던 미리보기 파일 지우기

    for (var image of event.target.files) {
        var reader = new FileReader();

        reader.onload = function (event) {
            var img = document.createElement("img");
            var li = document.createElement("li");
            var a = document.createElement("a");
            previewContainer1.classList.add('preview-ul');
            img.setAttribute("src", event.target.result);
            img.setAttribute("class", "preview-image");

            img.addEventListener("click", function () {
                // 이미지 클릭 시 다른 썸네일 선택 제한
                if (selectedThumbnail !== null) {
                    selectedThumbnail.classList.remove("selected");
                }

                // 현재 썸네일 선택 상태 업데이트
                selectedThumbnail = img;

                // 이미지 클릭 시 선택된 이미지에 border 클래스를 추가
                img.classList.add("selected");
            });

            previewContainer1.appendChild(li).appendChild(a).appendChild(img);
        };

        reader.readAsDataURL(image);
    }
}


function previewImages2(event) {
    previewContainer2.innerHTML = ""; // 기존에 있던 미리보기 파일 지우기

    for (var image of event.target.files) {
        var reader = new FileReader();

        reader.onload = function (event) {
            var img = document.createElement("img");
            var li = document.createElement("li");
            var a = document.createElement("a");
            previewContainer2.classList.add('preview-ul');
            img.setAttribute("src", event.target.result);
            img.setAttribute("class", "preview-image");

            img.addEventListener("click", function () {
                // 이미지 클릭 시 다른 썸네일 선택 제한
                if (selectedThumbnail !== null) {
                    selectedThumbnail.classList.remove("selected");
                }

                // 현재 썸네일 선택 상태 업데이트
                selectedThumbnail = img;

                // 이미지 클릭 시 선택된 이미지에 border 클래스를 추가
                img.classList.add("selected");
            });

            previewContainer2.appendChild(li).appendChild(a).appendChild(img);
        };

        reader.readAsDataURL(image);
    }
}


