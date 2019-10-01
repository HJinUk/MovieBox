package reserve;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

public class Reserve implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		request.setAttribute("data", new ReserveDAO().list());
		request.setAttribute("theater", new ReserveDAO().thList());
		request.setAttribute("areaa",new ReserveDAO().area());
		
		
	}

}
