package simon.is.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DbDataJDBC implements DbData {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/pj00";
	private static final String DB_USER = "username";
	private static final String DB_PASS = "password";
	private static final String DB_CLASS = "com.mysql.jdbc.Driver";
		
	// voglio evitare di scriverlo ogni volta... o no?
	private Connection connCreate() {
		Connection con=null;
		try {
			Class.forName(DB_CLASS).newInstance();
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		}
		catch(SQLException e){
			System.out.println("Errore sql "+e.getSQLState()+":\n"+e.getMessage());
		}
		
		catch( Exception e ) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public void insert(Object o){
		
	}
	
	public void update(Object o){
		
	}
	
	public void delete(Object o){
		
	}
	
	public List<Movie> getAllMovies(){
		
		List<Movie> ris = new ArrayList<Movie>();
		Statement stmt;
		ResultSet rs;

		try {
			
			Connection con = connCreate();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery("select id,title,description from table00");
			
			while(rs.next()) {
				ris.add(new Movie(rs.getInt("id"),rs.getString("title"),rs.getString("description")));
			}

			con.close();
		}
		
		catch(SQLException e){
			System.out.println("Errore sql "+e.getSQLState()+":\n"+e.getMessage());
		}
		
		catch( Exception e ) {
			System.out.println(e.getMessage());
		}
	
		return ris;
	}
	
	/*
	 * Ho capito quello che volevi fare ma...
	 * il dao deve funzionare "senza far capire che sotto ci sta un db"
	 * l'utilizzatore (compresi programmi) del dao potrebbe non conoscere nulla di sql...
	 * l'sql deve dunque essere tutto bello e impacchettato e non se ne deve aver traccia all'esterno... :)
	 */
	//per un'ipotetica query fatta tramite una qualche tipo di ricerca
	public List<Movie> sqlWhereClause(String s){
		List<Movie> ris = null;
		Statement stmt;
		ResultSet rs;

		try {
			
			Connection con = connCreate();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(s);
			if (rs.next()) {
				ris = new ArrayList<Movie>();
				rs.first();
				do {
					ris.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3)));
				}
				while (rs.next());
			}
			con.close();
		}
		
		catch(SQLException e){
			System.out.println("Errore sql "+e.getSQLState()+":\n"+e.getMessage());
		}
		
		catch( Exception e ) {
			System.out.println(e.getMessage());
		}
	
		return ris;
	}
	
	
}
