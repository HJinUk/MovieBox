package calculate;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MB_Action;
import movielist.MovieListDAO;
import movielist.MovieListDTO;

public class Calculate implements MB_Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<MovieListDTO> arr = new MovieListDAO().list();
		
		System.out.println(arr);

	}

}
