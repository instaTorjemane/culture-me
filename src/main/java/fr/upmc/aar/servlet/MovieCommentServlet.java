package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.model.Comment;

/**
 * Servlet implementation class MovieCommentServlet
 */
public class MovieCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comment> comments = MovieDAO.getMovieComments("The Signal","2014");
		if(comments != null){
			for (Comment comment : comments) {
				response.getWriter().print("<p><strong>" + comment.getUsername() + "</strong> : " + comment.getContent() + "<br/><strong>" + comment.getUsername() + "</strong> : " + comment.getContent() + "</p>");
				response.getWriter().print("<p><strong>" + comment.getUsername() + "</strong> : " + comment.getContent() + "<br/><strong>" + comment.getUsername() + "</strong> : " + comment.getContent() + "</p>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
