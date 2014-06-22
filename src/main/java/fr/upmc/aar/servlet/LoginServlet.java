package fr.upmc.aar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		if(!login.isEmpty() && !password.isEmpty())
		{			 
			User u = UserDAO.getUser(login, password);
			HttpSession session = request.getSession(true);
			
			if (u != null){
				session.setAttribute("user", u);
				//request.getSession().setAttribute("auth","true");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp"); 
				dispatcher.forward(request, response);				
			}
			else{
				//session.setAttribute("auth","false");
				
				PrintWriter out = response.getWriter();
				out.print("<div align='center'>Les identifiants saisis ne sont pas reconnus</div>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); 
				dispatcher.forward(request, response);				
			}
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp"); 
			dispatcher.forward(request, response);
		}
	}
}