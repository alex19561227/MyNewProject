package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyUser;


public class MyUserCompteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		request.getRequestDispatcher("WEB-INF/myusercompte.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//RECUPERER LES INFOS VUE
		
		String usid=request.getParameter("usid");
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String mdp = request.getParameter("mdp");
//		String dateNai = request.getParameter("dateNai");
//		String adresse = request.getParameter("adresse");
//		String ville = request.getParameter("ville");
//		String cp = request.getParameter("cp");
//		String mail = request.getParameter("mail");
		String erreur="";
		
		
		//POUR LES MENU DEROULANT
		
//		String[] metier = request.getParameterValues("metier");
		
//		if(nom.length()==0 || prenom.length()==0 || mdp.length()==0 || dateNai.length()==0 || adresse.length()==0 || ville.length()==0 || cp.length()==0 || mail.length()==0) {
//			erreur="<h2>L'un des champ est vide !</h2>";
//		}
//		
//		if("".equals(erreur)) {
//			MyUser personne = new MyUser(lName, fName, society, phoneNumber, date, state);
//			request.setAttribute("personne", personne);
//			request.getRequestDispatcher("WEB-INF/myaccueil.jsp").forward(request,  response);
//				
//		}else {
//			//ENVOYER LES INFOS A LA VUE
//			request.setAttribute("erreur", erreur);
//			request.setAttribute("nom", nom);
//			request.setAttribute("prenom", prenom);
//			request.setAttribute("mdp", mdp);
//			request.setAttribute("dateNai", dateNai);
//			request.setAttribute("adresse", adresse);
//			request.setAttribute("vile", ville);
//			request.setAttribute("cp", cp); 		
//			request.setAttribute("metier", metier[0]);
//			request.getRequestDispatcher("WEB-INF/myusercompte.jsp").forward(request,  response);
//			
//		}
	}
}
