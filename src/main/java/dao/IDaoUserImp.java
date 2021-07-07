package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import domaine.User;
import utils.Database;

public class IDaoUserImp implements IDaoUser {
	
	private static final String INSERT_USER_SQL =  "INSERT INTO user VALUES (null, ?, ?, ?)";
	private static final String DELETE_USER_SQL =  "DELETE FROM user WHERE id = ?";
	private static final String SELECT_USER_BY_LOGIN_AND_PWD = "SELECT * FROM user WHERE login=? AND password=?";

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

	@Override
	public User authenticate(String login, String password) {
		User user = null;
		try {
			Database db = Database.getInstance();
			db.myPrepareStatement(SELECT_USER_BY_LOGIN_AND_PWD);
			String[] parameters = {login, password};
			db.addParameters(parameters);
			ResultSet rs = db.myExecuteQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String role = rs.getString("role");
				user = new User(id, login, password, role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
