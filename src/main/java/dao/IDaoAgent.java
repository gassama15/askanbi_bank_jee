package dao;


import domaine.Agent;

public interface IDaoAgent extends IDao<Agent> {
	public Agent selectAgentById(int idAgent);
	public Agent selectAgentByUserId(int user_id);
}
