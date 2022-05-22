package Model;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

public class TargyTest {
    
    public TargyTest() {
    }
    
    //@BeforeAll
    public static void setUpClass() {
    }
    
    //@AfterAll
    public static void tearDownClass() {
    }
    
    //@BeforeEach
    public void setUp() {
    }
    
    //@AfterEach
    public void tearDown() {
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
        String nev = "";
        Targy instance = new Targy();
        instance.setNev(nev);
    }

    @Test
    public void testGetTomeg() {
        System.out.println("getTomeg");
        Targy instance = new Targy();
        Integer expResult = null;
        Integer result = instance.getTomeg();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTomeg() {
        System.out.println("setTomeg");
        Integer tomeg = null;
        Targy instance = new Targy();
        instance.setTomeg(tomeg);
    }
    
}
