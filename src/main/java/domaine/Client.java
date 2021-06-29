package domaine;

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String cni;
	private String email;
	private String typeClien;
	private int user_id ;
	
	
	public Client() {
	}


	public Client(String nom, String prenom, String adresse, String tel, String cni, String email, String typeClien,
			int user_id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.cni = cni;
		this.email = email;
		this.typeClien = typeClien;
		this.user_id = user_id;
	}


	public Client(int idClient, String nom, String prenom, String adresse, String tel, String cni, String email,
			String typeClien, int user_id) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.cni = cni;
		this.email = email;
		this.typeClien = typeClien;
		this.user_id = user_id;
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


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getCni() {
		return cni;
	}


	public void setCni(String cni) {
		this.cni = cni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTypeClien() {
		return typeClien;
	}


	public void setTypeClien(String typeClien) {
		this.typeClien = typeClien;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getIdClient() {
		return idClient;
	}
	
	
}
