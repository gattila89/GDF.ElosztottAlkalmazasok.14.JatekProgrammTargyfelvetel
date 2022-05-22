package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/*
* Mivel a Szereplo osztaly abstract, letre kellett hozni a test szamara egy 
* uj osztaly, melynek neve Szereplo_TestClass. Igy mar tesztelhetok az osztaly
* megvalositott funkcioi anelkul, hogy valos szarmaztatott osztalyt kelljen
* peldanyositani.
*/
public class SzereploTest {
    
    public SzereploTest() {
    }
    
    public class Szereplo_TestClass extends Szereplo {
    }
    
    @Test
    public void testGetTargyLista() {
        System.out.println("getTargyLista");
        Szereplo instance = new Szereplo_TestClass();
        int expResult = 0;
        List<Targy> result = instance.getTargyLista();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testTargyFelvesz() throws Exception {
        System.out.println("TargyFelvesz");
        Targy targy = new Targy("TesztTargy", 12);
        Szereplo instance = new Szereplo_TestClass();
        instance.TargyFelvesz(targy);
        List<Targy> result = instance.getTargyLista();
        assertEquals(1, result.size());
        assertEquals(targy.getNev(), result.get(0).getNev());
        assertEquals(targy.getTomeg(), result.get(0).getTomeg());
    }

    @Test
    public void testGetSebesseg() {
        System.out.println("getSebesseg");
        Szereplo instance = new Szereplo_TestClass();
        int expResult = 30;
        int result = instance.getSebesseg();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSebesseg() {
        System.out.println("setSebesseg");
        int sebesseg = 10;
        Szereplo instance = new Szereplo_TestClass();
        instance.setSebesseg(sebesseg);
        assertEquals(sebesseg, instance.getSebesseg());
    }

    @Test
    public void testRendezTargyListaNevSzerint() {
        System.out.println("RendezTargyListaNevSzerint");
        Szereplo instance = new Szereplo_TestClass();
        
        for(int i = 5; i > 0; i--)
        {
            String nev = "Targy" + i;
            try
            {
                instance.TargyFelvesz(new Targy(nev, i));
            }
            catch(TulSokTargyException e)
            {
                fail("Tul sok targy");
            }
        }
        
        instance.RendezTargyListaNevSzerint();
        
        List<Targy> expResult = new ArrayList<Targy>();
        expResult.add(new Targy("Targy1", 1));
        expResult.add(new Targy("Targy2", 2));
        expResult.add(new Targy("Targy3", 3));
        expResult.add(new Targy("Targy4", 4));
        expResult.add(new Targy("Targy5", 5));
        
        assertEquals(expResult.size(), instance.getTargyLista().size());
        
        for(int i = 4; i >= 0; i--)
        {
            assertEquals(expResult.get(i).getNev(), instance.getTargyLista().get(i).getNev());
            assertEquals(expResult.get(i).getTomeg(), instance.getTargyLista().get(i).getTomeg());
        }
    }

    @Test
    public void testRendezTargyListaTomegSzerint() {
        System.out.println("RendezTargyListaTomegSzerint");
        
        Szereplo instance = new Szereplo_TestClass();
        
        for(int i = 5; i > 0; i--)
        {
            String nev = "Targy" + i;
            try
            {
                instance.TargyFelvesz(new Targy(nev, i));
            }
            catch(TulSokTargyException e)
            {
                fail("Tul sok targy");
            }
        }
        
        instance.RendezTargyListaTomegSzerint();
        
        List<Targy> expResult = new ArrayList<Targy>();
        expResult.add(new Targy("Targy1", 1));
        expResult.add(new Targy("Targy2", 2));
        expResult.add(new Targy("Targy3", 3));
        expResult.add(new Targy("Targy4", 4));
        expResult.add(new Targy("Targy5", 5));
        
        assertEquals(expResult.size(), instance.getTargyLista().size());
        
        for(int i = 4; i >= 0; i--)
        {
            assertEquals(expResult.get(i).getNev(), instance.getTargyLista().get(i).getNev());
            assertEquals(expResult.get(i).getTomeg(), instance.getTargyLista().get(i).getTomeg());
        }
    }
}
