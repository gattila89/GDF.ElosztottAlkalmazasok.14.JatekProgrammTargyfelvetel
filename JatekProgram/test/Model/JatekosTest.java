package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class JatekosTest {
    
    public JatekosTest() {
    }
    
    @Test
    public void testSebessegSzamol() {
        System.out.println("sebessegSzamol");
        Jatekos instance = new Jatekos();
        instance.sebessegSzamol();
        int expResult = instance.alapSebesseg;
        assertEquals(expResult, instance.getSebesseg());
    }
    
    @Test
    public void testTargyFelvesz() throws Exception {
        System.out.println("TargyFelvesz");
        Jatekos instance = new Jatekos();
        instance.TargyFelvesz(new Targy("Targy1", 12));
        
        int expResult = 1;
        assertEquals(expResult, instance.getTargyLista().size());
    }
    
    @Test
    public void testSebessegSzamol_ha_van_egy_targy() throws TulSokTargyException {
        System.out.println("sebessegSzamol");
        Jatekos instance = new Jatekos();
        instance.TargyFelvesz(new Targy("Targy1", 12));
        instance.sebessegSzamol();
        int expResult = instance.alapSebesseg - 12;
        assertEquals(expResult, instance.getSebesseg());
    }
    
    @Test
    public void testSebessegSzamol_ha_van_tobb_targy() throws TulSokTargyException {
        System.out.println("sebessegSzamol");
        Jatekos instance = new Jatekos();
        instance.TargyFelvesz(new Targy("Targy1", 12));
        instance.TargyFelvesz(new Targy("Targy2", 12));
        instance.sebessegSzamol();
        int expResult = instance.alapSebesseg - 12 - 12;
        assertEquals(expResult, instance.getSebesseg());
    }
    
    @Test
    public void testSebessegSzamol_ha_tul_sok_targy() throws TulSokTargyException {
        System.out.println("sebessegSzamol");
        Jatekos instance = new Jatekos();
        instance.TargyFelvesz(new Targy("Targy1", 12));
        
        TulSokTargyException exception = assertThrows(
                TulSokTargyException.class, () -> {
                instance.TargyFelvesz(new Targy("Targy2", instance.alapSebesseg + 1));});

        String expectedMessage = "Tul sok targyad van";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
