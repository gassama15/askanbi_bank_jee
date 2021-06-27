package domaine;

public class Agent {

	private int idAgent;
	private int num_agent;
	private String nom;
	private String prenom;
	private int idAgence;
	private int user_id;
	
	
	
	
	
	
	
	public Agent(int idAgent, int num_agent, String nom, String prenom, int idAgence) {
		super();
		this.idAgent = idAgent;
		this.num_agent = num_agent;
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
	}





	public Agent(int idAgent, int num_agent, String nom, String prenom, int idAgence, int user_id) {
		super();
		this.idAgent = idAgent;
		this.num_agent = num_agent;
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
		this.user_id = user_id;
	}


	


	public Agent(int num_agent, String nom, String prenom, int idAgence, int user_id) {
		super();
		this.num_agent = num_agent;
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
		this.user_id = user_id;
	}





	public Agent() {
	}



	public int getNum_agent() {
		return num_agent;
	}
	public void setNum_agent(int num_agent) {
		this.num_agent = num_agent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}





	public int getIdAgent() {
		return idAgent;
	}
	
	
	
	
}
