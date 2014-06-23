package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.search.dev.GenericScorer.Result;

import fr.upmc.aar.dao.CommentDAO;
import fr.upmc.aar.dao.ResultState;
import fr.upmc.aar.dao.UserDAO;
import fr.upmc.aar.model.Comment;
import fr.upmc.aar.model.Movie;
import fr.upmc.aar.model.User;

/**
 * Servlet implementation class UserCommentsServlet
 */
public class UserCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCommentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = UserDAO.getUser("shazad","shazad");
		//Movie m = new Movie();
		
		//m.getComments().get(1).getUsername();
		
		if(u != null){
			List<Comment> comments = CommentDAO.userComments(u.getUsername());
			if(comments != null && !comments.isEmpty()){
				for(Comment com: comments){
					response.getWriter().print(
							"<p>Username  : " + com.getUsername() + "</p> " +
						    "<p>" + com.getCommentDate() + "</p>" +
							"<p>Commentaire  : " + com.getContent() + "</p><br/>"		
					);
				}
			}else{
				response.getWriter().print("<p>Pas de commentaires de"+u.getFirstName()+" "+u.getLastName());
			}
		}else{
			response.getWriter().print("<p> User non trouvé <p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
