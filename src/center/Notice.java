package center;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;
import center.CenterDAO;

public class Notice implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		int limit = 8;			//한 페이지당 게시물 수
		int pageLimit = 4;		//페이지 번호 갯수
		
		int page = (int)request.getAttribute("page");
		
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		int start = (page-1) * limit;  //게시물 시작 번호
		
		request.setAttribute("data", new CenterDAO().list(start, limit));

		System.out.println("ccccccccccccccccccccccccccccccccc");
		////>>>>>>>>>>>>>>페이지번호
		
		int total =  new CenterDAO().total();
		int pageTotal = total/limit;
		if(total%limit>0)
			pageTotal++;
		
		System.out.println("ddddddddddddddddddddddddddddddddddddd");
		//System.out.println(pageTotal+","+total);
		
		int pageStart = (page-1)/pageLimit*pageLimit+1;
		int pageEnd = pageStart +pageLimit -1;
		
		if(pageEnd>pageTotal)
			pageEnd=pageTotal;
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		
		request.setAttribute("start", start);
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("pageTotal", pageTotal);
		
	}

}
