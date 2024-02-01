let totalData; //총 데이터 수
let dataPerPage = 5; //한 페이지에 나타낼 글 수
let pageCount = 5; //페이징에 나타낼 페이지 수
let globalCurrentPage = 1; //현재 페이지
let dataList; //표시하려하는 데이터 리스트
let itemId = $("#itemId").text();

$(document).ready(function () {
    var slider = $("#slider");
    var thumb = $("#thumb");
    var slidesPerPage = 5; //globaly define number of elements per page
    var syncedSecondary = true;
    slider.owlCarousel({
        items: 1,
        slideSpeed: 2000,
        nav: false,
        autoplay: false,
        dots: false,
        loop: true,
        responsiveRefreshRate: 200
    }).on('changed.owl.carousel', syncPosition);
    thumb
        .on('initialized.owl.carousel', function () {
            thumb.find(".owl-item").eq(0).addClass("current");
        })
        .owlCarousel({
            items: slidesPerPage,
            dots: false,
            nav: true,
            item: 4,
            smartSpeed: 200,
            slideSpeed: 500,
            slideBy: slidesPerPage,
            navText: ['<svg width="18px" height="18px" viewBox="0 0 11 20"><path style="fill:none;stroke-width: 1px;stroke: #000;" d="M9.554,1.001l-8.607,8.607l8.607,8.606"/></svg>', '<svg width="25px" height="25px" viewBox="0 0 11 20" version="1.1"><path style="fill:none;stroke-width: 1px;stroke: #000;" d="M1.054,18.214l8.606,-8.606l-8.606,-8.607"/></svg>'],
            responsiveRefreshRate: 100
        }).on('changed.owl.carousel', syncPosition2);

    function syncPosition(el) {
        var count = el.item.count - 1;
        var current = Math.round(el.item.index - (el.item.count / 2) - .5);
        if (current < 0) {
            current = count;
        }
        if (current > count) {
            current = 0;
        }
        thumb
            .find(".owl-item")
            .removeClass("current")
            .eq(current)
            .addClass("current");
        var onscreen = thumb.find('.owl-item.active').length - 1;
        var start = thumb.find('.owl-item.active').first().index();
        var end = thumb.find('.owl-item.active').last().index();
        if (current > end) {
            thumb.data('owl.carousel').to(current, 100, true);
        }
        if (current < start) {
            thumb.data('owl.carousel').to(current - onscreen, 100, true);
        }
    }

    function syncPosition2(el) {
        if (syncedSecondary) {
            var number = el.item.index;
            slider.data('owl.carousel').to(number, 100, true);
        }
    }

    thumb.on("click", ".owl-item", function (e) {
        e.preventDefault();
        var number = $(this).index();
        slider.data('owl.carousel').to(number, 300, true);
    });


    // 수량 (+ , -)  조절
    $(".qtyminus").on("click", function () {
        var now = $(".qty").val();
        if ($.isNumeric(now) && parseInt(now) > 0) {
            now--;
            $(".qty").val(now).trigger("input");
        }
    });

    $(".qtyplus").on("click", function () {
        var now = $(".qty").val();
        if ($.isNumeric(now)) {
            $(".qty").val(parseInt(now) + 1).trigger("input");
        }
    });

    $(".qty").on("input", function () {
        var quantity = parseInt($(this).val()) || 0; // 수량
        var itemPrice = parseInt($(".totalAmount").val()) || 0; // 상품 가격

        // 계산된 총 가격을 표시할 곳
        var totalAmountPrint = $(".totalAmountPrint");

        var totalAmount = quantity * itemPrice;

        // 총 가격을 포맷팅하여 표시
        totalAmountPrint.text(new Intl.NumberFormat().format(totalAmount) + "원");
    });

    // **************************************************************************************
    // 상세정보,리뷰,상품문의 탭 이동
    let descTab = $('#desc_tab');
    let revTab = $('#review-tab');
    let qnaTab = $('#qna-tab');

    // 상세정보 탭
    descTab.click(function () {
        descTab.addClass('active');
        revTab.removeClass('active');
        qnaTab.removeClass('active');
        $('#description').addClass('active show');
        $('#review').removeClass('active show');
        $('#qna').removeClass('active show');
    });

    // 리뷰 탭
    revTab.click(function () {
        revTab.addClass('active');
        descTab.removeClass('active');
        qnaTab.removeClass('active');
        $('#review').addClass('active show');
        $('#description').removeClass('active show');
        $('#qna').removeClass('active show');

        dataPerPage = 5;
        console.log("아이템 아이디: " + itemId);
        console.log("데이터 개수 선택: " + dataPerPage);


        $.ajax({ // ajax로 데이터 가져오기
            method: "GET",
            url: "/itemrev/all-reviews?itemId=" + itemId,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            success: function (data) {

                // ajax 리뷰데이터 확인
                for (var i = 0; i < data.length; i++) {
                    console.log("글번호: " + data[i].rev_code
                        + " | 제목 : " + data[i].rec_title
                        + " | 작성자 : " + data[i].member_id
                        + " | 등록일 : " + data[i].rev_date
                        + " | 이미지패스 : " + data[i].image_path
                        + " [ITEM ID : " + data[i].item_id + "]");
                }

                //데이터 대입
                dataList = data;
                //totalData(총 데이터 수) 구하기
                totalData = dataList.length;
                //글 목록 표시 호출 (테이블 생성)
                displayData(1, dataPerPage);
                //페이징 표시 호출
                paging(totalData, dataPerPage, pageCount, 1);
            },
            error: function (request, status, error) {
                console.log("code:" + request.status + "\n" + "error:" + error);
            }
        });

    });

    qnaTab.click(async function () {
        qnaTab.addClass('active');
        revTab.removeClass('active');
        descTab.removeClass('active');
        $('#qna').addClass('active show');
        $('#description').removeClass('active show');
        $('#review').removeClass('active show');

        // dataPerPage = $("#dataPerPage").val();
        dataPerPage = 5;
        console.log("아이템 아이디: " + itemId);
        console.log("데이터 개수 선택: " + dataPerPage);


        await $.ajax({ // ajax로 데이터 가져오기
            method: "GET",
            url: "/itemqna/all-qna?itemId=" + itemId,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            data: {sessionInfo: "loginMember"},
            dataType: "json",
            success: function (response) {
                // console.log("ajax데이터 확인: " + data);
                response.forEach(function (data) {
                    console.log("글번호: " + data.qnaCode
                        + " | 제목 : " + data.qnaTitle
                        + " | 작성자 : " + data.memberId
                        + " | 등록일 : " + data.qnaDate
                        // + " | 이미지패스 : " + data[i].image_path
                        + " [ITEM ID : " + data.itemId + "]");
                });
                //데이터 대입
                dataList = response;
                //totalData(총 데이터 수) 구하기
                totalData = dataList.length;
                //글 목록 표시 호출 (테이블 생성)
                displayData(1, dataPerPage);
                //페이징 표시 호출
                paging(totalData, dataPerPage, pageCount, 1);
            },
            error: function (request, status, error) {
                console.log("code:" + request.status + "\n" + "error:" + error);
            }
        });

    });


    // **************************************************************************************


    //현재 페이지(currentPage)와 페이지당 글 개수(dataPerPage) 반영
    function displayData(currentPage, dataPerPage) {

        let chartHtml = "";

        //Number로 변환하지 않으면 아래에서 +를 할 경우 스트링 결합이 되어버림..
        currentPage = Number(currentPage);
        dataPerPage = Number(dataPerPage);

        let maxpnum = (currentPage - 1) * dataPerPage + dataPerPage; ///추가
        if (maxpnum > totalData) {
            maxpnum = totalData;
        } //추가

        for (var i = (currentPage - 1) * dataPerPage; i < maxpnum && i < dataList.length; i++) {
            // qna 데이터 일 경우
            if(dataList[i].rev_code == null){
                chartHtml +=
                    "<tr><td>" +
                    dataList[i].qnaCode +
                    "</td><td class='rev_title'>" +
                    dataList[i].qnaTitle +
                    (dataList[i].hasRe === true ? "<span style='color:red'> 답변완료 </span>" : "") +
                    "</td><td>" +
                    dataList[i].memberId +
                    "</td><td>" +
                    dataList[i].qnaDate +
                    "</td></tr>" +
                    "<tr class='rev_cont_wrap'><td colspan='4' class='rev_cont toggle-hide'>" +
                    "<p>" +
                    dataList[i].qnaCont +
                    "</p>" +
                    "<div class='re-div' value='" + dataList[i].qnaCode + "'>" ;

                // 문의에 답변이 있을경우 순회하면서 답변 요소를 동적으로 추가 ==============================================
                if(dataList[i].hasRe === true){

                dataList[i].qnaRes.forEach(function (qnaRe) {
                    chartHtml +=
                        // "<div class='re-div' value='" + dataList[i].qnaCode + "'>" +
                        "<div class='qna-re-style' value='" + qnaRe.reCode + "'>" +
                        "<p class='re-cont'>" + qnaRe.reCont + "</p>" +
                        "<p class='re-date'>" + qnaRe.reDate + "</p>";

                    // 관리자인 경우 수정 및 삭제 버튼 추가
                    if (dataList[i].member !== null && dataList[i].member.admin === 'Y') {
                        chartHtml +=
                            "<button onclick='updateQnaRe()' class='admin-btn' >수정</button>" +
                            "<button onclick='deleteQnaRe()' class='admin-btn' >삭제</button>";
                    }

                    chartHtml += "<hr></div>";
                });

                } // 답변유무 if문 end

                // 관리자인 경우 답변 등록 폼 추가
                if (dataList[i].member !== null && dataList[i].member.admin === 'Y') {
                    chartHtml +=
                        "<textarea placeholder='여기에 답변 내용을 입력하세요' type='text' name='reCont' class='re-ip' style='width: 80%'></textarea>" +
                        "<button name='reCreateBtn' onclick='sendQnaRe()' class='admin-btn sub-btn'>답변등록</button>";
                }

                chartHtml += "</div></td></tr>";

            } else { // review 데이터 일 경우
                chartHtml +=
                    "<tr><td>" +
                    dataList[i].rev_code +
                    "</td><td class='rev_title'>" +
                    dataList[i].rev_title +
                    "</td><td>" +
                    dataList[i].member_id +
                    "</td><td>" +
                    dataList[i].rev_date +
                    "</td></tr>" +
                    "<tr class='rev_cont_wrap'><td colspan='4' class='rev_cont toggle-hide'>" +
                    "<img class='rev-img' src='/itemrev/img/" + dataList[i].image_path + " 'onclick='showImageModal(this.src)'>" +
                    "<div id='imageModal' class='modal' onclick='closeImageModal()'>" +
                    "<img class='modal-content' id='modalImage'>" +
                    "</div>" +
                    "<p>" +
                    dataList[i].rev_cont +
                    "</p>" +
                    "</td></tr>";
            }

        } //dataList는 임의의 데이터임.. 각 소스에 맞게 변수를 넣어주면 됨...
        $(".review-board").html(chartHtml);
    }

    function paging(totalData, dataPerPage, pageCount, currentPage) {
        console.log("현재페이지 : " + currentPage);

        totalPage = Math.ceil(totalData / dataPerPage); //총 페이지 수

        if (totalPage < pageCount) {
            pageCount = totalPage;
        }

        let pageGroup = Math.ceil(currentPage / pageCount); // 페이지 그룹
        let last = pageGroup * pageCount; //화면에 보여질 마지막 페이지 번호

        if (last > totalPage) {
            last = totalPage;
        }

        let first = last - (pageCount - 1); //화면에 보여질 첫번째 페이지 번호
        let next = last + 1;
        let prev = first - 1;

        let pageHtml = "";

        if (prev > 0) {
            pageHtml += "<li class='page-item'><a href='#' class='page-link' id='prev'>&laquo;</a></li>";
        }

        //페이징 번호 표시
        for (var i = first; i <= last; i++) {
            if (currentPage == i) {
                pageHtml +=
                    "<li class='page-item'><a href='#' class='page-link'>" + i + "</a></li>";
            } else {
                pageHtml += "<li class='page-item'><a class='page-link'>" + i + "</a></li>";
            }
        }

        if (last < totalPage) {
            pageHtml += "<li class='page-item'><a class='page-link' id='next'>&rsaquo;</a></li>";
        }

        $(".pagination").html(pageHtml);

        // let displayCount = "";
        // displayCount = "현재 1 - " + totalPage + " 페이지 / " + totalData + "건";
        // $("#displayCount").text(displayCount);


        //페이징 번호 클릭 이벤트
        $(".pagination li a").click(function () {
            let $id = $(this).attr("id");
            selectedPage = $(this).text();

            if ($id == "next") selectedPage = next;
            if ($id == "prev") selectedPage = prev;

            //전역변수에 선택한 페이지 번호를 담는다...
            globalCurrentPage = selectedPage;
            //페이징 표시 재호출
            paging(totalData, dataPerPage, pageCount, selectedPage);
            //글 목록 표시 재호출
            displayData(selectedPage, dataPerPage);
        });

    }

    // $("#dataPerPage").change(function () {
    //     dataPerPage = $("#dataPerPage").val();
    //     //전역 변수에 담긴 globalCurrent 값을 이용하여 페이지 이동없이 글 표시개수 변경
    //     paging(totalData, dataPerPage, pageCount, globalCurrentPage);
    //     displayData(globalCurrentPage, dataPerPage);
    // });

});


// 리뷰 내용 페이지 안에서 보여주기 (페이지 이동하지 않고)
// 동적으로 생성한 요소 => document.on
$(document).on("click", ".rev_title", function () {
    // console.log("리뷰제목클릭");
    $(this).closest('tr').next().find('.rev_cont').slideToggle(300);
    $(this).closest('tr').next().find('.rev_cont').toggleClass('toggle-hide')
    $(".rev_title").not(this).closest('tr').next().find('.rev_cont').slideUp(300);
});

// 바로구매 버튼 클릭시
function toOrderSheet() {
    var form = document.getElementById("order-form");
    form.action = "/order/form"; // 바로구매를 처리하는 URL로 변경
    form.method = "get";

    form.submit();
}

