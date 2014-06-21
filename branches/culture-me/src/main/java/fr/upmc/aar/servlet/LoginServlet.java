package fr.upmc.aar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(!login.isEmpty() && !password.isEmpty())
		{
			User u = null;
			u = UserDAO.getUser(login, password);
			
			if (u != null){
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("auth","true");
				RequestDispatcher dispatch = request.getRequestDispatcher("welcome.jsp");
				dispatch.forward(request, response);
			}
			else{
				request.getSession().setAttribute("auth","false");
				String message = "L'utilisateur n'a pas été trouvé!";
				request.setAttribute("message", message);
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
			}
		}
	}
}