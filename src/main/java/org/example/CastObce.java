package org.example;

public class CastObce {
    public Integer kod;
    public String nazev;
    public Integer kodObec;

    public CastObce(Integer kod, String nazev, Integer kodObec) {
        this.kod = kod;
        this.nazev = nazev;
        this.kodObec = kodObec;
    }

    public String getNazev() {
        return nazev;
    }

    public Integer getKod() {
        return kod;
    }

    public Integer getKodObec() {
        return kodObec;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }

    public void setKodObec(Integer kodObec) {
        this.kodObec = kodObec;
    }
}
