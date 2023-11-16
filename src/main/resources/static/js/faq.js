$(function() {
    $('.btn-fold').on('click', function(){
        if(!$(this).closest('.qna-item').hasClass('on')){
            $('.qna-item').removeClass('on').find('.answer-article').hide();
             var oft = $(this).offset().top;
            $('html,body').stop().animate({scrollTop:oft - 250 }, 300)
            $(this).closest('.qna-item').addClass('on').find('.answer-article').slideDown(300)

        } else {
            $(this).closest('.qna-item').removeClass('on').find('.answer-article').slideUp(300)
        }
    })
});