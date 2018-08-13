package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MySubject;

public class SubjectBdd {
	public static MySubject viewSujetId(Long id) {
		MySubject sujet = new MySubject();

		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;

		try {
			String query = "select * from my_subject where subject_id = ?";
			stat = connect.prepareStatement(query);
			stat.setLong(1, id);
			res = stat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			res.next();
			sujet.setSubject(res.getString(2));
			sujet.setSubjectId(res.getLong(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);

		}

		System.out.println("-----------Ssujet-----------");
		System.out.println("subjectBdd - Subject: "+sujet);
		return sujet;

	}
	
	public static String viewSujet(Long id) {
		MySubject sujet = new MySubject();

		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;

		try {
			String query = "select * from my_subject where subject_id = ?";
			stat = connect.prepareStatement(query);
			stat.setLong(1, id);
			res = stat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			res.next();
			sujet.setSubject(res.getString(2));
			sujet.setSubjectId(res.getLong(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);

		}

		System.out.println("-----------Ssujet-----------");
		System.out.println("subjectBdd - Subject: "+sujet);
		return sujet.getSubject();

	}
		
	public static List<MySubject> viewListSubjects() {
		ArrayList<MySubject> subjectListTemp = new ArrayList<MySubject>();
		Connection connect = Utilities.openConnection();
		ResultSet res = null;
		PreparedStatement stat = null;
		try {
			String query = "select * from my_subject";
			stat = connect.prepareStatement(query);
			res = stat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				Long subjectId = res.getLong("subject_id");
				String subject = res.getString("subject");
				MySubject sujet = new MySubject(subjectId, subject);
				subjectListTemp.add(sujet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(connect, stat, null);
		}
		System.out.println("-----------Liste des sujets-----------");
		System.out.println("subjectBdd - List de sujets: "+subjectListTemp);
		return subjectListTemp;

	}

}
