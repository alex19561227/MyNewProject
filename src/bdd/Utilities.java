package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import model.MyUser;

public class Utilities {
	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/mynewproject";
		// LOGIN
		String login = "root";
		// PASSWORD
		String password = "";

		Connection connection = null;

		try {

			// 1- Load DRIVER
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver chargé");

			// 2- Open CONNECTION
			connection = DriverManager.getConnection(url, login, password);
			System.out.println("connected to DB");

		} catch (ClassNotFoundException e) {
			// treat eventual errors here
			System.out.println(" err driver ");
			e.printStackTrace();
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" err connection ");
			e.printStackTrace();
		}

		return connection;
	}
	
	public static void closeConnection(Connection connection, Statement stm, ResultSet res) {
		// close connection, statement, resultSet
		try {
			/* Fermeture de la connexion */
			if (res != null) {
				res.close();
			}

			if (stm != null) {
				stm.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public static Date convertJavaDateToSqlDate(java.util.Date utilDate) {
		
		return new java.sql.Date(utilDate.getTime());
	}

public static java.util.Date buildDate(int day, int month, int year) {
	return new GregorianCalendar(year, month - 1, day).getTime();
}
//public void ifChecked(int i) {
//boolean etatCheckBox = request.getParameter("state") != null;
//if (etatCheckBox==true) {
//	MyUser userTmp = userTmp.get(i);
//}
//}

}
