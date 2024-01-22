
// 리뷰 등록화면
// 파일 사이즈 체크 함수
function checkFileSize() {
    var fileInput = document.getElementById('revImg'); // 파일 입력 엘리먼트의 ID
    var maxSizeInBytes = 5 * 1024 * 1024; // 최대 허용 파일 크기 (5MB)

    if (fileInput.files.length > 0) {
        var fileSize = fileInput.files[0].size; // 선택된 파일의 크기

        if (fileSize > maxSizeInBytes) {
            alert('파일 크기가 너무 큽니다. 5MB 이하의 파일을 선택해주세요.');
            fileInput.value = ''; // 파일 선택 취소
        }
    }
}
// 파일 선택 시 미리보기
function previewImage(input) {
    var preview = document.getElementById('imagePreview');
    var file = input.files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }
}


//-----------------상세보기화면------------------------
/* 이미지를 확대해서 보여주기 위한 JavaScript 코드 */
function showImageModal(imageSrc) {
    var modal = document.getElementById('imageModal');
    var modalImage = document.getElementById('modalImage');

    modal.style.display = 'block';
    modalImage.src = imageSrc;
}

function closeImageModal() {
    var modal = document.getElementById('imageModal');
    modal.style.display = 'none';
}