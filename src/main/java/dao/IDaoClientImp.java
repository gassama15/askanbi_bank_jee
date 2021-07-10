package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.Client;
import utils.Database;

public class IDaoClientImp implements IDaoClient {
	
	private static final String INSERT_CLIENT_SQL = "INSERT INTO client VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_CLIENT = "SELECT * FROM client ORDER BY idClient DESC";
	private static final String SELECT_CLIENT_BY_ID = "SELECT * FROM client WHERE idClient = ?";
	private static final String SELECT_CLIENT_BY_USER_ID = "SELECT * FROM client WHERE user_id = ?";

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
		ArrayList<Client> clients = new ArrayList<Client>();
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_CLIENT);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idClient = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String tel = rs.getString("tel");
				String cni = rs.getString("cni");
				String email = rs.getString("email");
				String typeClient = rs.getString("typeClient");
				int user_id = rs.getInt("user_id");
				
				clients.add(new Client(idClient, nom, prenom, adresse, tel, cni, email, typeClient, user_id));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
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
		Client client = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_CLIENT_BY_ID);
			Integer[] parameters = {id};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
//				int idClient = rs.getInt(id);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String tel = rs.getString("tel");
				String cni = rs.getString("cni");
				String email = rs.getString("email");
				String typeClient = rs.getString("typeClient");
				int user_id = rs.getInt("user_id");
				
				client = new Client(id, nom, prenom, adresse, tel, cni, email, typeClient, user_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public Client selectClientByUserId(int idUser) {
		Client client = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_CLIENT_BY_USER_ID);
			Integer[] parameters = {idUser};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idClient = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String tel = rs.getString("tel");
				String cni = rs.getString("cni");
				String email = rs.getString("email");
				String typeClient = rs.getString("typeClient");
				int user_id = rs.getInt("user_id");
				
				client = new Client(idClient, nom, prenom, adresse, tel, cni, email, typeClient, user_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

}
