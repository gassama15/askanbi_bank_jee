package dao;

import java.util.ArrayList;

import domaine.Client;
import utils.Database;

public class IDaoClientImp implements IDaoClient {
	
	private static final String INSERT_CLIENT_SQL = "INSERT INTO client VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public boolean save(Client t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_CLIENT_SQL);
			Object[] parameters = {t.getNom(), t.getPrenom(), t.getAdresse(), t.getTel(), t.getCni(), t.getEmail(), t.getTypeClient(), t.getUser_id()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<Client> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client modifier(Client t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client selectClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
