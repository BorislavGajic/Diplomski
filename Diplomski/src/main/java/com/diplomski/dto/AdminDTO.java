package com.diplomski.dto;

public class AdminDTO {
    private Integer R_id;
    private Integer Kancelarija_Ka_id;
    private String jmbg;
    private String ime;
    private String prezime;
    private Integer plata;
    private Integer bonus;
    private String tekuciRacun;


    public Integer getR_id() {
        return R_id;
    }

    public void setR_id(Integer r_id) {
        R_id = r_id;
    }

    public Integer getKancelarija_Ka_id() {
        return Kancelarija_Ka_id;
    }

    public void setKancelarija_Ka_id(Integer kancelarija_Ka_id) {
        Kancelarija_Ka_id = kancelarija_Ka_id;
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
