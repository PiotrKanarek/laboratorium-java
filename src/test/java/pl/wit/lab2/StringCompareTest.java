package pl.wit.lab2;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Klasa testów jednostkowych pokazująca problematykę porównywania
 * łańcuchów znaków
 * @author Łukasz
 *
 */
public class StringCompareTest {
	protected static final Logger log = LogManager.getLogger(StringCompareTest.class.getName());

	 /**
		 * @throws java.lang.Exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			BasicConfigurator.configure();
			
		}

		
	/**
	 * Test pokazujący pewną pułapkę dla obiektów typu String
	 * w zależności od zainicjalizowania obiektu
	 */
	@Test
	public void wrongCompareStringTest() {
		String text1 = new String("To jest tekst testowy");
		String text2 = new String("To jest tekst testowy");
		//To są różne obiekty!!!
		assertNotSame(text1, text2);
		
		if(text1==text2) {
			fail("Nie może być równości między referencjami różnych obiektów");
		}
		//Ale uwaga!!!
		String text3 = "To jest testowy napis";
		String text4 = "To jest testowy napis";
		//To już będą 2 zmienne wskazujące na ten sam obiekt
		assertSame(text3, text4);
		//Poprawme porównywanie łańcuchów - wersja bez sprawdzania weilkosci znaków
		assertTrue(text1.equalsIgnoreCase(text2));
		//Poprawme porównywanie łańcuchów - wersja ze sprawdzaniem weilkosci znaków
		assertTrue(text1.equals(text2));
	}
	
	
	@Test
	public void stringAsNotRefTest() {
		String text = new String("Ala ma kota");
		//Obiekt typu String jest niezmienny. Inaczej zachowuje się przy przekazywaniu w parametrze!!!
		addPrefix(text);
		log.info(text);
	}
	
	@Test
	public void stringBuilderAsRefTest() {
		StringBuilder text = new StringBuilder("Ala ma StringBuildera ;)");
		addPrefix(text);
		log.info(text);
	}
	
	
	protected void addPrefix(String text) {
		text = "PREFIX:"+text;
		log.info(text);
	}
	
	protected void addPrefix(StringBuilder text) {
		text.insert(0,"PREFIX:").append("SUFIX");
		log.info(text.toString());
	}
	

}
