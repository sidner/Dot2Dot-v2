

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

public class TestCase {
/*
@Test
	public void semTypes() throws ParseException, IOException, Throwable{
		String texto1[] = new String[1]; 
				texto1[0]="src/texto1.dot";
		
		
			Dot2Dot.main(texto1);
		
		
	}
	
	*/
	@Test
	public void comTypes() throws ParseException, IOException, Throwable{
		String texto2[] = new String[1]; 
				texto2[0]="src/texto2.dot";
			Dot2Dot.main(texto2);
	}
	/*
	
	@Test
	public void conflitosPedro() throws ParseException, IOException, Throwable{
		String texto3[] = new String[1]; 
				texto3[0]="src/texto3.dot";
			Dot2Dot.main(texto3);
	}
	
	@Test
	public void test4() throws ParseException, IOException, Throwable{
		String texto4[] = new String[1]; 
				texto4[0]="src/texto4.dot";
			Dot2Dot.main(texto4);
	}
	
	@Test
	public void maisDificil() throws ParseException, IOException, Throwable{
		String texto5[] = new String[1]; 
				texto5[0]="src/texto5.dot";
			Dot2Dot.main(texto5);
	}*/
	
	@Test
	public void testesdoProf() throws ParseException, IOException, Throwable{
		String texto6[] = new String[1]; 
				for(int i=0;i<50;i++)
				{	texto6[0]= "src/teste"+i+".dot";
				
			Dot2Dot.main(texto6);
			String temp= "passei "+ "teste "+ i;
			System.out.println(temp);
				}
	}

}
