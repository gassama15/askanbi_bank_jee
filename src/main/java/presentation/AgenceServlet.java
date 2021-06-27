package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.IDaoAgenceImp;
import domaine.Agence;

/**
 * Servlet implementation class AgenceServlet
 */
@WebServlet("/")
public class AgenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoAgenceImp agenceDao; 
       
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
   public void init() throws ServletException
   {
	   agenceDao = new IDaoAgenceImp();
   }
   
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new": 
				showNewForm(request, response);
				break;
				
			case "/insert": 
				insertAgence(request, response);
				break;
				
			case "/delete": 
				deleteAgence(request, response);
				break;
				
			case "/edit": 
				showEditForm(request, response);
				break;
				
			case "/update": 
				updateAgence(request, response);
				break;
				
			default:
				listeAgence(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	private void listeAgence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Agence> agences = agenceDao.liste();
			request.setAttribute("agences", agences);
			RequestDispatcher dispatcher = request.getRequestDispatcher("agence/index.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("agence/form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertAgence(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		
		Agence newAgence = new Agence(nom, adresse, email, telephone);
		
		agenceDao.save(newAgence);
		response.sendRedirect("list");
	}
	
	
	private void deleteAgence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			agenceDao.supprimer(id);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Agence existingAgence;
		try {
			existingAgence = agenceDao.selectAgenceById(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("agence/form.jsp");
			request.setAttribute("agence", existingAgence);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	
	
	private void updateAgence(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		
		System.out.println(id + " "+ nom+ " "+ adresse+ " "+ email+ " "+ telephone);
		
		Agence agence = new Agence(id, nom, adresse, email, telephone);
		agenceDao.modifier(agence);
		response.sendRedirect("list");
	}
	
	
	
	
	

}
