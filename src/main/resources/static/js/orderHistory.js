// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("#order-history").addEventListener("click", orderHistory);
let title = document.querySelector("#title");

// 멤버아이디 가져오기
let memberId = document.querySelector("#member-id").value;

// 데이터 출력할 태그 선택
let createTag = document.querySelector("#account-order-history");



// 가져온 리스트 뷰에 보여주기
async function orderHistory(event) {
	createTag.innerHTML = "";
	const orderHistoryList = await getOrderHistory();


	// 데이터가 있을때만 생성
	if (orderHistoryList.length > 0) {
		const dynamicContentContainer = createTag;
		//orderHistoryList.forEach(orderData => {
		for (order of orderHistoryList) {
			let item_name, order_amount, order_price, order_status;
			dynamicContentContainer.appendChild(generateDynamicHTML(orderHistoryList));
		//});
		}// END OF OUTER FOR
	} else {
		// 없을때 출력
		console.log('No data available.');
	}



	// 데이터가 있을 때 HTML을 동적으로 생성하는 함수
	function generateDynamicHTML(data) {
		// .wrapper div 생성
		const wrapperDiv = document.createElement('div');
		wrapperDiv.classList.add('wrapper');

		// .accordian-container 생성
		const accordianContainer = document.createElement('section');
		accordianContainer.classList.add('accordian-container');

		// .accordian-item 생성
		const accordianItem = document.createElement('div');
		accordianItem.classList.add('accordian-item');

		// .accordian-title 생성
		const accordianTitle = document.createElement('div');
		accordianTitle.classList.add('accordian-title');

		// .left div 생성
		const leftDiv = document.createElement('div');
		leftDiv.classList.add('left');

		// .title, .item-count, .total 생성
		const titleDiv = document.createElement('div');
		titleDiv.classList.add('title');
		titleDiv.id = 'order-id';
		titleDiv.textContent = '주문 번호';

		const itemCountDiv = document.createElement('div');
		itemCountDiv.classList.add('item-count');
		itemCountDiv.id = 'order-item-amount';
		itemCountDiv.textContent = '주문아이템 갯수';

		const totalDiv = document.createElement('div');
		totalDiv.classList.add('total');
		totalDiv.id = 'order-price-all';
		totalDiv.textContent = 'Total 총 주문금액';

		// .showhide div 생성
		const showhideDiv = document.createElement('div');
		showhideDiv.classList.add('showhide');
		showhideDiv.textContent = 'View';

		// .showhide div를 .accordian-title에 추가
		accordianTitle.appendChild(showhideDiv);

		// .left div에 .title, .item-count, .total 추가
		leftDiv.appendChild(titleDiv);
		leftDiv.appendChild(itemCountDiv);
		leftDiv.appendChild(totalDiv);

		// .left div와 .showhide div를 .accordian-title에 추가
		accordianTitle.appendChild(leftDiv);
		accordianTitle.appendChild(showhideDiv);

		// .accordian-title을 .accordian-item에 추가
		accordianItem.appendChild(accordianTitle);

		// .accordian-content 생성
		const accordianContent = document.createElement('article');
		accordianContent.classList.add('accordian-content');

		// .title div 생성
		const contentTitleDiv = document.createElement('div');
		contentTitleDiv.classList.add('title');

		// .product, .qty, .price, .returns 생성
		const productDiv = document.createElement('div');
		productDiv.classList.add('product');
		productDiv.textContent = '상품 정보(상품명)';

		const qtyDiv = document.createElement('div');
		qtyDiv.classList.add('qty');
		qtyDiv.textContent = '수량';

		const priceDiv = document.createElement('div');
		priceDiv.classList.add('price');
		priceDiv.textContent = '상품가격*수량 금액';

		const returnsDiv = document.createElement('div');
		returnsDiv.classList.add('returns');
		returnsDiv.textContent = '주문처리상태';

		// .product, .qty, .price, .returns를 .title에 추가
		contentTitleDiv.appendChild(productDiv);
		contentTitleDiv.appendChild(qtyDiv);
		contentTitleDiv.appendChild(priceDiv);
		contentTitleDiv.appendChild(returnsDiv);

		// .title을 .accordian-content에 추가
		accordianContent.appendChild(contentTitleDiv);






		// 데이터 출력 하는 for문

		// 아이템 내용 출력 start
			for (key in order){

				item_name = order["ITEM_NAME"]
				order_amount = order["ORDER_AMOUNT"]
				order_price = order["ORDER_PRICE"]
				order_status = order["ORDER_STATUS"]


			} // END OF INNER FOR

			// console.log(key, order[key]);
			// console.log(order["ORDER_ID"]);
			// 주문 아이템들을 동적으로 생성

		itemContent(item_name, order_amount, order_price, order_status, accordianContent);




		// .accordian-content을 .accordian-item에 추가
		accordianItem.appendChild(accordianContent);

		// .accordian-footer 생성
		const accordianFooter = document.createElement('article');
		accordianFooter.classList.add('accordian-footer');

		// .date, .right 생성
		const dateDiv = document.createElement('div');
		dateDiv.classList.add('date');
		dateDiv.textContent = `Date: ${data.date}`;

		const rightDiv = document.createElement('div');
		rightDiv.classList.add('right');

		const statusDiv = document.createElement('div');
		statusDiv.classList.add('status');
		statusDiv.textContent = 'Status:';

		const successDiv = document.createElement('div');
		successDiv.classList.add('success');
		successDiv.textContent = data.status;

		const refDiv = document.createElement('div');
		refDiv.classList.add('ref');
		refDiv.textContent = `Ref: ${data.reference}`;

		// .status div에 .success div 추가
		statusDiv.appendChild(successDiv);

		// .right div에 .status div, .ref div 추가
		rightDiv.appendChild(statusDiv);
		rightDiv.appendChild(refDiv);

		// .date, .right을 .accordian-footer에 추가
		accordianFooter.appendChild(dateDiv);
		accordianFooter.appendChild(rightDiv);

		// .accordian-footer을 .accordian-item에 추가
		accordianItem.appendChild(accordianFooter);

		// .accordian-item을 .accordian-container에 추가
		accordianContainer.appendChild(accordianItem);

		// .accordian-container을 .wrapper에 추가
		wrapperDiv.appendChild(accordianContainer);

		return wrapperDiv;
	}







	// -----------------------------템플릿 js
	function toggleClass(element, tClass) {
		tClass = tClass.replace(/\s/g, "");

		var classes =  element.className;
		element.className = classes.indexOf(tClass) !== -1
			? classes.replace(" " + tClass, "")
			: classes + " " + tClass;
	}



	var showhide = document.getElementsByClassName("showhide");

	console.log(showhide)

	showhide[0].addEventListener('click', function() {
		var wrapper = showhide[0].closest(".accordian-item");
		console.log(wrapper)
		toggleClass(wrapper, 'active2');
	}, false);



	// order["ITEM_NAME"];
}// end of orderHistory

