package model;

public class Oceny {
	
	private int ido;
	public int getIdo() {
		return ido;
	}

	public void setIdo(int ido) {
		this.ido = ido;
	}

	public String getWartosc_opisowa() {
		return wartosc_opisowa;
	}

	public void setWartosc_opisowa(String wartosc_opisowa) {
		this.wartosc_opisowa = wartosc_opisowa;
	}

	public float getWartosc_numeryczna() {
		return wartosc_numeryczna;
	}

	public void setWartosc_numeryczna(float wartosc_numeryczna) {
		this.wartosc_numeryczna = wartosc_numeryczna;
	}

	private String wartosc_opisowa;
	private float wartosc_numeryczna;
	
	public Oceny(int ido,String wartosc_opisowa,float wartosc_numeryczna){
		
		super();
		this.ido = ido;
		this.wartosc_opisowa = wartosc_opisowa;
		this.wartosc_numeryczna = wartosc_numeryczna;
	}
	
	


}
