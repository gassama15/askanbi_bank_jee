package presentation;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IDaoAgentImp;
import dao.IDaoCompteImp;
import dao.IDaoOperationImp;
import domaine.Agent;
import domaine.Client;
import domaine.Compte;
import domaine.Operation;
import domaine.User;
import utils.Database;



/**
 * Servlet implementation class OperationServlet
 */
@WebServlet({"/operation_new", "/operation_insert", "/all_history", "/retrait_history", "/depot_history", "/consult", "/display_amount", "/consult_solde"})
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoOperationImp operationDao;
	private IDaoCompteImp compteDao;
	private IDaoAgentImp agentDao;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		operationDao = new IDaoOperationImp();
		compteDao = new IDaoCompteImp();
		agentDao = new IDaoAgentImp();
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
		switch (action) {
		case "/operation_new":
			showNewForm(request, response);
			break;
			
		case "/operation_insert":
			insertOperation(request, response);
			break;
			
		case "/all_history":
			getAllHistory(request, response);
			break;
			
		case "/retrait_history":
			getRetraitHistory(request, response);
			break;
			
		case "/depot_history":
			getDepotHistory(request, response);
			break;
			
		case "/consult":
			showConsultationSoldeForm(request, response);
			
		case "/display_amount":
			displayAmount(request, response);
			break;
			
		case "/consult_solde":
			showAmount(request, response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Agent> agents = agentDao.liste();
		request.setAttribute("agents", agents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("operation/form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			int idAgent = Integer.parseInt(request.getParameter("idAgent"));
			String num_compte = request.getParameter("num_compte");
			int montant = Integer.parseInt(request.getParameter("montant"));
			String typeOperation = request.getParameter("typeOperation");
//			System.out.println("num_compte ---> " +num_compte+" montant ---> " +montant+" typeOperation ---> "+typeOperation);
			Compte compte = compteDao.selectCompteByNumCompte(num_compte);
			if (compte != null) {
				if (typeOperation.equals("retrait")) {
					if (compte.getSolde() > montant) {
						int new_solde = compte.getSolde() - montant;
						boolean compteUpdated = false;
						Database.getInstance().getCnx().setAutoCommit(false);
						boolean operationInserted = false;
						Operation operation = new Operation(typeOperation, montant, compte.getIdCompte(), idAgent);
						operationInserted = operationDao.save(operation);
						compteUpdated = compteDao.updateSolde(new_solde, compte.getIdCompte());
						if (operationInserted && compteUpdated) {
							Database.getInstance().getCnx().commit();
							response.sendRedirect("operation_new");
						}else {
							Database.getInstance().getCnx().rollback();
							response.sendRedirect("operation_new");
						}
					}else {
						System.out.println("Votre solde est inférieur au montant que vous souhaiter retirer.");
						response.sendRedirect("operation_new");
					}
				}else {
					int newSolde = compte.getSolde() + montant;
					boolean compte_updated = false;
					Database.getInstance().getCnx().setAutoCommit(false);
					compte_updated = compteDao.updateSolde(newSolde, compte.getIdCompte());
					boolean operation_inserted = false;
					Operation operation = new Operation(typeOperation, montant, compte.getIdCompte(), idAgent);
					operation_inserted = operationDao.save(operation);
					if (operation_inserted && compte_updated) {
						Database.getInstance().getCnx().commit();
						response.sendRedirect("operation_new");
					}else {
						Database.getInstance().getCnx().rollback();
						response.sendRedirect("operation_new");
					}
				}
			} else {
				System.out.println("numero de compte invalide");
				response.sendRedirect("operation_new");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getAllHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Client client = (Client) session.getAttribute("client");
			Compte compte = compteDao.selectCompteByIdClient(client.getIdClient());
			ArrayList<Operation> operations = operationDao.selectAllOperation(compte.getIdCompte());
			request.setAttribute("operations", operations);
			RequestDispatcher dispatcher = request.getRequestDispatcher("operation/all_history.jsp");
			dispatcher.forward(request, response);
			System.out.println("idClient ---> "+client.getIdClient()+" idUser -->  "+user.getId()+" idCompte ---> "+compte.getIdCompte());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void getRetraitHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Client client = (Client) session.getAttribute("client");
			Compte compte = compteDao.selectCompteByIdClient(client.getIdClient());
			ArrayList<Operation> operations = operationDao.selectAllRetrait(compte.getIdCompte());
			request.setAttribute("operations", operations);
			RequestDispatcher dispatcher = request.getRequestDispatcher("operation/retrait_history.jsp");
			dispatcher.forward(request, response);
			System.out.println("idClient ---> "+client.getIdClient()+" idUser -->  "+user.getId()+" idCompte ---> "+compte.getIdCompte());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void getDepotHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Client client = (Client) session.getAttribute("client");
			Compte compte = compteDao.selectCompteByIdClient(client.getIdClient());
			ArrayList<Operation> operations = operationDao.selectAllDepot(compte.getIdCompte());
			request.setAttribute("operations", operations);
			RequestDispatcher dispatcher = request.getRequestDispatcher("operation/depot_history.jsp");
			dispatcher.forward(request, response);
			System.out.println("idClient ---> "+client.getIdClient()+" idUser -->  "+user.getId()+" idCompte ---> "+compte.getIdCompte());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showConsultationSoldeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("operation/consult_amount.jsp");
		dispatcher.forward(request, response);
	}
	
	private void displayAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String num_compte = request.getParameter("num_compte");
			NumberFormat formatter = NumberFormat.getInstance(new Locale("fr_FR"));
			Compte compte = compteDao.selectCompteByNumCompte(num_compte);
			if (compte != null) {
				int solde = compte.getSolde();
				request.setAttribute("solde", (String) formatter.format(solde).replace(",", " "));
				RequestDispatcher dispatcher = request.getRequestDispatcher("operation/consult_amount.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("numero de compte invalide");
				response.sendRedirect("consult");
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	private void showAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			Compte compte = compteDao.selectCompteByIdClient(client.getIdClient());
			NumberFormat formatter = NumberFormat.getInstance(new Locale("fr_FR"));
			if (compte != null) {
				int solde = compte.getSolde();
				request.setAttribute("solde", (String) formatter.format(solde).replace(",", " "));
				RequestDispatcher dispatcher = request.getRequestDispatcher("operation/consult_amount.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("Ooops Erreur! veuillez rééssayer ultérieurement.");
				response.sendRedirect("home");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
