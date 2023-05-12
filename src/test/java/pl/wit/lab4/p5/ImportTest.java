package pl.wit.lab4.p5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static pl.wit.lab4.p5.Quadrat.area;


public class ImportTest {

    @Test
    public void test() {
        //Uzycie metody statycznej, ale z "importem"
        assertEquals(6d, area(2d, 3d), 0.0);
    }

}
