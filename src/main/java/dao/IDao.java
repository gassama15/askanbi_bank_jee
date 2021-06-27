package dao;

import java.util.ArrayList;

public interface IDao<T> {
	public boolean save(T t);
	public ArrayList<T> liste();
	public T modifier(T t);
	public void supprimer(int id);
}
