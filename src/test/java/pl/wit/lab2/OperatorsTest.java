package pl.wit.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Test jednostkowy obrazujący funkcjonalność operatorów
 * @author Łukasz
 *
 */
public class OperatorsTest {

	/**
	 * Operatory przypisania i inkrementacji
	 */
	@Test
	public void assignmentOperatorsTest() {
		int x,y,z; 
		x=y=z=10; 
		assertEquals(10, x);
		assertEquals(10, y);
		assertEquals(10, z);
		x+=10;	
		assertEquals(20, x);
		x-=10;	
		assertEquals(10, x);
		x=10;
		y=++x;
		assertEquals(11, x);
		assertEquals(11, y);
		x=10;
		y=x++;
		assertEquals(11, x);
		assertEquals(10, y);
	}
	
	/**
	 * Test jednostkowy obrazujący różnicę mieszy koninkcją a koninkcją warunkową
	 */
	@Test
	public void logicOperatorsTest() {
		boolean visited = false; 
		if(isFalse()&isTrue()) {
			visited=true;
		}
		assertFalse(visited);
		visited = false;
		if(isFalse()&&isTrue()) {
			visited=true;
		}
		assertFalse(visited);	
	}

	protected boolean isTrue() {
		System.out.println("isTrue");
		return true;
	}
	
	protected boolean isFalse() {
		System.out.println("isFalse");
		return false;
	}

	
}
