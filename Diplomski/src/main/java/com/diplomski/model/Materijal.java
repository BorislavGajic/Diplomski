package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Materijal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matId")
    private Integer matId;
    @Column(name = "nazivMat")
    private String nazivMat;
    @Column(name = "opisMat")
    private String opisMat;

    public Materijal() {
    }

    public Materijal(Integer matId, String nazivMat, String opisMat) {
        matId = matId;
        this.nazivMat = nazivMat;
        this.opisMat = opisMat;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getNazivMat() {
        return nazivMat;
    }

    public void setNazivMat(String nazivMat) {
        this.nazivMat = nazivMat;
    }

    public String getOpisMat() {
        return opisMat;
    }

    public void setOpisMat(String opisMat) {
        this.opisMat = opisMat;
    }
}
