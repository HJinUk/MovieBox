package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;
import movielist.MovieListDAO;
import movielist.MovieListDTO;

public class Admin implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String msg="";
		
		if(request.getParameter("c")!=null) {
		
		if(request.getParameter("c").equals("m")) {
			request.setAttribute("url", "admovie.jsp");
		}else if(request.getParameter("c").equals("mm")){
			
			MovieListDTO dto = new MovieListDTO();
			dto.setName(request.getParameter("name"));
			dto.setStory(request.getParameter("story"));
			
			msg="영화 등록 성공";
			request.setAttribute("msg", msg);
			
			
			new MovieListDAO().insert(dto);
			
		}	
			
		}
	}

}
