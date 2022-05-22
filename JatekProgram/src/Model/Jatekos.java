package Model;

import java.io.Serializable;

public class Jatekos extends Szereplo implements Serializable {
    
    public Jatekos()
    {
        
    }
    
    public void sebessegSzamol()
    {
        setSebesseg(alapSebesseg);
        
        getTargyLista().forEach((n) -> 
                setSebesseg(getSebesseg() - n.getTomeg()));
    }
    
    @Override
    public void TargyFelvesz(Targy targy) throws TulSokTargyException
    {
        sebessegSzamol();
        if(getSebesseg() < targy.getTomeg())
        {
            throw new TulSokTargyException();
        }
        else
        {
            super.TargyFelvesz(targy);
            sebessegSzamol();
        }
    }
}
