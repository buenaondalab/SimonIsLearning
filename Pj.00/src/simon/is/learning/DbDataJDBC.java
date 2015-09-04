package simon.is.learning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DbDataJDBC implements DbData {
	
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
		List<Movie> ris = null;
		Statement stmt;
		ResultSet rs;

		try {
			
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery("select id,title,description from table00");
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