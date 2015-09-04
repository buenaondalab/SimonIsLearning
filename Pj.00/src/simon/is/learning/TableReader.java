package simon.is.learning;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import java.util.*;


public class TableReader extends HttpServlet {
	
	private DbDataJDBC db00 = new DbDataJDBC();
	
	// Ho rinominato da s a movies... codice un po' + leggibile..
	private List<Movie> movies; 

	 private static final String PAGE_TOP = ""
		      + "<html>"
		      + "<head>"
		      + "<title>Prova Servlet</title>"
		      + "</head>"
		      + "<body>"
		      + "<h3>Lettura di elementi da tabella</h3>"; 	
	 	

		  private static final String PAGE_BOTTOM = ""
		      + "</body>"
		      + "</html>"
		  ;
		  
		  private static final String TH ="<tr><th>ID</th><th>Nome</th><th>Descrizione</th></tr>";


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException
		  {
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
	
		    out.println(PAGE_TOP);
		    
		    movies = db00.getAllMovies();

		     // visto che in DbDataJDBC ho cambiato qualcosina...
		     if(movies.isEmpty()){
//			 if  (movies == null) {
				 out.println("Non ci sono elementi nella tabella.");
			 }
			 else {
				 out.println("<table>");
				 out.println(TH);
				 
				 // OTTIMO!
				 for (Movie m : movies){
					 out.print("<tr><td>"+m.getId()+"</td><td>"+m.getTitle()+"</td><td>"+m.getDesc()+"</td>");
				 }
				 out.println("</table>");
			 }
		      
		    out.println(PAGE_BOTTOM);
		  }
	
		  
		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException
		  {
		    this.doGet(request,response);
		  }      
		  
		  public String getServletInfo()
		  {
		    return super.getServletInfo();
		  }
		  
} 
