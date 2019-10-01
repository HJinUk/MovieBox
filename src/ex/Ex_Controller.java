package ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;
import theater.TheaterDAO;
import theater.TheaterDTO;

//{ "/ML_Controller", "/ads" }
@WebServlet("/view/ex/ex2")

public class Ex_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		response.setContentType("text/text;charset=euc-kr");
			
			PrintWriter out =response.getWriter();
			String jj="[";
			
			ArrayList<TheaterDTO> res = new TheaterDAO().arealist();

			
			for(int i =0;i<res.size(); i++){
				jj+=res.get(i).getJSON();
				if(i<res.size()-1)
					jj+=",";
				
			}
			
			
			jj+="]";
			
		

			out.print(jj);
			out.flush();
			
			
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
