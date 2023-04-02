package pl.wit.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Lab2ArraysExampleTest {

    @Test
    public void addElementTest(){
        Lab2ArraysExample arrEx = new Lab2ArraysExample(1);
        Assert.assertArrayEquals(new int[] {1}, arrEx.getIntNumbers());

        arrEx.addElement(true);
        Assert.assertEquals(Arrays.toString(new boolean[] {true}), Arrays.toString(arrEx.getBoolElements()));

        arrEx.addElement("Test");
        Assert.assertArrayEquals(new String[] {"Test"}, arrEx.getStringElements());
    }
}
