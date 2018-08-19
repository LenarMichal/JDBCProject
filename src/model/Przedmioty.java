package model;

public class Przedmioty {
	
	private int idp;
	private String nazwa_przedmiotu;
	
	
	
	public int getIdp() {
		return idp;
	}


	public void setIdp(int idp) {
		this.idp = idp;
	}


	public String getNazwa_przedmiotu() {
		return nazwa_przedmiotu;
	}


	public void setNazwa_przedmiotu(String nazwa_przedmiotu) {
		this.nazwa_przedmiotu = nazwa_przedmiotu;
	}


	
	
	
	public Przedmioty(String nazwa_przedmiotu,int idp){
		
		super();
		this.idp = idp;
		this.nazwa_przedmiotu = nazwa_przedmiotu;
		
	}
	
	



}
