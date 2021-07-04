package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDaoAgentImp;
import dao.IDaoCompteImp;
import dao.IDaoOperationImp;
import domaine.Agent;
import domaine.Compte;
import domaine.Operation;
import utils.Database;



/**
 * Servlet implementation class OperationServlet
 */
@WebServlet({"/operation_new", "/operation_insert"})
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
						Operation operation = new Operation(typeOperation, montant, new_solde, idAgent);
						operationInserted = operationDao.save(operation);
						compteUpdated = compteDao.updateSolde(new_solde, compte.getIdCompte());
						if (operationInserted && compteUpdated) {
							Database.getInstance().getCnx().commit();
						}else {
							Database.getInstance().getCnx().rollback();
						}
					}else {
						System.out.println("Votre solde est inférieur au montant que vous souhaiter retirer.");
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
					}else {
						Database.getInstance().getCnx().rollback();
					}
				}
			} else {
				System.out.println("numero de compte invalide");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
