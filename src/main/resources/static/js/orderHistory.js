// 이벤트 타겟에 이벤트 리스너 등록
document.querySelector("#order-history").addEventListener("click", orderHistory);
let title = document.querySelector("#title");
// 멤버아이디 가져오기
 let memberId = document.querySelector("#member-id").value;
let text;

// 가져온 리스트 뷰에 보여주기
async function orderHistory(event) {
	try {
		const map = await getOrderHistory();

		// 여기서 map은 객체라고 가정합니다.
		const orderId = map["ORDER_ID"];
		console.log(orderId);
		title.innerHTML = orderId;
	} catch (error) {
		console.error("Error fetching order history:", error);
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


