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
import dao.IDaoAgentImp;
import dao.IDaoClientImp;
import dao.IDaoCompteImp;
import dao.IDaoTypeCompteImp;
import dao.IDaoUserImp;
import domaine.Agence;
import domaine.Agent;
import domaine.Client;
import domaine.Compte;
import domaine.TypeCompte;
import domaine.User;
import utils.Database;

/**
 * Servlet implementation class ClientCompteServlet
 */
@WebServlet({"/client_new", "/client_insert", "/client_liste", "/client_show"})
public class ClientCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoAgentImp agentDao;
	private IDaoAgenceImp agenceDao;
	private IDaoUserImp userDao;
	private IDaoClientImp clientDao;
	private IDaoCompteImp compteDao;
	private IDaoTypeCompteImp typeDao;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		agentDao = new IDaoAgentImp();
		agenceDao = new IDaoAgenceImp();
		userDao = new IDaoUserImp();
		clientDao = new IDaoClientImp();
		compteDao = new IDaoCompteImp();
		typeDao = new IDaoTypeCompteImp();
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
			case "/client_liste":
				listeClient(request, response);
				break;

			case "/client_new":
				showNewForm(request, response);
				break;
				
			case "/client_insert":
				insertClientandCompte(request, response);
				break;
				
			case "/client_show":
				showDetails(request, response);
				break;
				
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Agence> agences = agenceDao.liste();
		ArrayList<Agent> agents = agentDao.liste();
		ArrayList<TypeCompte> typeComptes = typeDao.liste();
		request.setAttribute("agences", agences);
		request.setAttribute("agents", agents);
		request.setAttribute("typeComptes", typeComptes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client_compte/create-compte.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertClientandCompte(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String cni = request.getParameter("cni");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String typeClient = request.getParameter("typeClient");
		String role = request.getParameter("role");
		String num_compte = request.getParameter("num_compte");
		int solde = Integer.parseInt(request.getParameter("solde"));
		int idAgence = Integer.parseInt(request.getParameter("idAgence"));
		int idAgent = Integer.parseInt(request.getParameter("idAgent"));
		int idtypeCompte = Integer.parseInt(request.getParameter("idtypeCompte"));
		boolean statut = true;
		
		try {
			User user = new User(login, password, role);
			Database.getInstance().getCnx().setAutoCommit(false);
			boolean user_inserted = userDao.save(user);
			int user_id = Database.getInstance().getLastInsertedId();
			
			Client client = new Client(nom, prenom, adresse, tel, cni, email, typeClient, user_id);
			boolean client_inserted = clientDao.save(client);
			int client_id = Database.getInstance().getLastInsertedId();
			
			Compte compte = new Compte(num_compte, solde, statut, client_id, idtypeCompte, idAgence, idAgent);
			boolean compte_inserted = compteDao.save(compte);
			
			if (user_inserted && client_inserted && compte_inserted) {
				Database.getInstance().getCnx().commit();
			} else {
				Database.getInstance().getCnx().rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("client_liste");
	}
	
	private void listeClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<Client> clients = clientDao.liste();
		request.setAttribute("clients", clients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client_compte/liste-client.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Client client = null;
		Compte compte = null;
		int id = Integer.parseInt(request.getParameter("id"));
		client = clientDao.selectClientById(id);
		compte = compteDao.selectCompteByIdClient(client.getIdClient());
		ArrayList<TypeCompte> typeComptes = typeDao.liste();
		request.setAttribute("client", client);
		request.setAttribute("compte", compte);
		request.setAttribute("typeComptes", typeComptes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client_compte/show-details.jsp");
		dispatcher.forward(request, response);
	}


}
