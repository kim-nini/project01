
<h1>강아지 전용품 쇼핑몰 (Grr-reung) </h2>
<ul>
  <li>프로젝트 소개 : 일반적은 애완동물 쇼핑몰은 다양한 종류의 동물들로 상품선택이 어렵고 상품들이 <br>애완동물 전체에 일반화되어 있어 강아지 전문 쇼핑몰을 만들어 애견인들에게 도움을 주고자 시작하게 되었습니다.
  <li>개발 환경 : 
    <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
    <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=Spring Boot&logoColor=white" />
    <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat&logo=Javascript&logoColor=white" />
    <img src="https://img.shields.io/badge/AWS EC2-FF9900?style=flat&logo=Amazon EC2&logoColor=white" />
    <img src="https://img.shields.io/badge/AWS RDS-527FFF?style=flat&logo=Amazon RDS&logoColor=white" />
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white" />
  	<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" />
  	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
  </li>
  <li>배포 url : http://grrreung.shop:8090</li>
  <li>인원 : BE 3명</li>
</ul>

<h3>⏰개발 기간 및 작업 관리</h3>
<ul>
  <li>전체 개발 기간 : 2023.11.13 - 2023.12.08</li>
  <li>UI 구현 : 2023.11.13 - 2023.11.16</li>
  <li>기능 구현 : 2023.11.16 - 2023.12.08</li>
</ul>

<h3>🛠작업관리</h3>
<ul>
  <li>Discord를 사용하여 진행 상황을 공유했습니다.</li>
  <li>일일회의를 진행하며 작업 순서와 방향성에 대한 고민을 나누며 효율성 있게 작업하려고 노력했습니다.</li>
</ul>

<h3>ERD 소개</h3>
<img src="https://github.com/kim-nini/project01/assets/144875940/1d159e3b-f39b-4d1f-a56f-a66a20b49e2a" width="auto" height="auto"/>

<h3>👩‍💻 개발자 소개</h3>
<ul>
  <li>남지연
    <a href="https://velog.io/@duddjektjtro/posts">vlog</a>
  </li>
  <li>김현정
    <a href="https://velog.io/@hyunjeong9592/series">vlog</a>
  </li>
  <li>이혜린</li>
</ul>




<div align="center">
	

</div>


<div>

  <img src="https://www.notion.so/Hyunjeong-Kim-9c14e1bcf6e84258a3eaa55f0f9848c6?pvs=4#837586e336294989b24d3e85ae46c6fe"/>
🌱상품 상세보기 페이지

· 클라이언트 측에서는 + 버튼과 - 버튼을 클릭할 때마다 해당 상품의 수량이 증가하거나 감소하도록 JavaScript 이벤트 핸들러를 구현

⇒ 각 버튼을 클릭할 때마다 AJAX 요청을 서버에 보내어 해당 상품의 수량을 업데이트함

· DB에 저장된 [item_id]로 검색한 리뷰글 조회 +  페이징처리 및  비동기 처리 (JQuery,ajax)

⇒ 클라이언트와서버간의 통신을 REST API 를 통해 처리하고, 페이지의 깜빡거림 없이 자연스럽게 처리하기위해 비동기적으로 처리하여 서버로부터 동적으로 데이터를 가져옴
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b6c579e0-df36-417c-81b5-0173466b824a/e8e58e04-b867-48e9-9cbb-0f6606ac66d4/Untitled.gif)
🌱장바구니 페이지

· 장바구니 페이지에서 +, - 버튼으로 수량 조절시 DB에 있는 cart 테이블에서도 동시에 update됨

⇒ 서버에서는 수량이 업데이트된 상품의 정보를 데이터베이스에서 가져와 해당 상품의 수량을 업데이트함
- 사용자 경험 향상: + 버튼과 - 버튼을 통해 장바구니의 수량을 쉽게 조절할 수 있으므로 사용자가 원하는 수량을 빠르고 편리하게 변경할 수 있습니다.
- 실시간 반영: 사용자가 수량을 조절할 때마다 DB에 바로 반영되므로, 다른 사용자나 시스템에서도 실시간으로 변경된 수량을 확인할 수 있습니다.
- 데이터 일관성 유지: 장바구니 페이지와 DB 간의 실시간 동기화를 통해 데이터 일관성을 유지할 수 있습니다. 사용자가 장바구니를 닫거나 페이지를 다시 로드할 때마다 최신 정보를 확인할 수 있습니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b6c579e0-df36-417c-81b5-0173466b824a/2a8212f7-165c-49e5-b3ef-efd9923699cf/Untitled.gif)

🌱홈화면, 전체상품 조회 화면 포함

· 사용자가 입력한 검색어 또는 키워드를 기반으로 쿼리문 작성 

⇒ 사용자 경험 향상: 사용자가 특정 텍스트나 키워드로 원하는 결과를 검색할 수 있으므로, 원하는 정보를 빠르게 찾을 수 있음

· 쿼리문에는 검색어와 일치하는 결과를 찾도록 WHERE 절에 조건을 추가하고, 검색 결과를 페이징 처리하여 특정 페이지에 해당하는 결과만 반환하도록 LIMIT 절을 추가

⇒ 검색 결과 최적화: 페이징 처리를 통해 검색 결과를 여러 페이지로 나누어 표시함으로써, 사용자가 검색 결과를 보다 효율적으로 탐색할 수 있음

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b6c579e0-df36-417c-81b5-0173466b824a/e61f0af4-4e0c-4b68-a60d-bf7a4d303926/Untitled.gif)

🌱상품 등록 페이지

· 상품 등록 페이지에서는 RESTful API를 사용하여 상품 정보를 서버에 전달하고 저장

⇒ 표준화된 통신 방법: RESTful API를 사용하여 상품 정보를 전달하면, 클라이언트와 서버 간의 통신이 표준화되어 간편하고 일관된 방식으로 데이터를 전송할 수 있음

· 서버 측에서는 해당 요청을 수신하고, 받은 데이터를 디코딩하여 적절한 데이터베이스 쿼리를 사용하여 상품 정보를 저장

⇒ 유연성과 확장성: RESTful API를 사용하면 클라이언트와 서버가 독립적으로 개발될 수 있으며, 서버 측의 변경 없이 클라이언트 측을 업데이트할 수 있음
</div>
***






