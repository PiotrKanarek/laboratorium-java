package pl.wit.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Klasa testów jednostkowych pokazujących zastosowanie
 * konwersji autmoatycznej oraz jawnej
 * @author Łukasz
 *
 */
public class ConversionTest {

	/**
	 * Test pokazujący konwersje na typach całkowitych
	 */
	@Test
	public void intTest() {
		int x=100001,x2;
		short y = 32001,y2;
		byte z = 127,z2;
		//automatyczna konwersja typów zgodnych
		y2 = z;
		//sprawdzenie równości wartości
		assertEquals(y2, z);
		//automatyczna konwersja typów zgodnych
		x2 =y; 
		//sprawdzenie równości wartości
		assertEquals(x2, y);
		//Utrata informacji w wyniku przesuwania bitów!!!!
		//aby dokonać konwersji  dłuższego typu na krótszy należy mieć pewność iż aktualna wartość zmieści się w zakresie typu krótszego!!!
		//if(x<=32767 && x>=-32768)
		y2 = (short)x;
		//Sprawdzenie utraty informacji
		assertNotEquals(x, y2);
		System.out.println("x="+x+", y2="+y2);
		//Utrata informacji!!!!
		// Nie należy tak robić!!! Uwaga analogiczna jak wyżej
		//if(y<=127 && y>=-128)
		z2 =(byte) y;
		//Sprawdzenie utracenia informacji
		assertNotEquals(y, z2);
		System.out.println("y="+y+", z2="+z);
	}
	
	@Test
	public void floatTest() {
		float f;
		int i = 2147483647;
		//automatyczna konwersja
		f = i;
		//sprawdzenie równości w pewnym przybliżeniu
		assertEquals(2147483647.0, f,1.0f);
		System.out.println("f="+f+", i="+i);
		
		
	}
	
	@Test
	public void doubleTest() {
		double d;
		int i = 2147483647;
		//automatyczna konwersja
		d = i;
		//sprawdzenie równości w pewnym przybliżeniu
		assertEquals(2147483647.0, d,0.00001f);
		System.out.println("f="+d+", i="+i);
		
	}
}
