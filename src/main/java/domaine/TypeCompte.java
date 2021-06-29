package domaine;

public class TypeCompte {

	private int idtypeCompte;
	private String codeType;
	private String libelleType;
	
	
	public TypeCompte() {
	}


	public TypeCompte(int idtypeCompte, String codeType, String libelleType) {
		this.idtypeCompte = idtypeCompte;
		this.codeType = codeType;
		this.libelleType = libelleType;
	}


	public TypeCompte(String codeType, String libelleType) {
		this.codeType = codeType;
		this.libelleType = libelleType;
	}


	public String getCodeType() {
		return codeType;
	}


	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}


	public String getLibelleType() {
		return libelleType;
	}


	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}


	public int getIdtypeCompte() {
		return idtypeCompte;
	}
	
	
	
	
	
	
	
	
	
	
}
