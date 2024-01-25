// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("#order-history").addEventListener("click", orderHistory);



let createTag = document.querySelector("#account-order-history");

// 가져온 리스트 뷰에 보여주기
async function orderHistory(event) {
	createTag.innerHTML = "";

	const dynamicContentContainer = createTag;
	const ordersData = await getOrderHistory();

	// 주문을 ORDER_ID를 기준으로 그룹화
	const groupedOrders = Array.isArray(ordersData)
		? ordersData.reduce((acc, order) => {
			const orderId = order.order_id;



			if (!acc[orderId]) {
				acc[orderId] = [];
			}

			acc[orderId].push(order);

			return acc;
		}, {})
		: {};


	// 데이터가 있을때만 생성
	if (ordersData.length > 0) {
		for (const orderId in groupedOrders) {
			if (groupedOrders.hasOwnProperty(orderId)) {
				const orders = groupedOrders[orderId];
				dynamicContentContainer.appendChild(generateDynamicHTML(orders, orderId));
			}
		}
	} else {
		// 없을때 출력

		const wrapperDiv = document.createElement('div');
		wrapperDiv.classList.add('wrapper');
		wrapperDiv.textContent='주문내역이 없습니다';
		createTag.appendChild(wrapperDiv);
		console.log('데이터가 없습니다.');
	}

	function generateDynamicHTML(data, orderId) {

		// 그룹화된 주문 출력 console.log 개발 완료후 삭제
		console.log(`ORDER_ID: ${orderId}`);

		// 주문한 상품의 갯수
		const orderAmounts = data.map(order => order.order_amount);
		const totalOrderAmount = orderAmounts.length;
		console.log(`order_amount : ${orderAmounts}`);
		// 주문한 상품의 총 금액
		const orderPrice = data.map(order => order.order_price);
		let totalOrderPrice = 0;
		orderPrice.forEach(sum => {
			totalOrderPrice += sum;
		});
		console.log(`totalOrderPrice: ${totalOrderPrice}`);

		// 주문 날짜(정규표현식 사용)
		const orderDate = data.map(order => order.order_date)[0].replace(/T|(\.\d{3})|(\+\d{2}:\d{2})/g, ' ');

		// 주문 상태
		const orderStatus = data.map(order => order.order_status)[0];

		const wrapperDiv = document.createElement('div');
		wrapperDiv.classList.add('wrapper');

		const accordianContainer = document.createElement('section');
		accordianContainer.classList.add('accordian-container');

		const accordianItem = document.createElement('div');
		accordianItem.classList.add('accordian-item');

		const accordianTitle = document.createElement('div');
		accordianTitle.classList.add('accordian-title');

		const leftDiv = document.createElement('div');
		leftDiv.classList.add('left');

		const titleDiv = document.createElement('div');
		titleDiv.classList.add('title');
		titleDiv.id = 'order-id';
		titleDiv.tagName ='orderId'
		titleDiv.textContent = `주문번호: ${orderId}`

		const itemCountDiv = document.createElement('div');
		itemCountDiv.classList.add('item-count');
		itemCountDiv.id = 'order-item-amount';
		// itemCountDiv.textContent =  `${totalOrderAmount}`;

		const totalDiv = document.createElement('div');
		totalDiv.classList.add('total');
		totalDiv.id = 'order-price-all';
		totalDiv.textContent = `총 주문금액: ${Number(totalOrderPrice).toLocaleString()}원`;

		const showhideDiv = document.createElement('div');
		showhideDiv.classList.add('showhide');
		showhideDiv.textContent = '상세보기';

		accordianTitle.appendChild(showhideDiv);

		leftDiv.appendChild(titleDiv);
		leftDiv.appendChild(itemCountDiv);
		leftDiv.appendChild(totalDiv);

		accordianTitle.appendChild(leftDiv);
		accordianTitle.appendChild(showhideDiv);

		accordianItem.appendChild(accordianTitle);

		const accordianContent = document.createElement('article');
		accordianContent.classList.add('accordian-content');

		const contentTitleDiv = document.createElement('div');
		contentTitleDiv.classList.add('title');

		const productDiv = document.createElement('div');
		productDiv.classList.add('product');
		productDiv.textContent = '상품 정보';

		const qtyDiv = document.createElement('div');
		qtyDiv.classList.add('qty');
		qtyDiv.textContent = '수량';

		const priceDiv = document.createElement('div');
		priceDiv.classList.add('price');
		priceDiv.textContent = '주문 금액';

		const returnsDiv = document.createElement('div');
		returnsDiv.classList.add('returns');
		returnsDiv.textContent = '주문처리상태';

		contentTitleDiv.appendChild(productDiv);
		contentTitleDiv.appendChild(qtyDiv);
		contentTitleDiv.appendChild(priceDiv);
		contentTitleDiv.appendChild(returnsDiv);

		accordianContent.appendChild(contentTitleDiv);


		for (const order of data) {
			const itemId = order.item_id;
			const itemName = order.item_name;
			const orderAmount = order.order_amount;
			const orderPrice = Number(order.order_price).toLocaleString() + '원';
			const orderStatus = order.order_status;
			const orderId = order.order_id;
			const writtenPost = order.writtenPost;
			const itemWrapperDiv = itemContent(itemName, orderAmount, orderPrice, orderStatus, orderId, itemId, writtenPost);
			console.log(`ITEM_NAME: ${itemName}, ORDER_AMOUNT: ${orderAmount}, ORDER_PRICE: ${orderPrice}, ORDER_STATUS: ${orderStatus}, ITEM_ID: ${itemId}`);
			accordianContent.appendChild(itemWrapperDiv);
		}



		accordianItem.appendChild(accordianContent);

		const accordianFooter = document.createElement('article');
		accordianFooter.classList.add('accordian-footer');

		const dateDiv = document.createElement('div');
		dateDiv.classList.add('date');
		dateDiv.textContent = `${orderDate}`;

		const rightDiv = document.createElement('div');
		rightDiv.classList.add('right');

		const statusDiv = document.createElement('div');
		statusDiv.classList.add('status');
		statusDiv.textContent = `주문처리상태: ${orderStatus}`;

		const successDiv = document.createElement('div');
		successDiv.classList.add('success');
		successDiv.textContent = "";

		const refDiv = document.createElement('div');
		refDiv.classList.add('ref');
		// refDiv.textContent = `Ref: ${data.reference}`;
		refDiv.textContent = '';

		statusDiv.appendChild(successDiv);

		rightDiv.appendChild(statusDiv);
		rightDiv.appendChild(refDiv);

		accordianFooter.appendChild(dateDiv);
		accordianFooter.appendChild(rightDiv);

		accordianItem.appendChild(accordianFooter);

		accordianContainer.appendChild(accordianItem);

		wrapperDiv.appendChild(accordianContainer);

		return wrapperDiv;


	}


	//-----------------------------템플릿 js
	function toggleClass(element, tClass) {
		tClass = tClass.replace(/\s/g, "");

		var classes = element.className;
		element.className = classes.indexOf(tClass) !== -1
			? classes.replace(" " + tClass, "")
			: classes + " " + tClass;
	}


	var showhide = document.getElementsByClassName("showhide");
	console.log(showhide)

	for (var i = 0; i < showhide.length; i++) {
		showhide[i].addEventListener('click', function () {
			var wrapper = this.closest(".accordian-item");
			toggleClass(wrapper, 'active2');
		}, false);
	}



}


