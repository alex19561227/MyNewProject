package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ParcoursBdd;
import bdd.QuestionaryBdd;
import bdd.SubjectBdd;
import model.MyAnswer;
import model.MyParcours;
import model.MyQuestion;
import model.MyQuestionary;
import model.MySubject;

/**
 * Servlet implementation class MyQuestionController
 */
@WebServlet("/MyQuestionController")
public class MyQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyQuestionController() {
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
		long fin = System.currentTimeMillis();
		request.setAttribute("fin", fin);
		request.getRequestDispatcher("WEB-INF/myquestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().getAttribute("choixquestionnaire");
		long fin = System.currentTimeMillis();
		long debut = (long) request.getSession().getAttribute("debut");
		List<MyParcours> ancienparcs = ParcoursBdd
				.viewListParcours((long) (request.getSession().getAttribute("etudiantId")));
		for (int i = 0; i < ancienparcs.size(); i++) {
			ancienparcs.get(i)
					.setParcQuiz(QuestionaryBdd.viewQuizzId(ancienparcs.get(i).getParcQuiz().getQuestionaryId()));
		}
		MyParcours monParcours = (MyParcours) request.getSession().getAttribute("monParcours");
		monParcours.setTimeSpent(fin - debut);
		System.out.println("temps de monParcours: " + (monParcours.getTimeSpent()));
		monParcours
				.setParcQuiz(QuestionaryBdd.viewQuizzId((long) (request.getSession().getAttribute("questionnaire"))));
		MySubject subject = SubjectBdd.viewSujetId((long) (request.getSession().getAttribute("choixsujet")));
		ArrayList<MyAnswer> listChoix = new ArrayList<MyAnswer>();
		ArrayList<MyQuestion> questions = (ArrayList<MyQuestion>) request.getSession().getAttribute("questions");
		for (int i = 0; i < questions.size(); i++) {
			Long reponseChoisie = Long.parseLong(request.getParameter("" + questions.get(i).getQuestionId()));
			if (reponseChoisie >= 0) {

				ArrayList<MyAnswer> listReponses = questions.get(i).getMesReponses();
				Boolean trouve = false;
				int j;
				for (j = 0; !trouve && j < listReponses.size(); j++) {
					if (listReponses.get(j).getAnswerId() == reponseChoisie)
						trouve = true;
				}
				if (trouve)
					listChoix.add(listReponses.get(j - 1));
				else
					System.out.println("non trouvé");
				System.out.println("questionController-reponse choisie: " + reponseChoisie);
			}
			System.out.println("questionController-reponse choisie: " + reponseChoisie);

			monParcours.setListAnswers(listChoix);
			monParcours.calculerScore();
		}
		request.getSession().setAttribute("parcours", monParcours);
		request.getSession().setAttribute("ancienparcs", ancienparcs);
		System.out.println("parcours Controller-Liste parc:" + ancienparcs);
		request.getSession().setAttribute("subject", subject);
		System.out.println("questionController-Score:  " + monParcours.getScore());

		request.getRequestDispatcher("WEB-INF/myparcours.jsp").forward(request, response);
	}

}
