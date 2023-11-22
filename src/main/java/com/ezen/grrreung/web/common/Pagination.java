package com.ezen.grrreung.web.common;

import lombok.Data;

@Data // 게터세터
public class Pagination {
    // 페이징 계산에 필요한 속성
    private RequestParams params;     /** 여러개의 파라메터 포장 */
    private int totalElements;        /** 테이블로부터 조회된 행의 수 */

    // 계산 결과 저장을 위한 필드
    private int totalPages;           /** 전체 페이지 수 */
    private int listNo;               /** 목록별 식별번호 */
    private int startPage;            /** 현재 페이지가 소속된 목록의 시작 번호 */
    private int endPage;              /** 현재 페이지가 소속된 목록의 마지막 번호 */
    private int previousStartPage;    /** 이전 페이지가 소속된 목록의 시작 번호 이전목록 */
    private int nextStartPage;        /** 다음 페이지가 소속된 목록의 마지막 번호 다음목록*/

    public Pagination(RequestParams params, int totalElements ) {
        // 생성자에서 받아 테이블 출력개수 카운트 해서 생성하기
        this.params = params;
        this.totalElements = totalElements;
        compute();
    }

    @Override
    public String toString() {
        return "Pagination [params=" + params + ", totalElements=" + totalElements + ", totalPages=" + totalPages
                + ", listNo=" + listNo + ", startPage=" + startPage + ", endPage=" + endPage + ", previousStartPage="
                + previousStartPage + ", nextStartPage=" + nextStartPage + "]";
    }

    /** 페이징 계산 */
    public void compute(){
        // 테이블로부터 검색된 행의 수에 따른 전체페이지수 계산
        totalPages = (int)Math.ceil((double)totalElements / params.getElementSize());
        // 나머지가 생길경우 한페이지가 생긴다는 뜻이므로 무조건
        // 올림으로 처리하는것이 필요함


        // 목록별 번호(1~5):0, (6~10):1, (11~15):2, .....
        // 목록별 번호를 그룹화 시킴
        listNo = (params.getRequestPage() - 1) / params.getPageSize();

        // 현재 페이지의 시작페이지번호와 마지막페이지번호 계산
        startPage = (listNo * params.getPageSize()) + 1;
        endPage = (listNo * params.getPageSize()) + params.getPageSize();
        if (endPage > totalPages){
            endPage = totalPages;
        }

        // 이전 목록의 시작페이지 번호 계산
        previousStartPage = startPage - params.getPageSize();
        // 첫번째 목록인 경우 1페이지로 설정
        if (previousStartPage < 0)  previousStartPage = 1;

        // 다음 목록의 시작페이지 번호 계산
        nextStartPage = startPage + params.getPageSize();
    }

    /** 현재 목록에서 [처음으로] 출력 여부 반환 */
    // 첫페이지에서 [처음으로] 출력 하지 않음
    public boolean isShowFirst() {
        return listNo > 0;
    }

    /** 현재 목록에서 [끝으로] 출력 여부 반환 */
    public boolean isShowLast() {
        return endPage < totalPages;
    }

    /** 현재 목록에서 [이전목록] 출력 여부 반환 */
    public boolean isShowPrevious() {
        return listNo > 0;
    }

    /** 현재 목록에서 [다음목록] 출력 여부 반환 */
    public boolean isShowNext() {
        return endPage < totalPages;
    }


    /** 테스트을 위한 main */
    public static void main(String[] args) {
        //  가상으로 사용자가 선택한 params
      RequestParams params = new RequestParams(1, 10, 10, null);
//        RequestParams params = new RequestParams(1, 5, 5, null);
// 위의 두가지 코드 비교해서 참고하기
        int tableRowCount = 156;
        // 가상의 row
        Pagination pagination = new Pagination(params, tableRowCount);

        System.out.println("테이블로부터 검색된 행수: " + pagination.getTotalElements());
        System.out.println("사용자 요청페이지: " + pagination.getParams().getRequestPage());
        System.out.println("전체페이지수: " + pagination.getTotalPages());

        System.out.println("현재목록의 시작페이지: " + pagination.getStartPage());
        System.out.println("현재목록의 끝페이지: " + pagination.getEndPage());

        System.out.println("처음으로 보여주기 여부: " + pagination.isShowFirst());
        System.out.println("이전목록 보여주기 여부: " + pagination.isShowPrevious());

        System.out.println("다음목록 보여주기 여부: " + pagination.isShowNext());
        System.out.println("끝으로 보여주기 여부: " + pagination.isShowLast());

        // JSP에서 페이지 번호 직접 출력 시
        if(pagination.isShowFirst()) {
            System.out.print("처음으로 ");
        }

        if(pagination.isShowPrevious()) {
            System.out.print("이전목록 ");
        }

        for(int i=pagination.getStartPage(); i<=pagination.getEndPage(); i++){
            System.out.print(i + " | ");
        }

        if(pagination.isShowNext()) {
            System.out.print("다음목록 ");
        }

        if(pagination.isShowLast()) {
            System.out.print("끝으로 ");
        }

        System.out.println();


        System.out.println("-----------------------------------------------");

        // 이름으로 검색 시
        RequestParams searchParams = new RequestParams(1, 10, 5, null);
        //RequestParams searchParams = new RequestParams(1, 10, 5, "bangry");
        int searchCount = 11;
        Pagination pagination2 = new Pagination(searchParams, searchCount);
        System.out.println("검색된 행수: " + pagination2.getTotalElements());
        System.out.println("요청페이지: " + pagination2.getParams().getRequestPage());
        System.out.println("전체페이지수: " + pagination2.getTotalPages());

    }
}
