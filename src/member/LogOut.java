package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

public class LogOut implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String msg= request.getSession().getAttribute("username")+"님 로그아웃";
		request.getSession().invalidate();
	
		//성공시
request.setAttribute("msg", msg);
request.setAttribute("mainUrl", "main/Main");
		

	}

}
