package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MyQuestion;
import model.MyQuestionary;

public class QuestionBdd {
	public static boolean insertQuestion(MyQuestion question) {

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
			String sql = "INSERT INTO `my_question`(`question`, `quizz_id`, `state`) VALUES (?,?,?)";
			// 4 - prepare the statement
			stm = connection.prepareStatement(sql);
			stm.setString(1, question.getQuestion());
			stm.setLong(2, question.getQuizzId().getQuestionaryId());
			stm.setBoolean(3, question.getState());

			// 5 - Statement (Request) Execution and result load
			int status = stm.executeUpdate();
			System.out.println("Résultat de la requête d'insertion : " + status);
			
		} catch (SQLException e) {
			/* Gérer les éventuelles erreurs ici */
			System.out.println(" ERROR SQL insertQuestion ");
			e.printStackTrace();
			return false;
		} finally {
			// 7- close connection, statement, resultSet
			Utilities.closeConnection(connection, stm, null);
		}

		return true;
	}

	public static List<MyQuestion> viewListQuestions(Long questionaryId) {
		ArrayList<MyQuestion> questionListTemp = new ArrayList<MyQuestion>();
		Connection connect = Utilities.openConnection();
		ResultSet res = null; 
		PreparedStatement stat = null;
		try {
			stat = connect.prepareStatement("SELECT * FROM my_question WHERE QUIZZ_ID=?");
			stat.setLong(1, questionaryId);
			res = stat.executeQuery();
			while (res.next()) {
				MyQuestion myQuest = new MyQuestion();
				//
				
				myQuest.setQuestionId(res.getLong("question_id"));
				myQuest.setQuestion(res.getString("question"));
				myQuest.setState(res.getBoolean("state"));
				
				questionListTemp.add(myQuest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des questions-----------");
		System.out.println("questionBdd: "+questionListTemp);
		return questionListTemp;

	}

}
