package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.QuestionaryBdd;
import bdd.SubjectBdd;
import model.MyAnswer;
import model.MyQuestion;
import model.MyQuestionary;
import model.MySubject;

/**
 * Servlet implementation class CreationQuizz2Controller
 */
@WebServlet("/CreationQuizz2Controller")
public class CreationQuizz2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationQuizz2Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sujet = (String) request.getSession().getAttribute("sujet");
		String quizz = (String) request.getSession().getAttribute("quizz");
		request.getParameter("quest" + 1);
		request.getParameter("quest" + 2);
		String[] tabQuestions = request.getParameterValues("question");
		String[] tabBonnesReponses = request.getParameterValues("bonnesreponses");
		MySubject sujetObj = new MySubject();
		sujetObj.setSubject(sujet);
		Long idSujet = SubjectBdd.insertSubject(sujetObj);
		sujetObj.setSubjectId(idSujet);
		MyQuestionary quizzObj = new MyQuestionary();
		quizzObj.setQuestionary(quizz);
		quizzObj.setState(true);
		quizzObj.setSubjectId(sujetObj);
		quizzObj.getSubjectId().setSubject(sujet);
		Long idQuest=QuestionaryBdd.insertQuestionary(quizzObj);
//		for (int i = 0; i < tabQuestions.length; i++) {
//			String[] tabReponses = request.getParameterValues("rep" + i);
//			MyQuestion questionObj = new MyQuestion(-1L,tabQuestions[i],id,true);
//			ArrayList<MyAnswer> reponsesObj = new ArrayList<>();
//			questionsObj.add(tabQuestions[i]);
//			
//			for(int j=0;j;j++)
//
//		}
//
//		System.out.println(tab[0] + tab[1]);
//		request.getParameter("rep" + 1);
//		System.out.println(request.getParameter("quest" + 1));
//		System.out.println(request.getParameter("rep" + 1));

	}

}
