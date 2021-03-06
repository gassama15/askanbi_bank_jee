package dao;

import domaine.User;

public interface IDaoUser extends IDao<User> {
		public User selectUserByLogin(String login);
		public User authenticate(String login, String password);
}
