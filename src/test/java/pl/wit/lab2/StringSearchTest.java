package pl.wit.lab2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Klasa testów jednostkowych pokazujących
 * funkconlaności przeszukiwania łańcuchów znaków
 * @author Łukasz
 *
 */
public class StringSearchTest {

	@Test
	public void indexOfTest() {
		String text = "Ala ma kota";
		int startAt = text.indexOf("ma");
		
		assertEquals(4, startAt);
	}

	@Test
	public void indexOf2Test() {
		String text = "Ala ma psa";
		int startAt = text.indexOf("kota");
		
		assertEquals(-1, startAt);
	}
	
	@Test
	public void lastIndexOfTest() {
		String text = "Ala ma kota, a kot ma Alę";
		int startAt = text.lastIndexOf("kot");
		
		assertEquals(15, startAt);
	}
	
	/**
	 * Pobieranie podciągu znaków
	 */
	@Test
	public void substringTest() {
		String text = "Ala ma kota, a kot ma Alę";
		int startAt = text.lastIndexOf("kot");
		//kot ma Alę
		String text2 = text.substring(startAt);
		assertEquals(10, text2.length());
		
		String cat = text.substring(startAt, startAt+3);
		assertEquals("kot", cat);
	}
	
	/**
	 * Parsowanie łańcucha znaków
	 */
	@Test
	public void arrayOfWordsTest() {
		String text = "Ala ma kota, a kot ma Alę";
	
		String words[] = text.trim().split(" ");
		assertEquals(7, words.length);
		for(String word:words)
			System.out.println(word);
		System.out.println("----------------------------");
		for(String word:words)
			System.out.println(word.replace(",", ""));
	}
	
	@Test
	public void lastIndex2OfTest() {
		String text = "Ala ma kota, a kot ma Alę";
		
		String words[] = text.trim().split("[ ,]+");
		for(String word:words)
			System.out.println(word);
		
	}
}
