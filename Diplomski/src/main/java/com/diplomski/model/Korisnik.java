package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Korisnik {
    @Id
    @Column(name="Ko_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer koId;
    @Column(name = "korisnickoIme", nullable = false)
    private String korisnickoIme;
    @Column(name = "lozinka", nullable = false)
    private String lozinka;
    @Column(name = "aktivan")
    private Boolean aktivan;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "radnikRId")
    private Radnik radnikRId;

    public Korisnik() {
    }

    public Korisnik(Integer koId, String korisnickoIme, String lozinka, Boolean aktivan, Radnik radnikRId) {
        this.koId = koId;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.aktivan = aktivan;
        this.radnikRId = radnikRId;
    }

    public Integer getKoId() {
        return koId;
    }

    public void setKoId(Integer koId) {
        this.koId = koId;
    }

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

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Radnik getRadnikRId() {
        return radnikRId;
    }

    public void setRadnikRId(Radnik radnikRId) {
        this.radnikRId = radnikRId;
    }
}
