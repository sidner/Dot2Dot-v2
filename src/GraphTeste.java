import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.layout.JGraphLayoutAlgorithm;
import org.jgraph.layout.SugiyamaLayoutAlgorithm;
import org.jgrapht.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

public class GraphTeste {

	ArrayList<SimpleNode> nodes;
	ListenableGraph graph;
	// create a visualization using JGraph, via the adapter
	JGraphModelAdapter m_jgAdapter;
	JGraph jgraph;

	public GraphTeste() {
		graph = new ListenableDirectedGraph(DefaultEdge.class);
		m_jgAdapter = new JGraphModelAdapter((Graph) graph);
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

			if (temp.value == "label")
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

	void layout(ListenableDirectedGraph graphModel, JGraphModelAdapter graphAdapter, JGraph graph) {
		List roots = new ArrayList();
		Iterator vertexIter = graphModel.vertexSet().iterator();
		while (vertexIter.hasNext()) {
			Object vertex = vertexIter.next();
			if (graphModel.inDegreeOf(vertex) == 0) {
				roots.add(graphAdapter.getVertexCell(vertex));
			}
		}

		JGraphLayoutAlgorithm layout = new SugiyamaLayoutAlgorithm();
		JGraphLayoutAlgorithm.applyLayout(graph, roots.toArray(), layout);
	}

	public void iniciarGrafico(String nome) {

		addNodes();
		jgraph.setVisible(true);

		// Frame where graph is drawn
		JFrame frame = new JFrame(nome);
		JPanel panel=new JPanel();
		panel.add(jgraph);
		JScrollPane scrollBar = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jgraph.setSize(800, 800);
		//scrollBar.add(jgraph);
		frame.setSize(600, 600);
		frame.add(scrollBar);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		layout((ListenableDirectedGraph) graph, m_jgAdapter, jgraph);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//while(true){}
	}

}
