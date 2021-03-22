package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Kancelarija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kaId")
    private Integer kaId;
    @Column(name = "kolStolicaK")
    private Integer kolStolicaK;
    @Column(name = "kolStolovaK")
    private Integer kolStolovaK;
    @Column(name = "kolOrmanaK")
    private Integer kolOrmanaK;
    @Column(name = "kolRacunara")
    private Integer kolRacunara;

    public Kancelarija(){}

    public Kancelarija(Integer kaId, Integer kolStolicaK, Integer kolStolovaK, Integer kolOrmanaK, Integer kolRacunara) {
        this.kaId = kaId;
        this.kolStolicaK = kolStolicaK;
        this.kolStolovaK = kolStolovaK;
        this.kolOrmanaK = kolOrmanaK;
        this.kolRacunara = kolRacunara;
    }

    public Integer getKaId() {
        return kaId;
    }

    public void setKaId(Integer kaId) {
        this.kaId = kaId;
    }

    public Integer getKolStolicaK() {
        return kolStolicaK;
    }

    public void setKolStolicaK(Integer kolStolicaK) {
        this.kolStolicaK = kolStolicaK;
    }

    public Integer getKolStolovaK() {
        return kolStolovaK;
    }

    public void setKolStolovaK(Integer kolStolovaK) {
        this.kolStolovaK = kolStolovaK;
    }

    public Integer getKolOrmanaK() {
        return kolOrmanaK;
    }

    public void setKolOrmanaK(Integer kolOrmanaK) {
        this.kolOrmanaK = kolOrmanaK;
    }

    public Integer getKolRacunara() {
        return kolRacunara;
    }

    public void setKolRacunara(Integer kolRacunara) {
        this.kolRacunara = kolRacunara;
    }
}
