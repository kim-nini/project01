package com.ezen.grrreung.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data // 게터세터
@AllArgsConstructor
public class RequestParams {
    private int requestPage;    /** 사용자 요청 페이지 */
    private int elementSize;    /** 페이지에 보여지는 행 개수 */
    private int pageSize;       /** 페이지에 보여지는 페이지 개수 */
    private String search;      /** 검색값 */
    private int offset;         /** mySQL에 쓰일 offset */


    public RequestParams() {
        this(1, 5, 5, null, 0);
    }
    public RequestParams(int requestPage, int elementSize, int pageSize, String search){
        this.requestPage = requestPage;
        this.elementSize = elementSize;
        this.pageSize = pageSize;
        this.search =search;
        offsetResult();
    }

    public void offsetResult(){
        this.offset = (requestPage-1)*elementSize;
    };


    @Override
    public String toString() {
        return "RequestParams [requestPage=" + requestPage + ", elementSize=" + elementSize + ", pageSize=" + pageSize
                + ", search=" + search + "]";
    }
}
