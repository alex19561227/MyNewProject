package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyUser;

public class MyAccueilController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String[] tab= {"Valentin", "Laurent", "William"};
//		request.setAttribute("tab", tab);
//		request.setAttribute("nom", "Alexei");
		String lname = request.getParameter("nom");
		request.setAttribute("nom", lname);
		request.getRequestDispatcher("WEB-INF/myaccueil.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                                                                                                    
	}

}
