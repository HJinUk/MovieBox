package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

public class RegMain implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
	//	Integer mcode= Integer.parseInt(request.getParameter("mcode"));
		String name= request.getParameter("name");
		String tel = request.getParameter("tel");
		String email=request.getParameter("email");
		String jumin= request.getParameter("jumin")+"-"+request.getParameter("jumin1");
		String genre [] = request.getParameterValues("genre");  
	//	Integer coupon= Integer.parseInt(request.getParameter("coupon"));
		
		System.out.println(genre.length);
		MemberDTO dto = new MemberDTO();
		
		if(genre.length==3) {
			dto.setGenre(genre[0]+","+genre[1]+","+genre[2]);
		}else if(genre.length==2) {
			dto.setGenre(genre[0]+","+genre[1]);
		}else {
			dto.setGenre(genre[0]);
		}
			
		System.out.println("sdsdsd");
		dto.setId(id);
		dto.setPw(pw);
	//	dto.setMcode(mcode);
		dto.setName(name);
		dto.setTel(tel);
		dto.setEmail(email);
		dto.setJumin(jumin);
		
		
		
	//	dto.setCoupon(coupon);
		
		new MemberDAO().insertJoin(dto);
		
		request.setAttribute("mainUrl", "user/Login");
		//MemberDAO dao=MemberDAO.get
		
		
	}

}
