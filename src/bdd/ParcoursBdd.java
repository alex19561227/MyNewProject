package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MyParcours;
import model.MyQuestionary;
import model.MyUser;

public class ParcoursBdd {
	public static long insertParcours(MyParcours newParcours) {

		// STATEMENT [ execute request SQL]
		ResultSet rs;
		long monid=0;
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return -1;
		}
		// statement contains SQL request
		PreparedStatement stm = null;
		try {
			// 3- Build SQL Request
			String sql = "INSERT INTO my_parcours" + "(parcquiz_id , score  , time_spent , parcuser_id)"
					+ " VALUES (? , ? , ? , ?)";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stm.setLong(1, newParcours.getParcQuiz().getQuestionaryId());
			stm.setInt(2, newParcours.getScore());
			stm.setLong(3, newParcours.getTimeSpent());
			stm.setLong(4, newParcours.getParcUser().getUserId());

			// 5 - Statement (Request) Execution and result load
			int status = stm.executeUpdate();

			rs = stm.getGeneratedKeys(); // Retrieve the automatically 2
			// generated key values in a ResultSet.
			// Two rows are returned.
			// Create ResultSet for query
			
			if (rs.next()) {
				monid = rs.getLong(1);
			}
			System.out.println("Résultat de la requête d'insertion : " + monid);
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" ERROR SQL insertUser ");
			e.printStackTrace();
			return -1;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, null);
		}

		return monid;
	}

//	public static List<MySubject> viewListSubjects() {
//		ArrayList<MySubject> subjectListTemp = new ArrayList<MySubject>();
//		Connection connect = Utilities.openConnection();
//		ResultSet res = null;
//		PreparedStatement stat = null;
//		try {
//			String query = "select * from my_subject";
//			stat = connect.prepareStatement(query);
//			res = stat.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			while (res.next()) {
//				Long subjectId = res.getLong("subject_id");
//				String subject = res.getString("subject");
//				MySubject sujet = new MySubject(subjectId, subject);
//				subjectListTemp.add(sujet);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			Utilities.closeConnection(connect, stat, null);
//		}
//		System.out.println("-----------Liste des sujets-----------");
//		System.out.println(subjectListTemp);
//		return subjectListTemp;
//
//	}
	
	public static List<MyParcours> viewListParcours(long id){
		ArrayList<MyParcours> parcoursListTemp = new ArrayList<MyParcours>();
		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;
		try {
			String query = "select * from my_parcours where parcuser_id=?";
			stat = connect.prepareStatement(query);
			stat.setLong(1, id);
			res = stat.executeQuery();
			while (res.next()) {
				MyParcours parcours = new MyParcours();
				parcours.setParcoursId(res.getLong(1));
				parcours.setParcQuiz(new MyQuestionary(false, res.getLong("parcquiz_id"), null, null));
				parcours.setScore(res.getInt(3));
				parcours.setTimeSpent(res.getLong(4));
				parcoursListTemp.add(parcours);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des parcours-----------");
		System.out.println("parcoursBdd - List des parcours: "+parcoursListTemp);
		
		return parcoursListTemp;
	}
	
	public static MyParcours viewParcours() {
		return null;
	}

}
