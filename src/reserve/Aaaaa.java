package reserve;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;

public class Aaaaa implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/text;charset=euc-kr");
        
        PrintWriter out =response.getWriter();
        String jj="[";
        
        ArrayList<ReserveDTO> res = new ReserveDAO().theaterlist(Integer.parseInt(request.getParameter("areacode")));

        
        for(int i =0;i<res.size(); i++){
           jj+=res.get(i).getJSON();
           if(i<res.size()-1)
              jj+=",";
           
        }
        
        
        jj+="]";
 

        out.print(jj);
        out.flush();

	}

}
