package reserve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

//{ "/ML_Controller", "/ads" }
@WebServlet("/reserve/*")

public class R_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String service = request.getRequestURI().substring((
					request.getContextPath()+"/reserve/").length());
			if(service.equals(""))
				service="Reserve";
			String a = (service.charAt(0)+"").toUpperCase()+service.substring(1);			
			
			request.setAttribute("mainUrl", "reserve/"+a);

			
			MB_Action action = (MB_Action)Class.forName("reserve."+a).newInstance();
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
