package dao;

import domaine.Agence;

public interface IDaoAgence extends IDao<Agence> {

	public Agence selectAgenceById(int idAgence);
}
