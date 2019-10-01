package movielist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

//{ "/ML_Controller", "/ads" }
@WebServlet("/movielist/*")

public class ML_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int page = 1;
			
			if(request.getParameter("page")!=null)
				page = Integer.parseInt(request.getParameter("page"));
			
			request.setAttribute("pageNow", page);
			
			String service = request.getRequestURI().substring((
					request.getContextPath()+"/movielist/").length());
			if(service.equals(""))
				service="Movielist";
			String a = (service.charAt(0)+"").toUpperCase()+service.substring(1);			
			
			request.setAttribute("mainUrl", "movielist/"+a);

			
			MB_Action action = (MB_Action)Class.forName("movielist."+a).newInstance();
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
