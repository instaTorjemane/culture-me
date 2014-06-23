package fr.upmc.aar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthdate = request.getParameter("birthdate");		
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		
		if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty())
		{
			PrintWriter out = response.getWriter();
			out.print("<div align='center'>Le compte utilisateur n'a pas été créé, remplissez les champs obligatoires !</div>");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else
		{		
			User user = new User();
			
			user.setUsername(username);
			user.setPassword(password);
			user.setLastName(lastname);
			user.setFirstName(firstname);
			user.setInscrDate(new Date());
			user.setBirthDate(new Date(birthdate));
			user.setMail(email);
			user.setWebsite(website);
			
			UserDAO.addUser(user);
			
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
