package pl.wit.lab2;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Klasa testowa ukazująca różnice implementacyjne 
 * manipulacji na ciągach znaków
 * @author Łukasz Sosnowski
 *
 */
public class StringLab2Test {

	protected static final Logger log = LogManager.getLogger(StringLab2Test.class.getName());
	
	/**
	 * Domyślna konfiguracja loggera na konsolę
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}

	/**
	 * Wielokrotne modyfikowanie łańcucha znaków z użyciem operatora +
	 * zapisanego w obiekcie klasy String
	 * Metoda niepolecana!!!
	 */
	@Test
	public void stringModifierTest() {
		long start = System.currentTimeMillis();  
		
		String item = "Ala ma kota. ";
		for(int i=0;i<50000;i++) {
			item=item+"Ala ma kota. ";
		}
		long end = System.currentTimeMillis();
		log.info("Czas wykonania 'stringModifierTest'="+(end-start)+" ms");
		log.info("rozmiar="+item.length());
	}
	
	/**
	 * Wileokrotne modyfikowanie łańcucha znaków z użyciem metody konktaenacji
	 * zapisnego w obiekcie klasy String
	 */
	@Test
	public void stringModifierConcatTest() {
		long start = System.currentTimeMillis();
		String item = "Ala ma kota. ";
		for(int i=0;i<50000;i++) {
			item=item.concat("Ala ma kota. ");
		}
		long end = System.currentTimeMillis();
		log.info("Czas wykonania 'stringModifierConcatTest'="+(end-start)+" ms");
		log.info("rozmiar="+item.length());
	}

	/**
	 * Wielokrotne modyfikowanie łańcucha znaków zapisanego w obiekcie klasy
	 * StringBuilder i na końcu zapisanego do obiektu String
	 */
	@Test
	public void stringBuilderTest() {
		long start = System.currentTimeMillis();
		
		StringBuilder sbItem = new StringBuilder("Ala ma kota. ");
		for(int i=0;i<50000;i++) {
			sbItem.append("Ala ma kota. ");
		}
		String result = sbItem.toString();
		long end = System.currentTimeMillis();
		log.info("Czas wykonania 'stringBuilderTest'="+(end-start)+" ms");
		log.info("rozmiar="+result.length());
	}

	/**
	 * Wielokrotne wykonanie małej liczby łączenia łańcuchów przy użyciu operatora +
	 */
	@Test
	public void stringModifierManyShortTest() {
		long start = System.currentTimeMillis();
		String item = "";
		for (int i = 0; i < 50000; i++) {
			item = new String("Ala ma kota. ");
			item = item + ", test"; 
			item = item+ ", test.jsp";
		}
		long end = System.currentTimeMillis();
		log.info("Czas wykonania 'stringModifierManyShortTest'=" + (end-start) + " ms");
		log.info("rozmiar=" + item.length());
	}

	/**
	 * Wielokreonie wykonanie małej liczby modyfikacji łańcuch
	 * powołując każdorazowo nowy obiekt
	 */
	@Test
	public void stringBuilderManyShortTest() {
		long start = System.currentTimeMillis();
		StringBuilder sbItem = null;

		for (int i = 0; i < 50000; i++) {
			sbItem = new StringBuilder("Ala ma kota. ");
			sbItem.append(", test");
			sbItem.append(", test.jsp");
		}
		String result = sbItem.toString();
		long end = System.currentTimeMillis();
		log.info("Czas wykonania dla 'stringBuilderManyShortTest'=" + (end-start) + " ms");
		log.info("rozmiar=" + result.length());

	}
	
	@Test
	public void creatingNewObjectStringTest() {
		String tmp = new String("Testowy napis");
		String tmp2 = new String(tmp);
		String tmp3 = "Testowy napis";
		String tmp4 = "Testowy napis";
		
		assertNotSame(tmp,tmp2);
		assertNotSame(tmp,tmp3);
		assertNotSame(tmp2,tmp3);
		//!!!
		assertSame(tmp3,tmp4);
	
		assertNotSame(tmp,tmp4);
		assertNotSame(tmp2,tmp4);
	}
	
	
}
