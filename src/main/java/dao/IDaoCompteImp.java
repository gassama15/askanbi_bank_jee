package dao;

import java.util.ArrayList;

import domaine.Compte;
import utils.Database;

public class IDaoCompteImp implements IDaoCompte {
	private static final String INSERT_COMPTE_SQL = "INSERT INTO compte SET num_compte=?, solde=?, statut=?, idClient=?, idtypeCompte=?, idAgence=?, idAgent=?";

	@Override
	public boolean save(Compte t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_COMPTE_SQL);
			Object[] parameters = {t.getNum_compte(), t.getSolde(), t.getStatut(), t.getIdClient(), t.getIdtypeCompte(), t.getIdAgence(), t.getIdAgent()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<Compte> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte modifier(Compte t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte selectCompteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
