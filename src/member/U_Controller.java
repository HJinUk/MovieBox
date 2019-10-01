package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

//{ "/ML_Controller", "/ads" }
@WebServlet("/user/*")

public class U_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String service = request.getRequestURI().substring((
					request.getContextPath()+"/user/").length());
			
			
			String a = (service.charAt(0)+"").toUpperCase()+service.substring(1);			
			
			request.setAttribute("mainUrl", "user/"+a);

			
			MB_Action action = (MB_Action)Class.forName("member."+a).newInstance();
			action.excute(request, response);

			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../view/template.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {

		}
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
