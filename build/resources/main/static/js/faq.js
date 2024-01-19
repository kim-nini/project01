

//스크롤수정
$(function() {
    $('.btn-fold').on('click', function(){
        if(!$(this).closest('.qna-item').hasClass('on')){
            $('.qna-item').removeClass('on').find('.answer-article').hide();
            $(this).closest('.qna-item').addClass('on').find('.answer-article').slideDown(300);
        } else {
            $(this).closest('.qna-item').removeClass('on').find('.answer-article').slideUp(300);
        }
    });
});
