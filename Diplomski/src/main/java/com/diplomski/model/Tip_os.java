package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Tip_os {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tosId")
    private Integer tosId;
    @Column(name = "brPolova")
    private Integer brPolova;
    @Column(name = "nazTos")
    private String nazTos;


    public Tip_os() {
    }

    public Tip_os(Integer tosId, Integer brPolova, String nazTos) {
        this.tosId = tosId;
        this.brPolova = brPolova;
        this.nazTos = nazTos;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }

    public Integer getBrPolova() {
        return brPolova;
    }

    public void setBrPolova(Integer brPolova) {
        this.brPolova = brPolova;
    }

    public String getNazTos() {
        return nazTos;
    }

    public void setNazTos(String nazTos) {
        this.nazTos = nazTos;
    }
}
