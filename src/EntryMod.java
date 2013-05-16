import java.util.ArrayList;


public class EntryMod {

	private String key;
	private ArrayList<String> valores = new ArrayList<String>();
	
	public EntryMod(String e, ArrayList<String> v) {
		key = e;
		valores = v;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ArrayList<String> getValores() {
		return valores;
	}
	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}
}
