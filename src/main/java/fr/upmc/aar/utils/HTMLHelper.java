package fr.upmc.aar.utils;

import javax.servlet.http.HttpSession;

import fr.upmc.aar.model.User;

public class HTMLHelper {
		
	public static String createArticle(String link, String anchorClass, String imageSrc, String title, String description){
		
		StringBuilder article = new StringBuilder();
		
		article.append("<article>");
		article.append("<a href=\"" + link + "\" class=\"" + anchorClass + "\"><img src=\"" + imageSrc + "\" alt=\"\" /></a>");
		article.append("<header>");
		article.append("<h3><a href=\""+ link +"\">" + title + "</a></h3>");
		article.append("</header>");
		article.append("<p>" + description + "</p>");							
		article.append("</article>");
		
		return article.toString();
	}
	
	public static User getConnectedUser(HttpSession session)
	{
		return (User) session.getAttribute("user");	
	}		

}
