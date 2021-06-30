package domaine;

public class Compte {

	private int idCompte;
	private String num_compte;
	private int solde;
	private boolean statut;
	private int idClient;
	private int idtypeCompte;
	private int idAgence;
	private int idAgent;
	
	
	public Compte() {
	}


	public Compte(int idCompte, String num_compte, int solde, boolean statut, int idClient, int idtypeCompte,
			int idAgence, int idAgent) {
		super();
		this.idCompte = idCompte;
		this.num_compte = num_compte;
		this.solde = solde;
		this.statut = statut;
		this.idClient = idClient;
		this.idtypeCompte = idtypeCompte;
		this.idAgence = idAgence;
		this.idAgent = idAgent;
	}


	public Compte(String num_compte, int solde, boolean statut, int idClient, int idtypeCompte, int idAgence,
			int idAgent) {
		this.num_compte = num_compte;
		this.solde = solde;
		this.statut = statut;
		this.idClient = idClient;
		this.idtypeCompte = idtypeCompte;
		this.idAgence = idAgence;
		this.idAgent = idAgent;
	}


	public String getNum_compte() {
		return num_compte;
	}


	public void setNum_compte(String num_compte) {
		this.num_compte = num_compte;
	}


	public int getSolde() {
		return solde;
	}


	public void setSolde(int solde) {
		this.solde = solde;
	}


	public boolean getStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getIdtypeCompte() {
		return idtypeCompte;
	}


	public void setIdtypeCompte(int idtypeCompte) {
		this.idtypeCompte = idtypeCompte;
	}


	public int getIdAgence() {
		return idAgence;
	}


	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}


	public int getIdAgent() {
		return idAgent;
	}


	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}


	public int getIdCompte() {
		return idCompte;
	}
	
	
	
	
	
	
	
	
	
}
