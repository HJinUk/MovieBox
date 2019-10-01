package di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MB_Action {

	
	void excute(HttpServletRequest request,HttpServletResponse response)throws Exception;
}
