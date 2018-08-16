package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.MyUser;

public class UserBdd {
	public static MyUser updateUser(MyUser user) {
		MyUser usertmp = new MyUser();
		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;
		Long id = user.getUserId();
		try {
			
			String query = "UPDATE my_user SET state = ? where user_id = ?";
			stat = connect.prepareStatement(query);
			stat.setBoolean(1, true);
			stat.setLong(2, id);
			stat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Utilities.closeConnection(connect, stat, null);
		}
		return usertmp;
	}
	
	
	public static List<MyUser> viewListUsers(HttpServletRequest request) {
		ArrayList<MyUser> userListTemp = new ArrayList<MyUser>();
		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;
		try { 
			String query = "select * from my_user where state = 0";
			stat = connect.prepareStatement(query);
			res = stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				Long userId = res.getLong("user_id");
				String lName = res.getString("fname");
				String fName = res.getString("lname");
				String society = res.getString("society");
				String tel = res.getString("TEL");
				String email = res.getString("EMAIL");
				String pswd = res.getString("PASSWORD");
				boolean state = res.getBoolean("STATE");
				Date date = res.getDate("date_creation");
				MyUser use = new MyUser(userId, lName, fName, society, tel, email, pswd, state, date);
				userListTemp.add(use);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des comptes inactifs-----------");
		System.out.println("UserBdd - userList inactif: "+userListTemp);
		return userListTemp;

	}

	public static List<MyUser> viewValidatedUsers(HttpServletRequest request) {
		ArrayList<MyUser> userListTemp = new ArrayList<MyUser>();
		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;
		try {
			String query = "select * from my_user where state = 1";
			stat = connect.prepareStatement(query);
			res = stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				Long userId = res.getLong("user_id");
				String lName = res.getString("fname");
				String fName = res.getString("lname");
				String society = res.getString("society");
				String tel = res.getString("TEL");
				String email = res.getString("EMAIL");
				String pswd = res.getString("PASSWORD");
				boolean state = res.getBoolean("STATE");
				Date date = res.getDate("date_creation");
				MyUser use = new MyUser(userId, lName, fName, society, tel, email, pswd, state, date);
				userListTemp.add(use);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des comptes actifs-----------");
		System.out.println("UserBdd - userList actif: "+userListTemp);
		return userListTemp;

	}
	public static boolean insertUser(MyUser newUser) {

		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return false;
		}
		// statement contains SQL request
		PreparedStatement stm = null;
		try {
			// 3- Build SQL Request
			String sql = "INSERT INTO my_user (date_creation , email , fname , lname , password , role , society , state , tel)"
					+ " VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?)";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql);
			long l = newUser.getDate().getTime();
			java.sql.Date sqlDate = new java.sql.Date(l);
			stm.setDate(1, sqlDate);
			// stm.setDate(1, (java.sql.Date) newUser.getDate());

			stm.setString(2, newUser.getEmail());
			stm.setString(3, newUser.getfName());
			stm.setString(4, newUser.getlName());
			stm.setString(5, newUser.getPassword());
			stm.setBoolean(6, newUser.isRole());
			stm.setString(7, newUser.getSociety());
			stm.setBoolean(8, newUser.isState());
			stm.setString(9, newUser.getTel());

			// 5 - Statement (Request) Execution and result load
			int status = stm.executeUpdate();
			System.out.println("Résultat de la requête d'insertion : " + status);
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" ERROR SQL insertUser ");
			e.printStackTrace();
			return false;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, null);
		}

		return true;
	}
	public static MyUser seekUserById(String IdCriteria) {

		MyUser userToReturn = null;

		// STATEMENT [ execute request SQL]
		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return null;
		}
		// statement containing SQL request
		PreparedStatement stm = null;
		// ResultSet receive results of request
		ResultSet res = null;
		try {

			// Build SQL Request
			String sql = "SELECT * FROM my_user WHERE user_id = ? ";
			stm = connection.prepareStatement(sql);
			stm.setString(1, IdCriteria);

			// 5 - Statement (Request) Execution and result load
			res = stm.executeQuery();

			// 6 - Explore the result (loop)
			//StagiaireManager.afficherEntete();
			while (res.next()) {
				
				Long userId = res.getLong("user_id");
				String lName = res.getString("fname");
				String fName = res.getString("lname");
				String society = res.getString("society");
				String tel = res.getString("TEL");
				String email = res.getString("EMAIL");
				String pswd = res.getString("PASSWORD");
				boolean state = res.getBoolean("STATE");
				Date date = res.getDate("date_creation");
				userToReturn = new MyUser(userId, lName, fName, society, tel, email, pswd, state, date);
				
			}

		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" err connection ");
			e.printStackTrace();
			return null;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, res);
		}
		return userToReturn;
	}
	
	public static MyUser seekUserByName(String nameCriteria) {

		MyUser userToReturn = null;

		// STATEMENT [ execute request SQL]
		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return null;
		}
		// statement containing SQL request
		PreparedStatement stm = null;
		// ResultSet receive results of request
		ResultSet res = null;
		try {

			// Build SQL Request
			String sql = "SELECT * FROM my_user WHERE lname = ? ";
			stm = connection.prepareStatement(sql);
			stm.setString(1, nameCriteria);

			// 5 - Statement (Request) Execution and result load
			res = stm.executeQuery();

			// 6 - Explore the result (loop)
			//StagiaireManager.afficherEntete();
			while (res.next()) {
				
				Long userId = res.getLong("user_id");
				String lName = res.getString("fname");
				String fName = res.getString("lname");
				String society = res.getString("society");
				String tel = res.getString("TEL");
				String email = res.getString("EMAIL");
				String pswd = res.getString("PASSWORD");
				boolean state = res.getBoolean("STATE");
				Date date = res.getDate("date_creation");
				userToReturn = new MyUser(userId, lName, fName, society, tel, email, pswd, state, date);
				
			}

		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" err connection ");
			e.printStackTrace();
			return null;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, res);
		}
		return userToReturn;
	}
	
	public static MyUser deleteUser(MyUser user) {

		MyUser userToReturn = null;

		// STATEMENT [ execute request SQL]
		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return null;
		}
		// statement containing SQL request
		PreparedStatement stm = null;
		// ResultSet receive results of request
		ResultSet res = null;
		try {

			// Build SQL Request
			String sql = "DELETE FROM `my_user` WHERE id=?";
			stm = connection.prepareStatement(sql);
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" err connection ");
			e.printStackTrace();
			return null;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, res);
		}
		return userToReturn;
	}
	
	public static MyUser testRecord(String emailP, String passwordP) {

		MyUser userToReturn = null;

		// STATEMENT [ execute request SQL]
		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return null;
		}
		// statement containing SQL request
		PreparedStatement stm = null;
		// ResultSet receive results of request
		ResultSet res = null;
		try {

			// Build SQL Request
			String sql = "SELECT * FROM my_user WHERE email=? AND password=?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, emailP);
			stm.setString(2, passwordP);
			

			// 5 - Statement (Request) Execution and result load
			res = stm.executeQuery();

			// 6 - Explore the result (loop)
			//StagiaireManager.afficherEntete();
			while (res.next()) {
				
				Long userId = res.getLong("user_id");
				String lName = res.getString("fname");
				String fName = res.getString("lname");
				String society = res.getString("society");
				String tel = res.getString("TEL");
				String email = res.getString("EMAIL");
				String pswd = res.getString("PASSWORD");
				boolean state = res.getBoolean("STATE");
				Date date = res.getDate("date_creation");
				userToReturn = new MyUser(userId, lName, fName, society, tel, email, pswd, state, date);
				
			}

		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" err connection ");
			e.printStackTrace();
			return null;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, res);
		}
		return userToReturn;
	}
}