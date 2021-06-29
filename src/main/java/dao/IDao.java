package dao;

import java.util.ArrayList;

public interface IDao<T> {
	public boolean save(T t);
	public ArrayList<T> liste();
	public T modifier(T t);
	public boolean supprimer(int id);
}
