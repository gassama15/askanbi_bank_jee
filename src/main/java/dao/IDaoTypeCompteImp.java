package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.TypeCompte;
import utils.Database;

public class IDaoTypeCompteImp implements IDaoTypeCompte {
	
	private static final String INSERT_TYPE_COMPTE_SQL = "INSERT INTO typeCompte VALUES (null, ?, ?)";
	private static final String SELECT_ALL_TYPE = "SELECT * FROM typeCompte";
	private static final String SELECT_TYPE_BY_ID = "SELECT * FROM typeCompte WHERE idtypeCompte = ?";
	private static final String UPDATE_TYPE_SQL = "UPDATE typeCompte SET codeType=?, libelleType=? WHERE idtypeCompte=?";
	private static final String DELETE_TYPE_SQL = "DELETE FROM typeCompte WHERE idtypeCompte=?";

	@Override
	public boolean save(TypeCompte t) {
		boolean rowInserted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(INSERT_TYPE_COMPTE_SQL);
			Object[] parameters = {t.getCodeType(), t.getLibelleType()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return rowInserted;
	}

	@Override
	public ArrayList<TypeCompte> liste() {
		ArrayList<TypeCompte> types = new ArrayList<TypeCompte>();
		
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_ALL_TYPE);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				int idtypeCompte = rs.getInt("idtypeCompte");
				String codeType = rs.getString("codeType");
				String libelleTpe = rs.getString("libelleType");
				
				types.add(new TypeCompte(idtypeCompte, codeType, libelleTpe));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return types;
	}

	@Override
	public TypeCompte modifier(TypeCompte t) {
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(UPDATE_TYPE_SQL);
			Object[] parameters = {t.getCodeType(), t.getLibelleType(), t.getIdtypeCompte()};
			db.addParameters(parameters);
			db.myExecuteUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public boolean supprimer(int id) {
		boolean rowDeleted = false;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(DELETE_TYPE_SQL);
			Integer[] paramaeters = {id};
			db.addParameters(paramaeters);
			rowDeleted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public TypeCompte selectTypeCompteById(int idtypeCompte) {
		TypeCompte typeCpt = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_TYPE_BY_ID);
			Integer[] parameters = {idtypeCompte};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			
			while (rs.next()) {
				String codeType = rs.getString("codeType");
				String libelleType = rs.getString("libelleType");
				typeCpt = new TypeCompte(idtypeCompte, codeType, libelleType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return typeCpt;
	}

}
