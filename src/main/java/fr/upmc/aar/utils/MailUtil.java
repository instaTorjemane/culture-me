package fr.upmc.aar.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.upmc.aar.model.User;

public class MailUtil{
	
	public static void newAccountConfirm(User u){
		
		if(u != null){
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
			    msg.setContent(msgBody, "text/html");
			    msg.setFrom(new InternetAddress("stl.insta.aar@gmail.com", "Webmaster Culture-me"));
			    msg.addRecipient(Message.RecipientType.TO,new InternetAddress(u.getMail(),u.getFirstName()+" "+u.getLastName()));
			    msg.setSubject("[Culture-me] Bienvenue "+u.getUsername()+" !");
			    //msg.setText(msgBody);
			    Transport.send(msg);
			    
			    /*Test affichage corps OK
			     * response.getWriter().print("<h1>Envoi d'Email</h1><p>From: stl.insta.aar@gmail.com</p>"
			    		+ "<p>To: "+u.getMail()+"</p><p>Corps du mail: <br />"+msgBody+"</p><br/><p>Message bien envoyé!</p>");
			    */
			    }catch (AddressException e) {
			    	
			    }catch (MessagingException e) {
			    	
			    }catch (Exception e){
			    	
			    }
			
			
		}
	}

}
