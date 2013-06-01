import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class GraphToDot extends GraphAttr {

	public PrintWriter file;

	public GraphToDot(String fileName) {

		try {
			file = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro nao criado");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Bad chars");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}

	}

	public void writeFile() {
		System.out.println("vou escrever");	

		file.println(graph + " " + graphName + " ");
		file.println("{");
		
		for (int i = 0; i < list.size(); i++) {
			file.print(list.get(i).value.toString() + " ");
			writeChild(i);
			//System.out.println("SIZE: " + list.get(i).children.length);
			for (int j = 0; j < list.get(i).atributos.size(); j++) {
				//file.println(list.get(i).atributos.get(j).getKey() + ":  " + list.get(i).atributos.get(j).getValores());
				file.println(":  " + list.get(i).atributos.get(j).getValores() + " ");
			}

		}
		
		file.println();
		file.println("}");
		file.println();
		file.close();
	}

	public void writeChild(int index) {
		
			for (int i = 0; i < list.get(index).children.length; i++) {
				SimpleNode temp = (SimpleNode)list.get(index).children[i];
				file.print(temp.value + " ");
		}
	}



}
