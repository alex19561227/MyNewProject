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
		int age;
		int repetition;
		// Pour recuperer des informations de la vue
		String nom = request.getParameter("nom");
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			age = 0;
		}

		try {
			repetition = Integer.parseInt(request.getParameter("repetition"));
		} catch (NumberFormatException e) {
			repetition = 0;
		}

		// Pour envoyer des informations à la vue
		request.setAttribute("nom", nom);
		request.setAttribute("repetition", repetition);
		request.getRequestDispatcher("WEB-INF/mylogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";
		boolean resultat = false;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Boolean role = Boolean.parseBoolean(request.getParameter("role"));
		System.out.println("loginController -login + psw: "+login + " " + password);

		if ((login.length() == 0 || password.length() == 0)) {
			erreur = "un des champs est vide";
		} else if ((login.length() != 0 && password.equals("admin"))||(login.length() !=0 && password.equals(login))) {
			resultat = true;
		}
		else {
			erreur = "les valeurs ne correspondent pas";
		}
		if (resultat) {
			MyUser user = UserBdd.testRecord(login, password);
			if(user == null) {
				request.getRequestDispatcher("WEB-INF/myformulaire.jsp").forward(request, response);
			} else if (password.equals("admin")){
				request.getRequestDispatcher("WEB-INF/myaccescomptes.jsp").forward(request, response);
			} else if (password.equals(login)) {
				request.getSession().setAttribute("etudiantId", user.getUserId());
				request.getSession().setAttribute("etudiant", user);
				System.out.println("loginController-user: "+user);
				request.getRequestDispatcher("WEB-INF/mysubject.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("WEB-INF/mylogin.jsp").forward(request, response);
		}

	}
}