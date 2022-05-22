package Model;

import java.io.Serializable;

public class Targy implements Serializable {
    private String _nev;
    
    private Integer _tomeg;
    
    public Targy()
    {
        setNev("");
        setTomeg(0);
    }
    
    public Targy(String nev, int tomeg)
    {
        setNev(nev);
        setTomeg(tomeg);
    }
    
    public String getNev()
    {
        return _nev;
    }
    
    public void setNev(String nev)
    {
        _nev = nev;
    }
    
    public Integer getTomeg()
    {
        return _tomeg;
    }
    
    public void setTomeg(Integer tomeg)
    {
        _tomeg = tomeg;
    }
}
