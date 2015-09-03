import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDataJDBC implements DbData {
	
	public void insert(Object o){
		
	}
	public void update(Object o){
		
	}
	public void delete(Object o){
		
	}
	public String[][] query(String s){
		String[][] ris = null;
		Statement stmt;
		ResultSet rs;
		int num;

		try {
			
			System.out.println("passo 0.");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("passo 1.");
			String url = "jdbc:mysql://localhost:3306/pj00";
			System.out.println("passo 2.");
			Connection con = DriverManager.getConnection(url,"username","password");
			System.out.println("Connected database successfully...");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			if (s == "get all") {
					rs = stmt.executeQuery("select id,nome,descrizione from table00");
					rs.last();
					num = rs.getRow();
					rs.first();
					ris = new String[num][];
					for (int i=0; i<num; i++){
						ris[i]=(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
						rs.next();
					}
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