package com.diplomski.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stavka_sas {
    @EmbeddedId
    private Stavka_sasKey stavka_sasKey;

    @ManyToOne
    @MapsId("sId")
    @JoinColumn(name = "sId")
    private Sastavnica sastavnica;

    @Column(name = "kolicinaSs")
    private Integer kolicinaSs;

    @ManyToMany
    Set<Stanje> stanjeSet;

    public Stavka_sas() {
    }

    public Stavka_sas( Integer kolicinaSs, Sastavnica sId) {
        this.kolicinaSs = kolicinaSs;
        this.sastavnica = sId;
    }

    public Stavka_sasKey getStavka_sasKey() {
        return stavka_sasKey;
    }

    public void setStavka_sasKey(Stavka_sasKey stavka_sasKey) {
        this.stavka_sasKey = stavka_sasKey;
    }

    public Integer getKolicinaSs() {
        return kolicinaSs;
    }

    public void setKolicinaSs(Integer kolicinaSs) {
        this.kolicinaSs = kolicinaSs;
    }

    public Sastavnica getsId() {
        return sastavnica;
    }

    public void setsId(Sastavnica sId) {
        this.sastavnica = sId;
    }

    public Set<Stanje> getStanjeSet() {
        return stanjeSet;
    }

    public void setStanjeSet(Set<Stanje> stanjeSet) {
        this.stanjeSet = stanjeSet;
    }
}
