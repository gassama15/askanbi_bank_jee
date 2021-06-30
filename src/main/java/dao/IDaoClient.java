package dao;

import domaine.Client;

public interface IDaoClient extends IDao<Client> {
	public Client selectClientById(int id);
}
