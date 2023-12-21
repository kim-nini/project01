$(document).ready(function () {
    // 초기화면 출력시 전체checked 속성 부여하기, 전체선택 check box도 포함
    $('#all_chk').prop('checked', true);
    $('[name="item_chk"]').prop('checked', true);
    calculateTotalPrice();


    function pay_total_func(){
        //2번 단
        var amount_total=0;
        var converse_unit=0;
        $('.cart_list li').each(function() {
            //console.log($(this).find('.price_amount').text());
            converse_unit=$(this).find('.price_amount').text().replace(/[^0-9]/g,"");
            amount_total=amount_total+(parseInt(converse_unit)|| 0);
            //총 상품금액
            //console.log(amount_total);
        });
        //총 상품금액
        //var total_amount_money = $('.cart_total_price').children().find('.item_price').text();
        var total_amount_money =$('.cart_total_price').children().find('.item_price').text(amount_total.toLocaleString());
        //할인금액
        var total_sale_money = parseInt($('.cart_total_price').children().find('.sale_price').text().replace(/[^0-9]/g,"")|| 0);
        // console.log(total_sale_money);
        //총 배송비
        var total_delivery_price = parseInt($('.cart_total_price').children().find('.delivery_price').text().replace(/[^0-9]/g,"")|| 0);
        // console.log(total_delivery_price);
        //총 결제금액
        var total_price=(parseInt(amount_total|| 0)-total_sale_money+total_delivery_price);
        var total_total_price = $('.cart_total_price').children().find('.total_price').text(total_price.toLocaleString());

    }



    // 합계 업데이트 함수
    function updateTotal() {
        var total = 0;
        var checkboxes = document.querySelectorAll('[name="item_chk"]:checked');
        checkboxes.forEach(function (checkbox) {
            var row = checkbox.parentElement.parentElement;
            var amount = parseInt(row.querySelector('.number').value);
            var itemPrice = parseInt(row.querySelector('.itemPrice').value);
            total += amount * itemPrice;
        });

        calculateTotalPrice(total); // Pass the total to the calculateTotalPrice function
        var totalElement = document.querySelector('.total_price');
        totalElement.innerText = total;
    }

    document.getElementById('all_chk').addEventListener('change', function () {
        var checkboxes = document.querySelectorAll('[name="item_chk"]');
        checkboxes.forEach(function (checkbox) {
            checkbox.checked = this.checked;
        });
        updateTotal();
    });


    document.getElementsByName('all_chk')[0].addEventListener('change', function () {
        /* 체크박스 체크/해제 */
        if ($("input[name='all_chk']").prop("checked")) {
            $("input[name='item_chk']").prop("checked", true);
        } else {
            $("input[name='item_chk']").prop("checked", false);
        }
    });


    // 개별 상품 체크박스 클릭 시
    document.querySelectorAll('[name="item_chk"]').forEach(function (checkbox) {
        checkbox.addEventListener('click', function () {
            updateTotal();
        });
    });


    $(".minus_btn").on("click", function () {
        updateQuantity(-1, $(this));
        updateCheckboxState($(this));
        calculateTotalPrice(); // Update total price after clicking "-"
    });

    $(".plus_btn").on("click", function () {
        updateQuantity(1, $(this));
        updateCheckboxState($(this));
        calculateTotalPrice(); // Update total price after clicking "+"
    });

    $(".number").on("input", function () {
        calculateTotalPrice(); // Update total price when the quantity changes manually
    });
    function updateCheckboxState(button) {
        var $checkbox = button.closest("li").find('[name="item_chk"]');
        $checkbox.prop("checked", true);
        updateTotal();
    }
    // Update total price when a checkbox is changed
    document.querySelectorAll('[name="item_chk"]').forEach(function (checkbox) {
        checkbox.addEventListener('change', function () {
            calculateTotalPrice();
        });
    });






    function updateQuantity(change, button) {
        var $quantityInput = button.siblings(".number");
        var currentQuantity = parseInt($quantityInput.val()) || 0;
        var newQuantity = currentQuantity + change;

        if (newQuantity >= 0 && newQuantity <= 30) {
            $quantityInput.val(newQuantity).trigger("input");
        }
    }

    function calculateTotalPrice() {
        var totalAmount = 0;

        $(".cart_list li").each(function () {
            var $item = $(this);
            var $checkbox = $item.find('[name="item_chk"]');
            var isChecked = $checkbox.is(":checked");

            var quantity = parseInt($item.find(".number").val()) || 0;
            var itemPrice = parseInt($item.find(".itemPrice").val()) || 0;

            var itemTotalAmount = quantity * itemPrice;

            if (isChecked) {
                totalAmount += itemTotalAmount;
            }

            $item.find(".price_amount").text(new Intl.NumberFormat().format(itemTotalAmount) + "원");
        });

        var totalAmountPrint = $("#totalAmountPrint");
        totalAmountPrint.text(new Intl.NumberFormat().format(totalAmount) + "원");

        // Call your function to update the total price in the cart
        pay_total_func();
    }



    // 장바구니 수량 업데이트
    // const memberId = $("#memberId").text();
    // console.log("장바구니 멤버아이디: " + memberId);

    $(".cart-action-btn").click(function () {
        let cartId = $(this).siblings("#cartId").text();
        console.log("선택한 아이템의 카트아이디 : " + cartId);
        let action = $(this).hasClass("plus_btn") ? "plus" : "minus";

        // AJAX 요청을 통해 백엔드 컨트롤러에 데이터 전송
        $.ajax({
            type: "GET",
            url: "/grrreung/cart/amount-" + action,
            data: { cartId: cartId },
            success: function () {
                // 성공 시 페이지의 장바구니 수량 업데이트
                // updateCartAmount(itemId, action);
            },
            error: function (xhr, status, error) {
                console.error("장바구니 수량 업데이트 에러:", error);
            }
        });
    });

    // 페이지의 장바구니 수량 업데이트를 위한 함수
    function updateCartAmount(itemId, action) {
        var cartAmountInput = $("input.cart-amount[data-item-id='" + itemId + "']");
        var currentAmount = parseInt(cartAmountInput.val());

        if (action === "plus") {
            currentAmount++;
        } else if (action === "minus" && currentAmount > 1) {
            currentAmount--;
        }

        // 업데이트된 수량을 페이지에 반영
        cartAmountInput.val(currentAmount);
    }

});


function goToOrder() {

    // 체크된 상품들의 체크박스를 선택
    var selectedCheckboxes = document.querySelectorAll('input[name="item_chk"]:checked');

    if(selectedCheckboxes.length === 0 ){

        alert("주문하실 상품을 선택 해 주세요.")

    } else {

        let param = ''

        // 체크박스의 value(itemId) 가져와서 param에 담기
        selectedCheckboxes.forEach(function (checkbox) {
            param += `itemId=${checkbox.value}&`;
        });

        // 주문서 작성화면으로 get매핑
        window.location.href = `/grrreung/order/form?${param}`;

    }
}



























