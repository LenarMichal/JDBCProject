package model;

public class Uczniowie {
	
	private int idu;
	private String nazwisko_ucznia;
	private String imie_ucznia;
	
	public Uczniowie(int idu,String nazwisko_ucznia,String imie_ucznia){
		
		super();
		this.idu = idu;
		this.nazwisko_ucznia = nazwisko_ucznia;
		this.imie_ucznia = imie_ucznia;
	}
	
	public int getIdu() {
		return idu;
	}

	public void setIdu(int idu) {
		this.idu = idu;
	}

	public String getNazwisko_ucznia() {
		return nazwisko_ucznia;
	}

	public void setNazwisko_ucznia(String nazwisko_ucznia) {
		this.nazwisko_ucznia = nazwisko_ucznia;
	}

	public String getImie_ucznia() {
		return imie_ucznia;
	}

	public void setImie_ucznia(String imie_ucznia) {
		this.imie_ucznia = imie_ucznia;
	}

	
	
	

}
