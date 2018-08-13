package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ParcoursBdd;
import model.MyParcours;
import model.MySubject;
import model.MyUser;

/**
 * Servlet implementation class MySubjectController
 */
@WebServlet("/MySubjectController")
public class MySubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MySubjectController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/mysubject.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// response.sendRedirect(request.getContextPath() + "/MyQuestionaryController");
		// permet de redirirger vers la servlet souhaitée
		// request.getRequestDispatcher("WEB-INF/myquestionary.jsp").forward(request,
		// response);
		// creation d'un parcours avec le subject choisi et l'utilisateur connecté
//		MyParcours monParcours = new MyParcours();
//		monParcours.setParcUser((MyUser) request.getSession().getAttribute("etudiant"));
        request.getSession().setAttribute("choixsujet", Long.parseLong(request.getParameter("choixsujet")));
//		request.getSession().setAttribute("monParcours", monParcours);
		request.getRequestDispatcher("WEB-INF/myquestionary.jsp").forward(request, response);
	}

}
