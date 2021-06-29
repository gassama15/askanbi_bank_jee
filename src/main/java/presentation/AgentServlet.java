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
import dao.IDaoUserImp;
import domaine.Agence;
import domaine.Agent;
import domaine.User;
import utils.Database;

/**
 * Servlet implementation class AgentServlet
 */
@WebServlet({ "/agent_new", "/agent_liste", "/agent_insert", "/agent_delete", "/agent_edit", "/agent_update" })
public class AgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoAgentImp agentDao;
	private IDaoAgenceImp agenceDao;
	private IDaoUserImp userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		agentDao = new IDaoAgentImp();
		agenceDao = new IDaoAgenceImp();
		userDao = new IDaoUserImp();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
		String action = request.getServletPath();
//		if(action.equals("/addAgent")) {
//			request.getRequestDispatcher("agent/form.jsp").forward(request, response);
//		}

//		System.out.println(action);

		try {
			switch (action) {
			case "/agent_liste":
				listeAgent(request, response);
				break;
				
			case "/agent_new":
				showNewForm(request, response);
				break;

			case "/agent_insert":
				insertAgent(request, response);
				break;

			case "/agent_delete":
				deleteAgent(request, response);
				break;

			case "/agent_edit":
				showEditForm(request, response);
				break;

			case "/agent_update":
				updateAgent(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		response.getWriter().append("Served at: ").append(request.getServletPath());
	}

	
	private void listeAgent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Agent> agents = agentDao.liste();
		ArrayList<Agence> agences = agenceDao.liste();
		request.setAttribute("agents", agents);
		request.setAttribute("agences", agences);
		RequestDispatcher dispatcher = request.getRequestDispatcher("agent/index.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Agence> agences = agenceDao.liste();
		request.setAttribute("agences", agences);
		RequestDispatcher dispatcher = request.getRequestDispatcher("agent/form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num_agent = Integer.parseInt(request.getParameter("num_agent"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String role = request.getParameter("role");
		int idAgence = Integer.parseInt(request.getParameter("idAgence"));
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {
			User user = new User(login, password, role);
			Database.getInstance().getCnx().setAutoCommit(false);
			boolean user_inserted = userDao.save(user);
			 int user_id = Database.getInstance().getLastInsertedId();
			 System.out.println("user_id  " + user_id);
			 
			
			Agent agent = new Agent(num_agent, nom, prenom, idAgence, user_id);
			boolean agent_inserted = agentDao.save(agent);
						
			if (agent_inserted && user_inserted) {
				Database.getInstance().getCnx().commit();
			} else {
				Database.getInstance().getCnx().rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("agent_liste");
	}
	
	
	private void deleteAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		int user_id = agentDao.selectAgentById(id).getUser_id();
		try {
			agentDao.supprimer(id);
			userDao.supprimer(user_id);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		response.sendRedirect("agent_liste");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Agent existingAgent;
		try {
			existingAgent = agentDao.selectAgentById(id);
			ArrayList<Agence> agences = agenceDao.liste();
			request.setAttribute("agences", agences);
			request.setAttribute("agent", existingAgent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("agent/form.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	
	private void updateAgent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idAgent = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int num_agent = Integer.parseInt(request.getParameter("num_agent"));
		int idAgence = Integer.parseInt(request.getParameter("idAgence"));
		
		System.out.println(idAgent + " "+ nom+ " "+ prenom+ " "+ num_agent+ " "+ idAgence);

		
		Agent agent = new Agent(idAgent, num_agent, nom, prenom, idAgence);
		agentDao.modifier(agent);
		
		response.sendRedirect("agent_liste");
	}
	
	

}
