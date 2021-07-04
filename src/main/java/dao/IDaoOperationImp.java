package dao;

import java.util.ArrayList;

import domaine.Operation;
import utils.Database;

public class IDaoOperationImp implements IDaoOperation {
	
	private static final String INSERT_OPERATION_SQL = "INSERT INTO operation SET typeOperation=?, montant=?, idCompte=?, idAgent=?";

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

}
