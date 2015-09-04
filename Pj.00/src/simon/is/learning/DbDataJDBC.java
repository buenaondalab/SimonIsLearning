package simon.is.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DbDataJDBC implements DbData {
		
	// è convenzione scrivere le costanti in maiuscolo... DB_URL, DB_USER etc..
	private static final String dbURL = "jdbc:mysql://localhost:3306/pj00";
	private static final String dbUser = "username";
	private static final String dbPass = "password";
	private static final String dbClass = "com.mysql.jdbc.Driver";
	
	public void insert(Object o){
		
	}
	
	public void update(Object o){
		
	}
	
	public void delete(Object o){
		
	}
	
	public List<Movie> getAllMovies(){
		
		List<Movie> ris = new ArrayList<Movie>();//
		Statement stmt;
		ResultSet rs;

		try {
			
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery("select id,title,description from table00");
			
			while(rs.next()) {
				ris.add(new Movie(rs.getInt("id"),rs.getString("title"),rs.getString("description")));
			}
			
//			if (rs.next()) {
//				ris = new ArrayList<Movie>();
//				rs.first();
//				do {
//					ris.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3)));
//				}
//				while (rs.next());
//			}
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
			
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
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