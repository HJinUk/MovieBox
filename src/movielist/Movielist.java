package movielist;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;
import review.ReviewDAO;

public class Movielist implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int limit = 8; //한 페이지당 게시물 수
		int pageLimit = 4; //페이지 번호 갯수
		
		int page = (int)request.getAttribute("pageNow");
		
		int start = (page-1) * limit;  //게시물 시작 번호
		
		request.setAttribute("moviedata", new MovieListDAO().Nowlist(start, limit));
		
		request.getAttribute("moviedata");
		
		ArrayList<MovieListDTO> dto = new ArrayList<MovieListDTO>();
		
		dto.addAll(new MovieListDAO().Nowlist(start, limit));
		
		
		
		ArrayList<Integer> aa = new ArrayList<Integer>();
		//리스트 평점 계산
		for (MovieListDTO md : dto) {
			aa.add(md.getMid());
		}
		
		request.setAttribute("ReviewDetail", new ReviewDAO().Reviewlist(aa));
		
		int total = new MovieListDAO().Nowtotal();
		int pageTotal = total/limit;
		if(total%limit>0)
			pageTotal++;
		
		System.out.println("리스트 페이지 갯수" + pageTotal + ", DB 갯수" + total);
		
		int pageStart = (page-1)/pageLimit*pageLimit+1;
		int pageEnd = pageStart+pageLimit-1;
		
		if(pageEnd>pageTotal)
			pageEnd=pageTotal;
	
		request.setAttribute("start", start);

		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("pageTotal", pageTotal);
	}

}
