package fr.upmc.aar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class SendPasswordServlet
 */
public class SendPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPasswordServlet() {
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
		String email = request.getParameter("emailcheck");
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean validmail = email.matches(EMAIL_REGEX);
		String password = "";
		
		if(validmail){
			User u = UserDAO.getUserByMail(email);
			
			if(u != null){
				password = u.getPassword();
				
				//Envoi du mail
				Properties props = new Properties();
				Session session = Session.getDefaultInstance(props, null);
				
				String msgBody = "<html><body>"
						+ "<h2> Récupération du mot de passe de "+u.getUsername()+"</h2>"
						+ "<p> Vous avez fait une demande de mot de passe récemment. Vous trouverez votre mot de passe dans cet email.</p>"
						+ "Votre mot de passe est : "+ password
						+ "<br/>"
						+ "<p> En cas de problème avec le site ou pour nous donner des idées d'améliorations, contactez notre <a href=\"mailto:stl.insta.aar@gmail.com\">webmaster</a></p>"
						+ "<p> A bientôt sur Culture-me ! </p>"
						+ "<body></html>";
				
				try {
				    Message msg = new MimeMessage(session);
				    msg.setContent(msgBody, "text/html");
				    msg.setFrom(new InternetAddress("stl.insta.aar@gmail.com", "Webmaster Culture-me"));
				    msg.addRecipient(Message.RecipientType.TO,new InternetAddress(u.getMail(),"M. "+u.getLastName()));
				    msg.setSubject("[Culture-me] Récupération de mot de passe");
				    //msg.setText(msgBody);
				    Transport.send(msg);
				    
				    /*Test affichage corps OK
				      response.getWriter().print("<h1>"+msg.getSubject()+"</h1><p>From: stl.insta.aar@gmail.com</p>"
				    		+ "<p>To: "+u.getMail()+"</p><p>Corps du mail: <br />"+msgBody+"</p><br/><p>Message bien envoyé!</p>");
				    */
				    }catch (AddressException e) {
				    	response.getWriter().print(" AddressException" +e.getMessage());
				    }catch (MessagingException e) {
				    	response.getWriter().print(" MessagingException" +e.getMessage());
				    }
			}
		}else{
			PrintWriter out = response.getWriter();
			out.print("<div align='center'>Le mail est incorrect!</div>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); 
			dispatcher.forward(request, response);				
		}
		
		
		
		
	}

}
