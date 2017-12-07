package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static Connection getConexaoMySQL() {

		Connection connection = null;
		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			//String username = "t1g2";
			//String password = "$wS!hMY%";

			//connection = DriverManager.getConnection("jdbc:mysql://143.107.102.5:3306/t1g2", username, password);
			
			String username = "root";
			String password = "admin";

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1g2?autoReconnect=true&useSSL=false", username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}
