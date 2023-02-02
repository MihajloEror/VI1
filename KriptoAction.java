package kripto;

import dmi.vi1.search.framework.Action;

public class KriptoAction implements Action {

	public String akcija; //kupi, prodaj, cekaj
	@Override
	public boolean isNoOpAction() {
		return false;
	}
	public String getAkcija() {
		return akcija;
	}
	public void setAkcija(String akrcija) {
		this.akcija = akrcija;
	}
	@Override
	public String toString() {
		return "KriptoAction [akcija=" + akcija + "]";
	}
	public KriptoAction(String akcija) {
		super();
		this.akcija = akcija;
	}
	
	

}
