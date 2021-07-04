package dao;

import domaine.Compte;

public interface IDaoCompte extends IDao<Compte> {
	public Compte selectCompteById(int id);
	public Compte selectCompteByIdClient(int id);
	public Compte selectCompteByNumCompte(String num_compte);
}
