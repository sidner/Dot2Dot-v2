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
		graph = new ListenableDirectedGraph<Object, Object>( DefaultEdge.class );
		m_jgAdapter = new JGraphModelAdapter<Object, Object>((Graph<Object, Object>) graph);
		nodes = new ArrayList<SimpleNode>();
		jgraph = new JGraph(m_jgAdapter);
	}
	
	
	public void setNodes(ArrayList<SimpleNode> nodes) {
		this.nodes = nodes;
	}
	
	public void addNodes() {
		for(int i = 0; i<nodes.size(); i++) {
			SimpleNode temp = nodes.get(i);
			graph.addVertex(temp.value);
			if(temp.children != null) {
				for(int j = 0; j<temp.children.length; j++) {
					if(j+1 < temp.children.length){
						SimpleNode childTemp = (SimpleNode)temp.children[j+1];
						graph.addVertex(childTemp.value);
						graph.addEdge(temp.value, childTemp.value);
						j++;
					}
				}
			}
		}
		
	}
	
	
	public void iniciarGrafico() {
		
		addNodes();
		jgraph.setVisible(true);

		//Frame where graph is drawn
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
