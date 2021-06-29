package dao;

import java.util.ArrayList;

import domaine.User;
import utils.Database;

public class IDaoUserImp implements IDaoUser {
	
	private static final String INSERT_USER_SQL =  "INSERT INTO user VALUES (null, ?, ?, ?)";
	private static final String DELETE_USER_SQL =  "DELETE FROM user WHERE id = ?";

	@Override
	public boolean save(User t) {
		Database db = Database.getInstance();
		boolean rowInserted = false;
		try {
			db.myPrepareStatement(INSERT_USER_SQL);
			Object[] parameters = {t.getLogin(), t.getPassword(), t.getRole()};
			db.addParameters(parameters);
			rowInserted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}

	@Override
	public ArrayList<User> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User modifier(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(int id) {
		boolean rowDeleted = false;
		Database db = Database.getInstance();
		try {
			db.myPrepareStatement(DELETE_USER_SQL);
			Integer[] parameters = {id};
			db.addParameters(parameters);
			rowDeleted = db.myExecuteUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public User selectUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
