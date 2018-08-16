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
import model.MySubject;

public class QuestionaryBdd {
	public static List<MyQuestionary> viewListQuizz(Long sujet) {
		ArrayList<MyQuestionary> quizzListTemp = new ArrayList<MyQuestionary>();

		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;

		try {
			String query = "select * from my_questionary where sujet_id = ?";
			stat = connect.prepareStatement(query);
			stat.setLong(1, sujet);
			res = stat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				MyQuestionary quizz = new MyQuestionary();
				quizz.setQuestionaryId(res.getLong("questionary_Id"));
				quizz.setQuestionary(res.getString("questionary"));
				quizzListTemp.add(quizz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des questionnaires-----------");
		System.out.println("questionaryBdd - List des questionnaires: "+quizzListTemp);
		return quizzListTemp;

	}

	public static MyQuestionary viewQuizzId(Long id) {
		MyQuestionary quizz = new MyQuestionary();

		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;

		try {
			String query = "select * from my_questionary where questionary_Id = ?";
			stat = connect.prepareStatement(query);
			stat.setLong(1, id);
			res = stat.executeQuery();
			res.next();
			quizz.setQuestionary(res.getString(3));
			quizz.setQuestionaryId(res.getLong(1));
			quizz.setState(res.getBoolean(4));
			quizz.setSubjectId(new MySubject(res.getLong(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);

		}

		System.out.println("-----------Questionnaries-----------");
		System.out.println("questionaryBdd - QuizId: "+quizz);
		return quizz;

	}
	
	public static long insertQuestionary(MyQuestionary newQuestionary) {

		// STATEMENT [ execute request SQL]
		ResultSet rs = null;
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
			String sql = "INSERT INTO my_questionary" + "(sujet_id  , questionary , state)"
					+ " VALUES (? , ? , ?)";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stm.setLong(1, newQuestionary.getSubjectId().getSubjectId());
			stm.setString(2, newQuestionary.getQuestionary());
			stm.setBoolean(3, newQuestionary.isState());

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
			System.out.println(" ERROR SQL insertQuestionary ");
			e.printStackTrace();
			return -1;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, rs);
		}

		return monid;
	}

}
