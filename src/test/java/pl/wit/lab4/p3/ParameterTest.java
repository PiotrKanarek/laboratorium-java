package pl.wit.lab4.p3;

import org.junit.Test;
import pl.wit.lab4.p4.Parameter2;

public class ParameterTest {


    /**
     * Zobrazowanie działania mechanizmu
     * rzutowania na interfejs i dostępu
     * do metod
     * [To nie jest test jednostkowy,
     * a jedynie ilustracja z użyciem jUnit]
     */
    @Test
    public void paramTest() {
        Parameter p1 = new Parameter("portalId", 2);
        System.out.println(p1.myToString());
        IParameter iP1 = p1;
        //Błąd kompilacji
        //System.out.println(iP1.myToString());
        System.out.println("name2=" + iP1.getName()
                + ", value2=" + iP1.getValue().toString());
    }

    /**
     * Zobrazowanie działania mechanizmu
     * rzutowania na interfejs
     * [To nie jest test jednostkowy,
     * a jedynie ilustracja z użyciem jUnit]
     */
    @Test
    public void param2Test() {
        Parameter p1 = new Parameter("x", 20);
        Parameter2 p2 = new Parameter2("y", 15);
        IParameter params[] = new IParameter[]{p1, p2};
        for (IParameter p : params)
            System.out.println(p.debug());


    }


}
