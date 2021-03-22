package com.diplomski.dto;

public class KorisnikDTO {
    private String korisnickoIme;
    private String lozinka;
    private Integer radnikRId;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Integer getRadnikRId() {
        return radnikRId;
    }

    public void setRadnikRId(Integer radnikRId) {
        this.radnikRId = radnikRId;
    }
}
