import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class GraphAttr {
	private Map<Integer,SimpleNode> mapaNos;
	private Map<String,SimpleNode> nosNo;
	
	public GraphAttr() {
		// TODO Auto-generated constructor stub
		mapaNos =  new HashMap<Integer,SimpleNode>();
		nosNo = new HashMap<String,SimpleNode>();
	}
	public void inserirNo(SimpleNode node) {
		mapaNos.put(node.id, node);
	}
	   
	public void printMapa() {
		Iterator<Entry<Integer, SimpleNode>> it = mapaNos.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println("Id: " + it.next().getKey() + "\tNo: " +  it.next().getValue());		
			Map.Entry cena = (Map.Entry<Integer, SimpleNode>)it.next();
			
		}
	}
	
	public void inserirNoNo() {
		Iterator<Entry<Integer, SimpleNode>> it = mapaNos.entrySet().iterator();
		Iterator<Entry<String, SimpleNode>> it2 = nosNo.entrySet().iterator();
		while(it.hasNext()) {
			//System.out.println("Id: " + it.next().getKey() + "\tNo: " +  it.next().getValue());		
			Map.Entry cena = (Map.Entry<Integer, SimpleNode>)it.next();
			System.out.println(cena.getKey());
			if((Integer)cena.getKey() == 5) {
				System.out.println("pila");
				nosNo.put(cena.getValue().toString(),(SimpleNode)cena.getValue());
				System.out.println("Id: " + cena.getKey() + "\tNo: " +  cena.getValue());
			}
			
		}
		System.out.println(nosNo.size());
		while(it2.hasNext()) {
			
			Map.Entry c2 = (Map.Entry<String, SimpleNode>)it2.next();
			System.out.println("Id: " + c2.getKey() + "\tNo: " +  c2.getValue());
		}
	}

}




