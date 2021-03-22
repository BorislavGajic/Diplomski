package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Tip_sastavnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsId")
    private Integer tsId;
    @Column(name = "nazivTs")
    private String nazivTs;

    public Tip_sastavnica() {
    }

    public Tip_sastavnica(Integer tsId, String nazivTs) {
        this.tsId = tsId;
        this.nazivTs = nazivTs;
    }

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public String getNazivTs() {
        return nazivTs;
    }

    public void setNazivTs(String nazivTs) {
        this.nazivTs = nazivTs;
    }
}
