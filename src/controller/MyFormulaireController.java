package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.UserBdd;
import bdd.Utilities;
import model.MyUser;

/**
 * Servlet implementation class MyFormulaireController
 */
@WebServlet("/MyFormulaireController")
public class MyFormulaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFormulaireController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/myformulaire.jsp").forward(request,  response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String erreur="";
		String lname = request.getParameter("nom");
		String fname = request.getParameter("prenom");
		String society = request.getParameter("society");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = email+"4321";
		Date date = new Date();
		System.out.println(date);
		boolean state = false;
		boolean role = false; 
		
	
	if(lname.length()==0 ||fname.length()==0 ||society.length()==0 ||email.length()==0 ||tel.length()==0) {
		erreur = "<h2>un des champs est vide</h2>";
	}
	if("".equals(erreur)) {
		MyUser user = new MyUser(lname,fname,society,tel,email,password,date,state,role);
		request.setAttribute("user", user);
		UserBdd.insertUser(user);
		request.getRequestDispatcher("WEB-INF/myaccueil.jsp").forward(request, response);
	}else {
		request.setAttribute("erreur", erreur);
		request.setAttribute("nom", lname);
		request.setAttribute("prenom", fname);
		request.setAttribute("society", society);
		request.setAttribute("email", email);
		request.setAttribute("tel", tel);
		request.getRequestDispatcher("WEB-INF/myformulaire.jsp").forward(request, response);
	}
	System.out.println(lname+" "+fname+" "+society+" "+email+" "+tel+" ");
}

	
}
