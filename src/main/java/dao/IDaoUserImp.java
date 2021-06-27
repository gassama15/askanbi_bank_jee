package dao;

import java.util.ArrayList;

import domaine.User;
import utils.Database;

public class IDaoUserImp implements IDaoUser {
	
	private static final String INSERT_USER_SQL =  "INSERT INTO user VALUES (null, ?, ?, ?)";

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
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
