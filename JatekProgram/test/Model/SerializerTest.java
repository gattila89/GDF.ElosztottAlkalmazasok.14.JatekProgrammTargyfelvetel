package Model;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializerTest {

    private Jatekos jatekos;
    private NPC npc;
    private String filepath = "jatekos1.bin";
    
    public SerializerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws TulSokTargyException {
        jatekos = new Jatekos();
        npc = new NPC();
        
        jatekos.setNev(filepath.replaceFirst(".bin", ""));
        
        Targy t1 = new Targy("Targy1", 1);
        Targy t2 = new Targy("Targy2", 2);
        
        jatekos.TargyFelvesz(t1);
        jatekos.TargyFelvesz(t2);
        
        npc.TargyFelvesz(t1);
        npc.TargyFelvesz(t2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSerializeToFile() {
        System.out.println("SerializeToFile");
        Serializer.SerializeToFile(jatekos, filepath);
    }

    @Test
    public void testDeserializeFromFile() throws Exception {
        System.out.println("DeserializeFromFile");
        File file = new File(filepath);
        Jatekos result = (Jatekos)Serializer.DeserializeFromFile(file);
        
        System.out.println("From File: ");
        System.out.println(result.getNev());
        System.out.println(result.getTargyLista().size());
        System.out.println(result.getTargyLista().get(0).getNev());
        System.out.println(result.getTargyLista().get(0).getTomeg());
        System.out.println(result.getTargyLista().get(1).getNev());
        System.out.println(result.getTargyLista().get(1).getTomeg());
        
        assertEquals(jatekos.getTargyLista().size(), result.getTargyLista().size());
        assertEquals(jatekos.getTargyLista().get(0).getNev(), result.getTargyLista().get(0).getNev());
        assertEquals(jatekos.getTargyLista().get(0).getTomeg(), result.getTargyLista().get(0).getTomeg());
        assertEquals(jatekos.getTargyLista().get(1).getNev(), result.getTargyLista().get(1).getNev());
        assertEquals(jatekos.getTargyLista().get(1).getTomeg(), result.getTargyLista().get(1).getTomeg());
    }
    
}
