package curs.ecenta.beans;

import curs.ecenta.interfaces.Human;

public class ProdusBean implements Human{
	private int idprodus;
	private String den_produs;
	private int pret_produs;
	private String alte_informati;
	private String link;
	
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getIdprodus() {
		return idprodus;
	}

	public void setIdprodus(int idprodus) {
		this.idprodus = idprodus;
	}

	public String getDen_produs() {
		return den_produs;
	}

	public void setDen_produs(String den_produs) {
		this.den_produs = den_produs;
	}

	public int getPret_produs() {
		return pret_produs;
	}

	public void setPret_produs(int pret_produs) {
		this.pret_produs = pret_produs;
	}

	public String getAlte_informati() {
		return alte_informati;
	}

	public void setAlte_informati(String alte_informati) {
		this.alte_informati = alte_informati;
	}

	@Override
	public String getBehavior() {
		// TODO Auto-generated method stub
		return null;
	}

}
