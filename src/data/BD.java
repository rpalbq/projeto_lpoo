package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BD {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicaveterinaria", "root", "root");
			} catch (SQLException e) {
				throw new BDException(e.getMessage());
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new BDException(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new BDException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new BDException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("./src./data./bd.properties")) {
			Properties properties = new Properties();
			properties.load(fs);
			return properties;
		} catch (IOException e) {
			throw new BDException(e.getMessage());
		}
	}

}
