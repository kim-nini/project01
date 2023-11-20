$(document).ready(function() {

   // 헤더 서브메뉴 마우스오버시 보여주기 이벤트
    $('.sub_nav_cont').hide();

    $('.headerMainMenu>ul>li').hover(function (){
       $(this).find('ul:not(:animated)').slideDown();

    }, function (){
        $(this).find('ul').slideUp();
        });


});


