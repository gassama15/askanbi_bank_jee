package dao;

import domaine.Operation;

public interface IDaoOperation extends IDao<Operation> {
	public Operation selectOperationById(int id);
}
