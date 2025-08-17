package com.spring.web.board.paging;

public class Paging {
	
	private static final int VIEW_POSTS_NUM = 10; // 한 페이지당 게시글 수
	
	private static final int VIEW_PAGE_NUM = 10; // 한 화면에 보여줄 페이지 수
	// [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
	
	// [11] [12] [13] [14] [15] [16] [17] [18] [19] [20]
	
	private Integer totalPosts; // 총게시글 수 
	// DB에서 totalPosts를 얻어와야 한다.
	
	private Integer currentPage; // 현재 페이지 번호
	// 클라이언트에서 전송되어진 페이지 번호
	
	private Integer totalPage; // 게시판의 전체 페이지 수
	private Integer endPage; // 현재페이지의 끝번호
	private Integer startPage; // 현재페이지의 시작번호
	
	private boolean prev; // 이전버튼 여부
	private boolean next; // 다음버튼 여부
	// [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [다음]
	// [이전] [11] [12] [13] [14] [15] [16] [17] [18] [19] [20] [다음]
	// [이전] [21] [22]
	
	public Paging(Integer totalPosts, Integer currentPage) {
		
		if(currentPage != null) {
			this.currentPage = currentPage;
		}else {
			this.currentPage = 1;
		}
		
		this.totalPosts = totalPosts;
		
		// 페이지 번호를 만들어주는 메소드
		pagingMaker();
		
	}
	
	// 페이지 번호를 만들어주는 메소드
	private void pagingMaker() {
		
		// 전체 페이지수 totalPage 
		// totalPosts 총게시글수, VIEW_POSTS_NUM 페이지당 보여줄 글 수
		// 예를들어 총게시글수가 45개이고 페이지당 보여줄 글수는 10개
		// 전체 페이지수는 5페이지
		
		totalPage = ((totalPosts -1) / VIEW_POSTS_NUM) + 1;
		
		// 현재 페이지 유효성 처리
		if(currentPage < 1 || currentPage > totalPage) {
			currentPage = 1;
		}
		
		// 끝페이지 만들기
		// [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] 
		// [11] [12] [13] [14] [15] [16] [17] [18] [19] [20] 
		// [21] [22]
		// endPage 는 현재페이지와 한 화면에 보여줄 페이지 수를 사용해야 한다.
		
		endPage = (((currentPage -1) / VIEW_PAGE_NUM) +1) * VIEW_PAGE_NUM;
		
		// 끝페이지 유효성 처리
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		// 시작페이지 만들기
		// startPage
		
		startPage = ((currentPage -1) / VIEW_PAGE_NUM) * VIEW_PAGE_NUM + 1;
		
		
		// 이전버튼 활성화 여부
		prev = (startPage == 1) ? false : true;
		
		// 다음버튼 활성화 여부
		next = (endPage == totalPage) ? false : true;
		
	}

	public Integer getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(Integer totalPosts) {
		this.totalPosts = totalPosts;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	
	
	
}








