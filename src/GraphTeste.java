import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

public class GraphTeste {

	ArrayList<SimpleNode> nodes;
	ListenableGraph<Object, ?> graph;
	// create a visualization using JGraph, via the adapter
	JGraphModelAdapter<Object, ?> m_jgAdapter;
	JGraph jgraph;

	public GraphTeste() {
		graph = new ListenableDirectedGraph<Object, Object>(DefaultEdge.class);
		m_jgAdapter = new JGraphModelAdapter<Object, Object>((Graph<Object, Object>) graph);
		nodes = new ArrayList<SimpleNode>();
		jgraph = new JGraph(m_jgAdapter);
	}

	public void setNodes(ArrayList<SimpleNode> nodes) {
		this.nodes = nodes;
	}

	public void addNodes() {
		int j = 0;
		int length = 0;
		for (int i = 0; i < nodes.size(); i++) {
			SimpleNode temp = nodes.get(i);
			System.out.println("Comecei " + temp.value);
			
			if(temp.value == "label")
				System.out.println(0);
			graph.addVertex(temp.value);

			if (temp.children != null && temp.children.length > 1) {
				length = temp.children.length;
				if (temp.value == "label")
					System.out.println(1);
				if ((((SimpleNode) temp.children[0]) instanceof ASTDirected) || (((SimpleNode) temp.children[0]) instanceof ASTUndirected)) {
					if (temp.value == "label")
						System.out.println(2);
					graph.addVertex(((SimpleNode) temp.children[1]).value);
					graph.addEdge(temp.value, ((SimpleNode) temp.children[1]).value);
					j = 1;
				} else {
					if (temp.value == "label")
						System.out.println(3);
					while (!((SimpleNode) temp.children[j] instanceof ASTNode_id)) {
						j++;
					}
					if (temp.value == "label")
						System.out.println(4);
					length++;
					graph.addVertex(((SimpleNode) temp.children[j]).value);
					graph.addEdge(temp.value, ((SimpleNode) temp.children[j]).value);
				}
				if (temp instanceof ASTNova)
					System.out.println(temp.value + " || " + (length) + "  ||  j = " + j);
				if ((length % 2) == 0) {
					for (; j < temp.children.length; j++) {
						if (j + 1 < temp.children.length) {
							SimpleNode childTemp = (SimpleNode) temp.children[j + 2];
							graph.addVertex(childTemp.value);
							graph.addEdge(((SimpleNode) temp.children[j]).value, childTemp.value);
							j++;
						}
					}
				}
				j = 0;
				System.out.println("Acabei");
			}
		}

	}

	public void iniciarGrafico() {

		addNodes();
		jgraph.setVisible(true);

		// Frame where graph is drawn
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.add(jgraph);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
