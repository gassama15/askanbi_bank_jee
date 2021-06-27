package domaine;

public class Agence {

	private int idAgence;
	private String nom;
	private String adresse;
	private String email;
	private String telephone;
	
	
	
	public Agence(String nom, String adresse, String email, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public Agence(int idAgence, String nom, String adresse, String email, String telephone) {
		super();
		this.idAgence = idAgence;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public int getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
