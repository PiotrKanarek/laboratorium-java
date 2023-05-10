package pl.wit.lab4.p1;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

public class StudentDemoTest {

    @Test
    public void addPointsTest() throws PersonException {
        LinkedHashMap<String, Byte> mapPoints = new LinkedHashMap<>();
        StudentDemo student = new StudentDemo("Jakub", "Nowak", mapPoints);
        student.addPoints("Kolokwium 1", (byte) 12);
        student.addPoints("Kolokwium 2", (byte) 20);
        student.addPoints("Egzamin", (byte) 30);

        Assert.assertTrue(mapPoints.containsKey("Kolokwium 1"));
        Assert.assertTrue(mapPoints.containsKey("Kolokwium 2"));
        Assert.assertTrue(mapPoints.containsKey("Egzamin"));

        Assert.assertEquals("12", mapPoints.get("Kolokwium 1").toString());
        Assert.assertEquals("20", mapPoints.get("Kolokwium 2").toString());
        Assert.assertEquals("30", mapPoints.get("Egzamin").toString());

        Assert.assertEquals(3, mapPoints.size());
    }

    @Test(expected = PersonException.class)
    public void PersonExceptionBecauseOfWrongNumberOfPointsIsThrown() throws PersonException {
        LinkedHashMap<String, Byte> mapPoints = new LinkedHashMap<>();
        StudentDemo student = new StudentDemo("Jakub", "Nowak", mapPoints);
        student.addPoints("Kolokwium 1", (byte) -12);
    }

    @Test(expected = PersonException.class)
    public void PersonExceptionBecauseOfEmptyCriterionIsThrown() throws PersonException {
        LinkedHashMap<String, Byte> mapPoints = new LinkedHashMap<>();
        StudentDemo student = new StudentDemo("Jakub", "Nowak", mapPoints);
        student.addPoints("", (byte) 12);
    }

    @Test
    public void getPersonType() {
        StudentDemo student = new StudentDemo("Jakub", "Nowak", null);

        Assert.assertEquals("student", student.getPersonType().toString());
    }
}