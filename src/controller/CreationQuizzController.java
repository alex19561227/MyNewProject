package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationQuizzController
 */
@WebServlet("/CreationQuizzController")
public class CreationQuizzController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationQuizzController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/creationquizz.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sujet = request.getParameter("sujet");
		String quizz = request.getParameter("quizz");
//		request.getSession().setAttribute("sujet", request.getParameter("sujet"));
//		request.getSession().setAttribute("quizz", request.getParameter("quizz"));
		int nbre = Integer.parseInt(request.getParameter("nbreQuestion"));
		request.getSession().setAttribute("nbres", nbre);
		request.getSession().setAttribute("sujet", sujet);
		request.getSession().setAttribute("quizz", quizz);
		System.out.println("nbre :"+nbre+ " sujet :"+sujet+ " questionnaire :"+quizz);
		request.getRequestDispatcher("WEB-INF/creationquizz2.jsp").forward(request, response);
	}

}
