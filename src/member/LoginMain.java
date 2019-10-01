package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import di.MB_Action;
import member.MemberDAO;
import member.MemberDTO;

public class LoginMain implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String msg = "로그인실패";
		
		//String goUrl = "..//"";
		
		MemberDTO dto = new MemberDAO().loginChk (request.getParameter("id"),request.getParameter("pw"));
		if(dto!=null) {

			if(dto.getId().equals(request.getParameter("id"))
					&&dto.getPw().equals(request.getParameter("pw"))) {
				
				request.getSession().setAttribute("userid", dto.getId());
				request.getSession().setAttribute("username", dto.getName());
				msg= request.getSession().getAttribute("username")+"로그인성공";
																		//성공시
				request.setAttribute("msg", msg);
				request.setAttribute("mainUrl", "main/Main");
			}

			//request.getSession().setAttribute("mem", dto);

		}else {
			request.setAttribute("msg", msg);
			request.setAttribute("mainUrl", "user/Login");//실패시
			}
		

	}

}
