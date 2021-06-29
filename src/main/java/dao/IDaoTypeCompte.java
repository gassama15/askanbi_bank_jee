package dao;

import domaine.TypeCompte;

public interface IDaoTypeCompte extends IDao<TypeCompte> {
		public TypeCompte selectTypeCompteById(int idtypeCompte);
}