// 아이템 출력 함수 생성
function itemContent(name, amount, price, status, accordianContent){
	const itemWrapperDiv = document.createElement('div');
	itemWrapperDiv.classList.add('item-wrapper');

	const productDiv = document.createElement('div');
	productDiv.classList.add('product');

	const productImage = document.createElement('img');
	productImage.src = '../../../../../../upload/item01_image01.png';
	productImage.alt = '';

	const productDetailDiv = document.createElement('div');
	productDetailDiv.classList.add('product-detail');
	productDetailDiv.id = 'item-name-value';
	productDetailDiv.textContent = item_name;

	const warningDiv = document.createElement('div');
	warningDiv.classList.add('warning');
	warningDiv.textContent = 'You have already confirmed a return for this product';

	productDetailDiv.appendChild(warningDiv);

	productDiv.appendChild(productImage);
	productDiv.appendChild(productDetailDiv);

	const qtyDiv = document.createElement('div');
	qtyDiv.classList.add('qty');

	const qtyWrapperDiv = document.createElement('div');
	qtyWrapperDiv.classList.add('qty-wrapper');
	qtyWrapperDiv.id = 'order-amount-value';

	const pElement = document.createElement('p');
	pElement.textContent = order_amount;

	qtyWrapperDiv.appendChild(pElement);
	qtyDiv.appendChild(qtyWrapperDiv);

	const priceDiv = document.createElement('div');
	priceDiv.classList.add('price');
	priceDiv.id = 'item-price-value';
	priceDiv.textContent = order_price;

	const returnsDiv = document.createElement('div');
	returnsDiv.classList.add('returns');
	returnsDiv.id = 'order-status-value';
	returnsDiv.textContent = order_status;

	itemWrapperDiv.appendChild(productDiv);
	itemWrapperDiv.appendChild(qtyDiv);
	itemWrapperDiv.appendChild(priceDiv);
	itemWrapperDiv.appendChild(returnsDiv);


	accordianContent.appendChild(itemWrapperDiv);


	// 아이템 내용 출력 end
}


// db에서 주문내역 리스트 불러오기
function getOrderHistory(){
	const url = `/order?memberId=${memberId}`;
	return fetch(url)
		.then((response) => {
			return response.json();
		});
}


