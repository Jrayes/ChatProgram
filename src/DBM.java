import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBM {
	String PORT  = "8889";
	String HOST = "localhost";

	Connection connection = null;
	String url = "jdbc:mysql://" +  HOST + ":" + PORT + "/Users";
	// NOW WE BUILD LOGIN FUNCTION.
	public void Login() {
		
	}
	public String Connect(String username, String password) throws SQLException{
		String Username = "";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
			.getConnection(url, "root", "root");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		if (connection != null) {
			Statement sql;
			sql = connection.createStatement();
			String query  = "SELECT Username, Password FROM Users WHERE Username=" + username
					+ "AND Password=" + password;
			ResultSet Rs = sql.executeQuery(query);
			while(Rs.next()){
			 Username =	Rs.getString("Username");
			 return Username;
			}
			
			return null;
		}
		else {
			connection.close();
			return null;
		}
	}
	public static void main(String[] args) throws SQLException {
	
			
	}
}

