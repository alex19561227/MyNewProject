package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ParcoursBdd;
import bdd.QuestionaryBdd;
import model.MyParcours;
import model.MyQuestionary;
import model.MyUser;

/**
 * Servlet implementation class MyQuestionaryController
 */
@WebServlet("/MyQuestionaryController")
public class MyQuestionaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyQuestionaryController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long questionnaire = Long.parseLong(request.getParameter("choixquestionnaire"));
		request.getSession().setAttribute("questionnaire", questionnaire); // set Attribut dans la session
		System.out.println("questionaryController-1-questonary: " + questionnaire);
		MyParcours monParcours = new MyParcours();
		monParcours.setParcUser((MyUser) request.getSession().getAttribute("etudiant"));
		request.getSession().setAttribute("monParcours", monParcours);
		System.out.println("questionaryController-2-questionnaire:" + questionnaire);
		long debut = System.currentTimeMillis();
		request.getSession().setAttribute("debut", debut);
		request.getRequestDispatcher("WEB-INF/myquestion.jsp").forward(request, response);
	}

}
