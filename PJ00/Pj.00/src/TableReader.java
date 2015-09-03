import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;


public class TableReader extends HttpServlet {
	private DbDataJDBC db00 = new DbDataJDBC();
	private String[][] s;

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
		    
		    s = db00.query("get all");

			 if  (s == null) {
				 out.println("Non ci sono elementi nella tabella.");
			 }
			 else {
				 out.println("<table>");
				 out.println(TH);
				 for (int i=0; i<s.length; i++){
					 out.print("<tr>");
					 for (int j=0; j<s[i].length; j++){
						 out.println("<td>" + s[i][j] + "</td>");
					 }
					 out.println("</tr>");
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
