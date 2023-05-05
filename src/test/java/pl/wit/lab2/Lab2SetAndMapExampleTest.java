package pl.wit.lab2;

import org.junit.Assert;
import org.junit.Test;

public class Lab2SetAndMapExampleTest {

    @Test
    public void addElementToSetTest() {
        Lab2SetAndMapExample lab2SetAndMapExample = new Lab2SetAndMapExample();
        lab2SetAndMapExample.addElement("Mazda");
        lab2SetAndMapExample.addElement("Audi");
        lab2SetAndMapExample.addElement("Mercedes");
        lab2SetAndMapExample.addElement("BMW");

        Assert.assertTrue(lab2SetAndMapExample.getSetCars().contains("Mazda"));
        Assert.assertTrue(lab2SetAndMapExample.getSetCars().contains("Audi"));
        Assert.assertTrue(lab2SetAndMapExample.getSetCars().contains("Mercedes"));
        Assert.assertTrue(lab2SetAndMapExample.getSetCars().contains("BMW"));
    }

    @Test
    public void addElementToMapTest() {
        Lab2SetAndMapExample lab2SetAndMapExample = new Lab2SetAndMapExample();
        lab2SetAndMapExample.addElement("100KM", 100);
        lab2SetAndMapExample.addElement("150KM", 150);
        lab2SetAndMapExample.addElement("200KM", 200);
        lab2SetAndMapExample.addElement("250KM", 250);

        Assert.assertEquals(Integer.valueOf(100), lab2SetAndMapExample.getMapCarPower().get("100KM"));
        Assert.assertEquals(Integer.valueOf(150), lab2SetAndMapExample.getMapCarPower().get("150KM"));
        Assert.assertEquals(Integer.valueOf(200), lab2SetAndMapExample.getMapCarPower().get("200KM"));
        Assert.assertEquals(Integer.valueOf(250), lab2SetAndMapExample.getMapCarPower().get("250KM"));
    }

    @Test
    public void isSetContainsTest() {
        Lab2SetAndMapExample lab2SetAndMapExample = new Lab2SetAndMapExample();
        lab2SetAndMapExample.addElement("Mazda");
        lab2SetAndMapExample.addElement("Audi");
        lab2SetAndMapExample.addElement("Mercedes");
        lab2SetAndMapExample.addElement("BMW");

        Assert.assertTrue(lab2SetAndMapExample.isSetContains("Mazda"));
        Assert.assertTrue(lab2SetAndMapExample.isSetContains("Audi"));
        Assert.assertTrue(lab2SetAndMapExample.isSetContains("Mercedes"));
        Assert.assertTrue(lab2SetAndMapExample.isSetContains("BMW"));
    }

    @Test
    public void getMapValueTest() {
        Lab2SetAndMapExample lab2SetAndMapExample = new Lab2SetAndMapExample();
        lab2SetAndMapExample.addElement("100KM", 100);
        lab2SetAndMapExample.addElement("150KM", 150);
        lab2SetAndMapExample.addElement("200KM", 200);
        lab2SetAndMapExample.addElement("250KM", 250);

        Assert.assertEquals(Integer.valueOf(100), lab2SetAndMapExample.getMapValue("100KM"));
        Assert.assertEquals(Integer.valueOf(150), lab2SetAndMapExample.getMapValue("150KM"));
        Assert.assertEquals(Integer.valueOf(200), lab2SetAndMapExample.getMapValue("200KM"));
        Assert.assertEquals(Integer.valueOf(250), lab2SetAndMapExample.getMapValue("250KM"));
    }
}
