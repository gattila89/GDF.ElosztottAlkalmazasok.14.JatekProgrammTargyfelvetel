package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Szereplo implements Serializable {
    private List<Targy> targyLista;
    private int sebesseg;
    
    public Szereplo()
    {
        targyLista = new ArrayList<Targy>();
        sebesseg = 30;
    }
    
    public List<Targy> getTargyLista()
    {
        return targyLista;
    }
    
    public void TargyFelvesz(Targy targy) throws TulSokTargyException
    {
        targyLista.add(targy);
    }
    
    public int getSebesseg()
    {
        return sebesseg;
    }
    
    protected void setSebesseg(int sebesseg)
    {
        this.sebesseg = sebesseg;
    }
    
    public void RendezTargyListaNevSzerint()
    {
        Collections.sort(targyLista, (Targy t1, Targy t2) -> t1.getNev().compareTo(t2.getNev()));
    }
    
    public void RendezTargyListaTomegSzerint()
    {
        Collections.sort(targyLista, (Targy t1, Targy t2) -> t1.getTomeg().compareTo(t2.getTomeg()));
    }
}
