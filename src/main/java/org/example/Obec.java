package org.example;

public class Obec {
    public String nazev;
    public Integer kod;

    public Obec(String nazev, Integer kod) {
        this.nazev = nazev;
        this.kod = kod;
    }

    public String getNazev() {
        return nazev;
    }

    public Integer getKod() {
        return kod;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }
}
