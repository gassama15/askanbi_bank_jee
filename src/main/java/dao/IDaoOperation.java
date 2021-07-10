package dao;

import java.util.ArrayList;

import domaine.Operation;

public interface IDaoOperation extends IDao<Operation> {
	public Operation selectOperationById(int id);
	public ArrayList<Operation> selectAllOperation(int idCompte);
	public ArrayList<Operation> selectAllRetrait(int idCompte);
	public ArrayList<Operation> selectAllDepot(int idCompte);
}
