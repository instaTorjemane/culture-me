<% 
	session.setAttribute("user", null);
	session.invalidate();
	response.sendRedirect("welcome.jsp");
%>