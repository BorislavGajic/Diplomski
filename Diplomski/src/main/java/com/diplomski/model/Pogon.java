package com.diplomski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Pogon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private Integer pId;
    @Column(name = "kolOrmanaP")
    private Integer kolOrmanaP;
    @Column(name = "kolStolicaP")
    private Integer kolStolicaP;
    @Column(name = "kolStolovaP")
    private Integer kolStolovaP;
    @Column(name = "kolMasinaP")
    private Integer kolMasinaP;

    public Pogon() {
    }

    public Pogon(Integer pId, Integer kolOrmanaP, Integer kolStolicaP, Integer kolStolovaP, Integer kolMasinaP) {
        this.pId = pId;
        this.kolOrmanaP = kolOrmanaP;
        this.kolStolicaP = kolStolicaP;
        this.kolStolovaP = kolStolovaP;
        this.kolMasinaP = kolMasinaP;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getKolOrmanaP() {
        return kolOrmanaP;
    }

    public void setKolOrmanaP(Integer kolOrmanaP) {
        this.kolOrmanaP = kolOrmanaP;
    }

    public Integer getKolStolicaP() {
        return kolStolicaP;
    }

    public void setKolStolicaP(Integer kolStolicaP) {
        this.kolStolicaP = kolStolicaP;
    }

    public Integer getKolStolovaP() {
        return kolStolovaP;
    }

    public void setKolStolovaP(Integer kolStolovaP) {
        this.kolStolovaP = kolStolovaP;
    }

    public Integer getKolMasinaP() {
        return kolMasinaP;
    }

    public void setKolMasinaP(Integer kolMasinaP) {
        this.kolMasinaP = kolMasinaP;
    }
}
