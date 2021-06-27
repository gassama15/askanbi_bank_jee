package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.Agent;
import utils.Database;

public class IDaoAgentImp implements IDaoAgent {
	private static final String INSERT_AGENT_SQL =  "INSERT INTO agent VALUES (null, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_AGENTS = "SELECT * FROM agent";
	private static final String SELECT_AGENT_BY_ID = "SELECT * FROM agent WHERE idAgent=?";
	private static final String UPDATE_AGENT_SQL = "UPDATE agent SET num_agent=?, nom=?, prenom=?, idAgence=? WHERE idAgent=?";
	private static final String DELETE_AGENT_SQL = "DELETE FROM agent WHERE idAgent=?";

	@Override
	public boolean save(Agent t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_AGENT_SQL);
			Object[] parameters = {t.getNum_agent(), t.getNom(), t.getPrenom(),  t.getIdAgence(), t.getUser_id()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<Agent> liste() {
		ArrayList<Agent> agents = new ArrayList<Agent>();
		
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_AGENTS);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idAgent = rs.getInt("idAgent");
				int num_agent = rs.getInt("num_agent");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int idAgence = rs.getInt("idAgence");
				int user_id = rs.getInt("user_id");
				
				agents.add(new Agent(idAgent, num_agent, nom, prenom, idAgence, user_id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agents;
	}

	@Override
	public Agent modifier(Agent t) {
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(UPDATE_AGENT_SQL);
			Object[] parameters = {t.getNum_agent(), t.getNom(), t.getPrenom(), t.getIdAgence(), t.getIdAgent()};
			db.addParameters(parameters);
			db.myExecuteUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void supprimer(int id) {
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(DELETE_AGENT_SQL);
			Integer[] parameters = {id};
			db.addParameters(parameters);
			db.myExecuteUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Agent selectAgentById(int idAgent) {
		Agent agent = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_AGENT_BY_ID);
			Integer[] parameters = {idAgent};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int num_agent = rs.getInt("num_agent");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int idAgence = rs.getInt("idAgence");
				int user_id = rs.getInt("user_id");
				agent = new Agent(idAgent, num_agent, nom, prenom, idAgence, user_id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agent;
	}

	

}
