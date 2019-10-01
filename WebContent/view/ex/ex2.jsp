<%@page import="theater.TheaterDAO"%>
<%@page import="theater.TheaterDTO"%> 
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[    
<%
	ArrayList<TheaterDTO> res = new TheaterDAO().arealist();

	
	for(int i =0;i<res.size(); i++){
		out.print(res.get(i).getJSON());
		if(i<res.size()-1)
			out.print(",");
		
	}
%>

]