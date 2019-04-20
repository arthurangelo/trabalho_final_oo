package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class Conexao {

	private static String dsn = "jdbc:mysql://localhost:3306/dbimportacao";
	private static String username = "root";
	private static String password = "root";
	private static Connection con;

	private static Connection getConnection() {

		if (con == null) {
			try {
				con = DriverManager.getConnection(dsn, username, password);
			} catch (SQLException ex) {
				System.out.println(ex);
				throw new RuntimeException(ex);
			}
		}

		return con;
	}

	public static PreparedStatement getStatement(String sql) throws SQLException {

		return getConnection().prepareStatement(sql);
	}
	
	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex);
				throw new RuntimeException(ex);
			}
		}

	}

	
}