// 아이템 출력 함수 생성
function itemContent(name, amount, price, status, orderId, itemId, writtenPost ) {
	const itemWrapperDiv = document.createElement('div');
	itemWrapperDiv.classList.add('item-wrapper');

	const productDiv = document.createElement('div');
	productDiv.classList.add('product');

	const productImage = document.createElement('img');
	productImage.src = "/thumbnail/"+itemId;
	productImage.alt = '';

	const productDetailDiv = document.createElement('div');
	productDetailDiv.classList.add('product-detail');
	productDetailDiv.id = 'item-name-value';
	productDetailDiv.textContent = name;

	// const warningDiv = document.createElement('div');
	// warningDiv.classList.add('warning');
	// warningDiv.textContent = itemId;
	//
	// productDetailDiv.appendChild(warningDiv);

	const itemIdInput = document.createElement('input');
	itemIdInput.style = 'display: none';
	itemIdInput.value = itemId;

	productDetailDiv.appendChild(itemIdInput);

	productDiv.appendChild(productImage);
	productDiv.appendChild(productDetailDiv);

	const qtyDiv = document.createElement('div');
	qtyDiv.classList.add('qty');

	const qtyWrapperDiv = document.createElement('div');
	qtyWrapperDiv.classList.add('qty-wrapper');
	qtyWrapperDiv.id = 'order-amount-value';

	const pElement = document.createElement('p');
	pElement.textContent = amount;

	qtyWrapperDiv.appendChild(pElement);
	qtyDiv.appendChild(qtyWrapperDiv);

	const priceDiv = document.createElement('div');
	priceDiv.classList.add('price');
	priceDiv.id = 'item-price-value';
	priceDiv.textContent = price;

	const returnsDiv = document.createElement('div');
	returnsDiv.classList.add('returns');
	returnsDiv.id = 'order-status-value';
	returnsDiv.textContent = status;

	// <a> 태그 생성
	const anchorTag = document.createElement('a');
	anchorTag.id = 'item-review';
	if ( writtenPost){
	anchorTag.textContent = '후기 작성';
	anchorTag.href = `/itemrev/create/${itemId}`;
	} else {
		anchorTag.textContent = '후기 보기';
		anchorTag.href = `/itemrev/myreview`;
	}

	// <a> 태그를 returnsDiv에 추가
	returnsDiv.appendChild(anchorTag);

	itemWrapperDiv.appendChild(productDiv);
	itemWrapperDiv.appendChild(qtyDiv);
	itemWrapperDiv.appendChild(priceDiv);
	itemWrapperDiv.appendChild(returnsDiv);

	return itemWrapperDiv;
}


// db에서 주문내역 리스트 불러오기
function getOrderHistory() {
	const url = `/order`;
	return fetch(url)
		.then((response) => {
			return response.json();
		});
}

