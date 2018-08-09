package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			res.next();
			quizz.setQuestionary(res.getString(3));
			quizz.setQuestionaryId(res.getLong(1));
			quizz.setState(res.getBoolean(4));
			quizz.setSubjectId(new MySubject(res.getLong(2)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);

		}

		System.out.println("-----------Questionnaries-----------");
		System.out.println("questionaryBdd - QuizId: "+quizz);
		return quizz;

	}

}
