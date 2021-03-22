package com.diplomski.model;

import javax.persistence.*;
import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "radnikTip", discriminatorType = STRING)
public abstract class Radnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rId")
    private Integer rId;
    @Column(name = "jmbg")
    private String jmbg;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "plata")
    private Integer plata;
    @Column(name = "bonus")
    private Integer bonus;
    @Column(name = "tekuciRacun")
    private String tekuciRacun;
    @Column(name = "radnikTip", insertable = false, updatable = false)
    protected String radnikTip;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getRadnikTip() {
        return radnikTip;
    }

    public void setRadnikTip(String radnikTip) {
        this.radnikTip = radnikTip;
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

    public String getRadnik_tip() {
        return radnikTip;
    }

    public void setRadnik_tip(String radnik_tip) {
        this.radnikTip = radnik_tip;
    }
}
