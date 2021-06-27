package dao;


import domaine.Agent;

public interface IDaoAgent extends IDao<Agent> {
	public Agent selectAgentById(int idAgent);
}
