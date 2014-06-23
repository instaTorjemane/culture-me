package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class MailServlet
 */
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Requête DAO pour récupéré le User
		//UserDAO.getUser ==> Par mail? Par Id?
		User u = UserDAO.getUser("shazad","shazad");
		
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		String msgBody = "<html><body>"
				+ "<h2> Bienvenue chez culture-me "+u.getUsername()+"!</h2>"
				+ "<p> Vous êtes maintenant inscrit sur le premier site d'évaluations de produits culturels !</p>"
				+ "<p> Participez vous aussi, et donnez votre avis sur les films, jeux videos et livres que vous avez aimez (ou pas!) !</p>"
				+ "<br/>"
				+ "<p> En cas de problème avec le site ou pour nous donner des idées d'améliorations, contactez notre <a href=\"mailto:stl.insta.aar@gmail.com\">webmaster</a></p>"
				+ "<p> A bientôt sur Culture-me ! </p>"
				+ "<body></html>";
		
		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("stl.insta.aar@gmail.com", "Webmaster Culture-me"));
		    msg.addRecipient(Message.RecipientType.TO,new InternetAddress("","M. "+u.getLastName()));
		    msg.setSubject("[Culture-me] Bienvenue "+u.getUsername()+" !");
		    msg.setText(msgBody);
		    Transport.send(msg);
		    }catch (AddressException e) {
		    	e.printStackTrace();
		    }catch (MessagingException e) {
		    	e.printStackTrace();
		    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
