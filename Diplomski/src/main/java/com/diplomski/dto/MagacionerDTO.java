package com.diplomski.dto;

public class MagacionerDTO {
    private Integer magacinMId;
    private String jmbg;
    private String ime;
    private String prezime;
    private Integer plata;
    private Integer bonus;
    private String tekuciRacun;

    public Integer getMagacinMId() {
        return magacinMId;
    }

    public void setMagacinMId(Integer magacinMId) {
        this.magacinMId = magacinMId;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getPlata() {
        return plata;
    }

    public void setPlata(Integer plata) {
        this.plata = plata;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }
}
