package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.UserBdd;
import model.MyUser;

/**
 * Servlet implementation class MyGestionController
 */
@WebServlet("/MyGestionController")
public class MyGestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBdd useBdd = new UserBdd();
		List<MyUser> users = UserBdd.viewListUsers(request);
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/mygestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ArrayList<MyUser> users = (ArrayList<MyUser>)session.getAttribute("users");
		
		for (int i=0;i<users.size();i++ ) {
			Long userId = new Long(users.get(i).getUserId());
			boolean etatCheckBox = request.getParameter(userId.toString())!=null;
			if (etatCheckBox==true) {
				users.get(i).setState(etatCheckBox);
				UserBdd.updateUser(users.get(i));
				System.out.println(etatCheckBox+"   "+users.get(i).isState());
			}
		}
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/mygestion.jsp").forward(request, response);
		}

}
