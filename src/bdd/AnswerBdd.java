package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.MyAnswer;
import model.MyQuestion;
import model.MyUser;

public class AnswerBdd {
	public static boolean insertAnswer(MyAnswer newAnswer) {

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
			String sql = "INSERT INTO my_answer (answer_id , answer ,  state , correct_answer , repparc_id , questrep_id )"
					+ " VALUES (? , ? , ? , ? , ? , ?)";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql);
			stm.setLong(1, newAnswer.getAnswerId());
			stm.setString(2, newAnswer.getAnswer());
			stm.setBoolean(3, newAnswer.isState());
			stm.setBoolean(4, newAnswer.isCorrectAnswer());
			stm.setLong(5, newAnswer.getRepParcId().getParcoursId());
			stm.setLong(6, newAnswer.getQuestRepId().getQuestionId());

			// 5 - Statement (Request) Execution and result load
			int status = stm.executeUpdate();
			System.out.println("Résultat de la requête d'insertion : " + status);
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" ERROR SQL insertAnswer ");
			e.printStackTrace();
			return false;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, null);
		}

		return true;
	}

	public static List<MyAnswer> readListResponse(MyQuestion question) {
		
		List<MyAnswer> l= new ArrayList<MyAnswer>();
		// STATEMENT [ execute request SQL]
		Connection connection = Utilities.openConnection();
		if (connection == null) {
			System.out.println("Error getting connection...");
			return null;
		}
		// statement contains SQL request
		PreparedStatement stm = null;
		try {
			// 3- Build SQL Request
			String sql = "SELECT * FROM my_answer WHERE QUESTREP_ID=?";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql);
			stm.setLong(1, question.getQuestionId());
			// 5 - Statement (Request) Execution and result load
			ResultSet res = null;
			res = stm.executeQuery();
			while (res.next()) {
				MyAnswer repon=new MyAnswer();
				repon.setAnswerId(res.getLong("answer_id"));
				repon.setAnswer(res.getString("answer"));
				repon.setCorrectAnswer(res.getBoolean("correct_answer"));
				l.add(repon);
			}
			
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" ERROR SQL readListResponse ");
			e.printStackTrace();
			return null;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, null);
		}
		
		
		return l;
	}
}
