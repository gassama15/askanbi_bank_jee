package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDaoTypeCompteImp;
import domaine.TypeCompte;


/**
 * Servlet implementation class TypeCompteServlet
 */
@WebServlet({"/type_new", "/type_insert", "/type_liste", "/type_edit", "/type_update", "/type_delete"})
public class TypeCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoTypeCompteImp typeCompteDao;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		typeCompteDao = new IDaoTypeCompteImp();
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
		// TODO Auto-generated method stub
		
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/type_new":
				showNewForm(request, response);
				break;
				
			case "/type_insert":
				insertTypeCompte(request, response);
				break;
				
			case "/type_liste":
				listeType(request, response);
				break;
				
			case "/type_edit":
				showEditForm(request, response);
				break;
				
			case "/type_update":
				updateTypeCompte(request, response);
				break;
				
			case "/type_delete":
				deleteTypeCompte(request, response);
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("type_compte/form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTypeCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String codeType = request.getParameter("codeType");
			String libelleType = request.getParameter("libelle");
			
			TypeCompte typecpt = new TypeCompte(codeType, libelleType);
			
			typeCompteDao.save(typecpt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("type_liste");
	}
	
	
	private void listeType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<TypeCompte> typeComptes = typeCompteDao.liste();
		request.setAttribute("typeComptes", typeComptes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("type_compte/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		TypeCompte existingTypeCompte;
		try {
			existingTypeCompte = typeCompteDao.selectTypeCompteById(id);
			request.setAttribute("typeCompte", existingTypeCompte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("type_compte/form.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void updateTypeCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idtypeCompte = Integer.parseInt(request.getParameter("id"));
		String codeType = request.getParameter("codeType");
		String libelleType = request.getParameter("libelle");
		
		TypeCompte typeCpt = new TypeCompte(idtypeCompte, codeType, libelleType);
		
		typeCompteDao.modifier(typeCpt);
		
		response.sendRedirect("type_liste");
	}


	private void deleteTypeCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			typeCompteDao.supprimer(id);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		response.sendRedirect("type_liste");
	}
	

}
