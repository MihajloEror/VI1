package kripto;

public class KriptoState {

	public static int[] cene = {
			5, 6, 9, 12, 15, 14, 15, 9, 5, 5
	};
	
	public int getCenaZaDan(int dan) {
		return cene[dan-1];
	}
	private int kripto;
	private int bal;
	private int dan;

	public int getKripto() {
		return kripto;
	}
	public void setKripto(int kripto) {
		this.kripto = kripto;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public KriptoState(int kripto, int bal, int dan) {
		super();
		this.kripto = kripto;
		this.bal = bal;
		this.dan = dan;
	}
	@Override
	public String toString() {
		return "KriptoState [kripto=" + kripto + ", bal=" + bal + ", dan=" + dan + "]";
	}
	
}
