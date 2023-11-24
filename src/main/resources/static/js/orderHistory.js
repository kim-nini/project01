// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("#order-history").addEventListener("click", orderHistory);
let title = document.querySelector("#title");
// 멤버아이디 가져오기
 let memberId = document.querySelector("#member-id").value;
let text;

// 가져온 리스트 뷰에 보여주기
async function orderHistory(event) {
		const list = await getOrderHistory();
		for (order of list) {
			for (key in order){
			// const option = document.createElement('option');
			// option.value = category.cateCode;
			// option.textContent = category.cateName;
			// subCategory.appendChild(option);
				console.log(key, order[key]);
				console.log(order["ORDER_ID"]);
			}
		}

}

// db에서 주문내역 리스트 불러오기
function getOrderHistory(){
	const url = `/order?memberId=${memberId}`;
	return fetch(url)
		.then((response) => {
			return response.json();
		});
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

