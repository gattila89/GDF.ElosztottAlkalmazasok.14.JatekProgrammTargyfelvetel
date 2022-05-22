package Model;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

public class TargyTest {
    
    public TargyTest() {
    }
    
    @Test
    public void testTargyTestConstruktor_1()
    {
        Targy instance = new Targy();
        String expResult = "";
        Integer expTomeg = 0;
        String result = instance.getNev();
        Integer result2 = instance.getTomeg();
        assertEquals(expResult, result);
        assertEquals(expTomeg, result2);
    }
    
    @Test
    public void testTargyTestConstruktor_2()
    {
        String expResult = "TesztTargy";
        Integer expTomeg = 0;
        
        Targy instance = new Targy(expResult, expTomeg);
        String result = instance.getNev();
        Integer result2 = instance.getTomeg();
        assertEquals(expResult, result);
        assertEquals(expTomeg, result2);
    }
    
    @Test
    public void testGetNev() {
        System.out.println("getNev");
        Targy instance = new Targy();
        String expResult = "";
        String result = instance.getNev();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNev() {
        System.out.println("setNev");
        String nev = "Attila";
        Targy instance = new Targy();
        instance.setNev(nev);
        assertEquals(nev, instance.getNev());
    }

    @Test
    public void testGetTomeg() {
        System.out.println("getTomeg");
        Targy instance = new Targy();
        Integer expResult = 0;
        Integer result = instance.getTomeg();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTomeg() {
        System.out.println("setTomeg");
        Integer tomeg = 10;
        Targy instance = new Targy();
        instance.setTomeg(tomeg);
        assertEquals(tomeg, instance.getTomeg());
    }
    
}
