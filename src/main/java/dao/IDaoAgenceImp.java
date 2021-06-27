package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.Agence;
import utils.Database;

public class IDaoAgenceImp implements IDaoAgence {
	private static final String INSERT_AGENCE_SQL =  "INSERT INTO agence" + "  (nom, adresse, email, telephone) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ALL_AGENCES = "SELECT * FROM agence";
	private static final String SELECT_AGENCE_BY_ID = "SELECT * FROM agence WHERE idAgence=?";
	private static final String UPDATE_AGENCE_SQL = "UPDATE agence SET nom=?, adresse=?, email=?, telephone=? WHERE idAgence=?";
	private static final String DELETE_AGENCE_SQL = "DELETE FROM agence WHERE idAgence=?";
	
	@Override
	public boolean save(Agence t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_AGENCE_SQL);
			Object[] parameters = {t.getNom(), t.getAdresse(), t.getEmail(), t.getTelephone()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<Agence> liste() {
		ArrayList<Agence> agences = new ArrayList<Agence>();
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_AGENCES + " ORDER BY idAgence DESC");
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idAgence=rs.getInt("idAgence");
				String nom = rs.getString("nom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				agences.add(new Agence(idAgence, nom, adresse, email, telephone));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agences;
	}

	@Override
	public Agence modifier(Agence t	) {
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(UPDATE_AGENCE_SQL);
			Object[] parameters = {t.getNom(), t.getAdresse(), t.getEmail(), t.getTelephone(), t.getIdAgence()};
			db.addParameters(parameters);
			db.myExecuteUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public void supprimer(int id) {
		Database db = Database.getInstance();
		try {
			db.myPrepareStatement(DELETE_AGENCE_SQL);
			Integer[] parameters = {id};
			db.addParameters(parameters);
			db.myExecuteUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Agence selectAgenceById(int idAgence) {
		Agence agence = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_AGENCE_BY_ID);
			Integer[] parameters = {idAgence};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				String nom = rs.getString("nom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				agence = new Agence(idAgence, nom, adresse, email, telephone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agence;
	}

	
	
}
