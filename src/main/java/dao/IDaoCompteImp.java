package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.Compte;
import utils.Database;

public class IDaoCompteImp implements IDaoCompte {
	private static final String INSERT_COMPTE_SQL = "INSERT INTO compte SET num_compte=?, solde=?, statut=?, idClient=?, idtypeCompte=?, idAgence=?, idAgent=?";
	private static final String SELECT_COMPTE_BY_ID_CLIENT = "SELECT * FROM compte WHERE idClient=?";
	private static final String SELECT_COMPTE_BY_NUM_COMPTE = "SELECT * FROM compte WHERE num_compte=?";
	private static final String UPDATE_SOLDE_SQL = "UPDATE compte SET solde=? WHERE idCompte=?";

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

	@Override
	public Compte selectCompteByIdClient(int id) {
		Compte compte = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_COMPTE_BY_ID_CLIENT);
			Integer[] parameters = {id};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idCompte = rs.getInt("idCompte");
				String num_compte = rs.getString("num_compte");
				int solde = rs.getInt("solde");
				boolean statut = rs.getBoolean("statut");
				int idClient = rs.getInt("idClient");
				int idtypeCompte = rs.getInt("idtypeCompte");
				int idAgence = rs.getInt("idAgence");
				int idAgent = rs.getInt("idAgent");
				compte = new Compte(idCompte, num_compte, solde, statut, idClient, idtypeCompte, idAgence, idAgent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public Compte selectCompteByNumCompte(String numCompte) {
		Compte compte = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_COMPTE_BY_NUM_COMPTE);
			String[] parameters = {numCompte};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idCompte = rs.getInt("idCompte");
				String num_compte = rs.getString("num_compte");
				int solde = rs.getInt("solde");
				boolean statut = rs.getBoolean("statut");
				int idClient = rs.getInt("idClient");
				int idtypeCompte = rs.getInt("idtypeCompte");
				int idAgence = rs.getInt("idAgence");
				int idAgent = rs.getInt("idAgent");
				compte = new Compte(idCompte, num_compte, solde, statut, idClient, idtypeCompte, idAgence, idAgent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}
	
	public boolean updateSolde(int solde, int id) {
		boolean rowUpdated = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(UPDATE_SOLDE_SQL);
			Object[] parameters = {solde, id};
			db.addParameters(parameters);
			rowUpdated = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

}
