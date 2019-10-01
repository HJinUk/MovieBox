package movielist;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import di.MB_Action;
import review.ReviewDAO;
import review.ReviewDTO;

public class MDetail implements MB_Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		request.setAttribute("mid", mid);
		
		MovieListDTO dto = new MovieListDAO().Detail(mid);
		
		request.setAttribute("MovieDetail", new MovieListDAO().Detail(mid));
		request.setAttribute("GenDetail", new GenresDAO().Genlist(dto.genre1, dto.genre2, dto.genre3, dto.genre4));

		int limit = 4; //한 페이지당 게시물 수
		int pageLimit = 4; //페이지 번호 갯수
		
		int page = (int)request.getAttribute("pageNow");
		
		int start = (page-1) * limit;  //게시물 시작 번호
		
		request.setAttribute("ReviewDetail", new ReviewDAO().Reviewlist(mid));
		request.setAttribute("ReviewPage", new ReviewDAO().Reviewlist(mid, start, limit));
		
		int total = new ReviewDAO().total(mid);
		int pageTotal = total/limit;
		if(total%limit>0)
			pageTotal++;
		
		System.out.println("페이지 총 갯수" + pageTotal + ", 총 갯수" + total);

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
