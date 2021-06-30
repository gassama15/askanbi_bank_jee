package dao;

import domaine.Compte;

public interface IDaoCompte extends IDao<Compte> {
	public Compte selectCompteById(int id);
}
