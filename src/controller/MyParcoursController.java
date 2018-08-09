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
import model.MyParcours;
import model.MyQuestionary;

/**
 * Servlet implementation class MyParcoursController
 */
@WebServlet("/MyParcoursController")
public class MyParcoursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyParcoursController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/myparcours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		MyParcours monParcours = (MyParcours) request.getSession().getAttribute("parcours");
//		List<MyParcours> userparc = ParcoursBdd.viewListParcours(Long.parseLong(request.getParameter("userId")));
//		request.getSession().setAttribute("userparc", userparc);
//		System.out.println("parcours Controller-Liste parc:"+userparc);
//		for(int i =0;i<userparc.size();i++) {
//		}
	}

}
