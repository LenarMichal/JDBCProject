package model;

public class Nauczyciele {
	
	private int idn;
	private String nazwisko_nauczyciela;
	private String imie_nauczyciela;
	
	public Nauczyciele(int idn,String nazwisko_nauczyciela,String imie_nauczyciela){
		
		super();
		this.idn = idn;
		this.nazwisko_nauczyciela = nazwisko_nauczyciela;
		this.imie_nauczyciela = imie_nauczyciela;
	}
	
	public int getIdn() {
		return idn;
	}

	public void setIdn(int idn) {
		this.idn = idn;
	}

	public String getNazwisko_nauczyciela() {
		return nazwisko_nauczyciela;
	}

	public void setNazwisko_nauczyciela(String nazwisko_nauczyciela) {
		this.nazwisko_nauczyciela = nazwisko_nauczyciela;
	}

	public String getImie_nauczyciela() {
		return imie_nauczyciela;
	}

	public void setImie_nauczyciela(String imie_nauczyciela) {
		this.imie_nauczyciela = imie_nauczyciela;
	}

	
	
	

}
