import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;


public class GraphAttr {
	private Map<Object,SimpleNode> noIds;
	private Map<Object,ASTNode_id> ids;
	public Vector<String> pilinhas= new Vector<String>();
	public static ArrayList<SimpleNode> list;
	
	public Map<Object, SimpleNode> getnoIds() {
		return noIds;
	}
	
	
	
	public GraphAttr() {
		// TODO Auto-generated constructor stub		
		noIds = new HashMap<Object,SimpleNode>();
		ids = new HashMap<Object,ASTNode_id>();
		list = new ArrayList<SimpleNode>();
		
	}
	public void inserirNo(SimpleNode node) {
	//System.out.println("Value: " +  node.value + " Key= " + node.id);
		
		
		if(node instanceof ASTNode_id) {
			System.out.println(" nodeid   "+ node.value);
			if(!checkDuplicates(node)){
				System.out.println("NodeID adicionado");
				list.add(node);		
			}
				
		}
		if(node instanceof ASTDirected) {
			System.out.println("directed value: " + node.value);
		}
		if(node instanceof ASTA_list) {
			System.out.println("edge value: " + node.value);
		}
		if(node instanceof ASTDotGraph) {
			System.out.println("dotgraph value: " + node.value);
		}
		if(node instanceof ASTUndirected) {
			System.out.println("undirected: " + node.value);
		}
		if(node instanceof ASTEdgeRHS) {
			System.out.println("edgerhs value: " + node.value);
		}
		if(node instanceof ASTEdge_stmt) {
			System.out.println("edgestmt value: " + node.value);
		}
		if(node instanceof ASTGraph) {
			System.out.println("graph value: " + node.value);
		}
		if(node instanceof ASTNova) {
			System.out.println("nova value: " + node.value);
			if(!checkDuplicates(node))
				list.add(node);	
		}
		if(node instanceof ASTPort) {
			System.out.println("port value: " + node.value);
		}
		if(node instanceof ASTSubgraph) {
			System.out.println("sub value: " + node.value);
		}
		if(node instanceof ASTTemo) {
			System.out.println("temo value: " + node.value);
		}
		if(node instanceof ASTtest) {
			System.out.println("test value: " + node.value);
		}
				
		
	}
	
	
	   
	public void printMapa() {
		Iterator<Entry<Object, ASTNode_id>> it = ids.entrySet().iterator();
		while(it.hasNext()) {
				
			Entry<Object, ASTNode_id> cena = (Map.Entry<Object, ASTNode_id>)it.next();
			System.out.println("Value: " + cena.getKey() + "\tNo: " +  cena.getValue());
			
		}
		
	/*	for(int i=0; i<pilinhas.size();i++) {
			System.out.println(pilinhas.get(i));
		}
		*/
		System.out.println( "SIZE= "+list.size());
	}
	
	public void printChildren(SimpleNode n) {
		
		
		n.dump("");
	}
	
	public boolean checkDuplicates(SimpleNode node) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(node)){
				return true;
			}
		}
		
		return false;
	}
	
	public void printList() {
		for(int i=0; i<list.size(); i++) {
			System.out.println("List: " + i + " " + list.get(i));
		}
	}
	

}



