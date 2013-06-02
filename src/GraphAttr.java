import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class GraphAttr {
	private Map<Object, SimpleNode> noIds;
	private Map<Object, ASTNode_id> ids;
	public static ArrayList<SimpleNode> list;
	public static SimpleNode graph;
	public static SimpleNode graphName;
	public GraphTeste gteste = new GraphTeste();
	public static ArrayList<SimpleNode> list_gerais;
	
	public static ArrayList<SimpleNode> getList() {
		return list;
	}

	public Map<Object, SimpleNode> getnoIds() {
		return noIds;
	}

	public GraphAttr() {
		// TODO Auto-generated constructor stub
		noIds = new HashMap<Object, SimpleNode>();
		ids = new HashMap<Object, ASTNode_id>();
		list = new ArrayList<SimpleNode>();
		list_gerais = new ArrayList<SimpleNode>();
	}

	public void inserirGraph(SimpleNode node) {
		
		
		if(node instanceof ASTGraph) {
			if(!checkDuplicates(node)){
				System.out.println("GRAPH: " + node.value);
				graph = node;
			}
		}

	}

	
	public void inserirNova(SimpleNode node) {
		
		if(node instanceof ASTGraphID) {
			System.out.println("GRAPH ID: " + node.value);
			graphName = node;
		}
	
		if(node instanceof ASTAttr_smt){
			System.out.println("General element: " + node.value);
			list_gerais.add(node);
		}
		
		if (node instanceof ASTNova) {
			if (!checkDuplicates(node)) {
				System.out.println("nova value: " + node.value);
				list.add(node);
			}

		}

		/*
		 * if(node instanceof ASTDirected) {
		 * System.out.println("directed value: " + node.value); }
		 */
		if (node instanceof ASTAttr_type) {
			System.out.println("attribute type: " + node.value);
			EntryMod entrada = new EntryMod(node.value.toString(), new ArrayList<String>());
			if(node.getParent() instanceof ASTNova)
				list.get(list.size() - 1).atributos.add(entrada);
			else if(node.getParent() instanceof ASTAttr_smt)
				list_gerais.get(list_gerais.size() - 1).atributos.add(entrada);
		}
		if (node instanceof ASTA_list) {
			System.out.println("attribute value: " + node.value);
			
			EntryMod entrada = null;
			
			if(node.getParent() instanceof ASTNova)
				entrada = list.get(list.size() - 1).atributos.get(list.get(list.size() - 1).atributos.size() - 1);
			else if(node.getParent() instanceof ASTAttr_smt)
				entrada = list_gerais.get(list_gerais.size() - 1).atributos.get(list_gerais.get(list_gerais.size() - 1).atributos.size() - 1);
			
			if (entrada != null) {
				entrada.getValores().add(node.value.toString());
			} else {
				System.out.println("Null " + node.value);
			}
		}
		if (node instanceof ASTPort) {
			list.get(list.size()-1).port = node.value.toString();
		}
		/*
		 * if(node instanceof ASTDotGraph) {
		 * System.out.println("dotgraph value: " + node.value); } 
		 * if(node
		 * instanceof ASTUndirected) { System.out.println("undirected: " +
		 * node.value); } 
		 * if(node instanceof ASTEdgeRHS) {
		 * System.out.println("edgerhs value: " + node.value); } if(node
		 * instanceof ASTEdge_stmt) { System.out.println("edgestmt value: " +
		 * node.value); } 
		 * if(node instanceof ASTGraph) {
		 * System.out.println("graph value: " + node.value); } if(node
		 * instanceof AS
		 * TNova) { System.out.println("nova value: " +
		 * node.value); if(!checkDuplicates(node)) list.add(node); } if(node
		 * instanceof ASTPort) { System.out.println("port value: " +
		 * node.value); } 
		 * if(node instanceof ASTSubgraph) {
		 * System.out.println("sub value: " + node.value); } 
		 * if(node instanceof
		 * ASTTemo) { System.out.println("temo value: " + node.value); } if(node
		 * instanceof ASTtest) { System.out.println("test value: " +
		 * node.value); }
		 */

	}

	public void inserirNode_id(SimpleNode node) {
		// System.out.println("Value: " + node.value + " Key= " + node.id);

		if (node instanceof ASTNode_id) {
			if (!checkDuplicates(node)) {
				System.out.println("node_id value: " + node.value);
				// list.add(node);
			}
		}
	}

	public void printMapa() {
		Iterator<Entry<Object, ASTNode_id>> it = ids.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Object, ASTNode_id> cena = (Map.Entry<Object, ASTNode_id>) it.next();
			System.out.println("Value: " + cena.getKey() + "\tNo: " + cena.getValue());

		}
	}

	public void printChildren(SimpleNode n) {

		n.dump("");
	}

	public boolean checkDuplicates(SimpleNode node) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(node)) {
				return true;
			}
		}

		return false;
	}

	public void printList() {
		System.out.println("\n\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).value.toString());
			for (int j = 0; j < list.get(i).atributos.size(); j++) {
				System.out.println("Key: " + list.get(i).atributos.get(j).getKey() + "  Valor: " + list.get(i).atributos.get(j).getValores());
			}
			// checkChildren(list.get(i));

		}
	}

	public void checkChildren(SimpleNode node) {
		System.out.println();
		if (node.children != null) {
			for (int j = 0; j < node.children.length; j++) {
				System.out.println("Children: " + ((SimpleNode) node.children[j]).value);
			}
		}
	}

	public void preencheArray(String nome) {
		gteste.setNodes(list);
		gteste.iniciarGrafico(nome);
	}

}
