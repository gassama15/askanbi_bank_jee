package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IDaoAgentImp;
import dao.IDaoClientImp;
import dao.IDaoUserImp;
import domaine.Agent;
import domaine.Client;
import domaine.User;

/**
 * Servlet implementation class SecurityServlet
 */
@WebServlet({"/login", "/signin", "/logout", "/home"})
public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoUserImp userDao;
	private IDaoAgentImp agentDao;
	private IDaoClientImp clientDao;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		userDao = new IDaoUserImp();
		agentDao = new IDaoAgentImp();
		clientDao = new IDaoClientImp();
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
		case "/login":
			showLoginForm(request, response);
			break;
			
		case "/signin":
			signin(request, response);
			break;
			
		case "/logout":
			signout(request, response);
			break;
			
		case "/home":
			goHome(request, response);
			break;

		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("security/login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user;
		Agent agent;
		Client client;
		try {
			user = userDao.authenticate(login, password);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if (user.getRole().equals("user") || user.getRole().equals("admin")) {
					agent = agentDao.selectAgentByUserId(user.getId());					
					session.setAttribute("agent", agent);
				}
				if (user.getRole().equals("client")) {
					client = clientDao.selectClientByUserId(user.getId());					
					session.setAttribute("client", client);
				}
				response.sendRedirect("home");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("security/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void signout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("login");
	}
	
	private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("app/home.jsp");
		dispatcher.forward(request, response);
	}


}
