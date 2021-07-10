package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.Operation;
import utils.Database;

public class IDaoOperationImp implements IDaoOperation {
	
	private static final String INSERT_OPERATION_SQL = "INSERT INTO operation SET typeOperation=?, montant=?, idCompte=?, idAgent=?";
	private static final String SELECT_ALL_OPERATION_BY_ID_COMPTE = "SELECT * FROM operation WHERE idCompte=?";
	private static final String SELECT_ALL_OPERATION_BY_ID_COMPTE_AND_CHOICE = "SELECT * FROM operation WHERE idCompte=? AND typeOperation=?";

	@Override
	public boolean save(Operation t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_OPERATION_SQL);
			Object[] parameters = {t.getTypeOperation(), t.getMontant(), t.getIdCompte(), t.getIdAgent()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<Operation> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation modifier(Operation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Operation selectOperationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Operation> selectAllOperation(int idCompte) {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_OPERATION_BY_ID_COMPTE);
			Integer[] parameters = {idCompte};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idOperation = rs.getInt("idOperation");
				String typeOperation = rs.getString("typeOperation");
				int montant = rs.getInt("montant");
				int idAgent = rs.getInt("idAgent");
				
				operations.add(new Operation(idOperation, typeOperation, montant, idCompte, idAgent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operations;
	}

	@Override
	public ArrayList<Operation> selectAllRetrait(int idCompte) {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_OPERATION_BY_ID_COMPTE_AND_CHOICE);
			Object[] parameters = {idCompte, "retrait"};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idOperation = rs.getInt("idOperation");
				String typeOperation = rs.getString("typeOperation");
				int montant = rs.getInt("montant");
				int idAgent = rs.getInt("idAgent");
				
				operations.add(new Operation(idOperation, typeOperation, montant, idCompte, idAgent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operations;
	}

	@Override
	public ArrayList<Operation> selectAllDepot(int idCompte) {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_OPERATION_BY_ID_COMPTE_AND_CHOICE);
			Object[] parameters = {idCompte, "depot"};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idOperation = rs.getInt("idOperation");
				String typeOperation = rs.getString("typeOperation");
				int montant = rs.getInt("montant");
				int idAgent = rs.getInt("idAgent");
				
				operations.add(new Operation(idOperation, typeOperation, montant, idCompte, idAgent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operations;
	}

}
