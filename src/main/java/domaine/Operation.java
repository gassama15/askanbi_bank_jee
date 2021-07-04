package domaine;

public class Operation {

	private int idOperation;
	private String typeOperation;
	private int montant;
	private int idCompte;
	private int idAgent;
	
	
	public Operation() {
	}


	public Operation(int idOperation, String typeOperation, int montant, int idCompte, int idAgent) {
		this.idOperation = idOperation;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.idCompte = idCompte;
		this.idAgent = idAgent;
	}


	public Operation(String typeOperation, int montant, int idCompte, int idAgent) {
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.idCompte = idCompte;
		this.idAgent = idAgent;
	}


	public String getTypeOperation() {
		return typeOperation;
	}


	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}


	public int getMontant() {
		return montant;
	}


	public void setMontant(int montant) {
		this.montant = montant;
	}


	public int getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}


	public int getIdAgent() {
		return idAgent;
	}


	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}


	public int getIdOperation() {
		return idOperation;
	}
	
	
	
	
	
}
