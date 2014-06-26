package fr.upmc.aar.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.aar.dao.MovieDAO;
import fr.upmc.aar.model.Comment;
import fr.upmc.aar.model.Movie;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		List<Movie> movies = MovieDAO.listMovie();
		//Movie movie = movies.get(10);
		Movie movie = MovieDAO.getMovie("The Signal","2014");
		
		Comment comment = new Comment();
		comment.setCommentDate(new Date());
		comment.setContent("Bof bof le film.....");
		comment.setMark((double) new Random().nextInt(5));
		comment.setUsername("shazad");
		
		MovieDAO.addCommentToMovie(movie.getTitle(),movie.getYear(), comment);
		
		response.getWriter().print("<html> "+ "<body><h1>Ajout d'un commentaire</h1>");
		response.getWriter().print("<p>titre : " + movie.getTitle() + "</p>" + 
				"<p>Description : </p><p>" + movie.getSynopsis() +  "</p>" + 
				"<p>sortie : " + movie.getRuntime() + "</p>" +
				"<p> Lien image: " +movie.getPosters().getOriginal()+"</p>");
		
		
		response.getWriter().print(
				"<p>Username: "+comment.getUsername()+"</p>"
				+ "<p>content: "+comment.getContent()+"</p>"
				+ "<p>Ce commentaire va être rajouté</p>"
				+ "<p>Note: "+comment.getMark()+"</p>"
				
				+ "<p>" + MovieDAO.movieAverage(movie.getTitle(),movie.getYear()) + "</p>"
				);
				
		System.out.println("Commentaire bien ajouté");
	}

}
