package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.UserBdd;
import model.MyUser;

public class MyLoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/mylogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";
		boolean resultat = false;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println("loginController -login + psw: " + login + " " + password);

		if ((login.length() == 0 || password.length() == 0)) {
			erreur = "un des champs est vide";
		} else if ((login.length() != 0 && password.equals("admin"))
				|| (login.length() != 0 && password.equals(login))) {
			resultat = true;
		} else {
			erreur = "les valeurs ne correspondent pas";
		}
		if (resultat) {
			MyUser user = UserBdd.testRecord(login, password);
			if (user == null) {
				request.getRequestDispatcher("WEB-INF/myformulaire.jsp").forward(request, response);
			} else if (password.equals("admin")) {
				request.getSession().setAttribute("admin", user);
				request.getSession().setAttribute("role", Boolean.parseBoolean(request.getParameter("role")));
				System.out.println(request.getSession().getAttribute("role"));
				request.getRequestDispatcher("WEB-INF/myaccueil.jsp").forward(request, response);
			} else if (password.equals(login)) {
				request.getSession().setAttribute("etudiantId", user.getUserId());
				request.getSession().setAttribute("etudiant", user);
				request.getSession().setAttribute("role", Boolean.parseBoolean(request.getParameter("role")));
				System.out.println("loginController-userId: " + user.getUserId());
				request.getRequestDispatcher("WEB-INF/mysubject.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("WEB-INF/mylogin.jsp").forward(request, response);
		}

	}
}