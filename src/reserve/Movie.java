package reserve;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

public class Movie implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String ch = request.getParameter("day");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date fe = new Date(); // 오늘날짜

		Date dt = sdf.parse(ch); // 고른날짜 

		if(fe.after(dt)) { // 오늘 날짜가 고른 날짜를 지나면 이전 날짜 못고르게 
		
			request.setAttribute("day", "이전날짜는 안됩니다.");
		}else{// 지나지 않았을때는 예매 
			request.setAttribute("day", ch);
		}
		
		if(fe == dt) {
			request.setAttribute("day", ch);
		}
	}

}
