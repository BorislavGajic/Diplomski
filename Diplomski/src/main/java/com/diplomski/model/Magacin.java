package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Magacin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mId")
    private Integer mId;
    @Column(name = "maxKolMaterijala")
    private Integer maxKolMaterijala;
    @Column(name = "kolViljuskara")
    private Integer kolViljuskara;
    @Column(name = "kolPaleta")
    private Integer kolPaleta;
    @Column(name = "kolOrmanaM")
    private Integer kolOrmanaM;

    public Magacin() {
    }

    public Magacin(Integer MId, Integer maxKolMaterijala, Integer kolViljuskara, Integer kolPaleta, Integer kolOrmanaM) {
        this.mId = MId;
        this.maxKolMaterijala = maxKolMaterijala;
        this.kolViljuskara = kolViljuskara;
        this.kolPaleta = kolPaleta;
        this.kolOrmanaM = kolOrmanaM;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer MId) {
        this.mId = MId;
    }

    public Integer getMaxKolMaterijala() {
        return maxKolMaterijala;
    }

    public void setMaxKolMaterijala(Integer maxKolMaterijala) {
        this.maxKolMaterijala = maxKolMaterijala;
    }

    public Integer getKolViljuskara() {
        return kolViljuskara;
    }

    public void setKolViljuskara(Integer kolViljuskara) {
        this.kolViljuskara = kolViljuskara;
    }

    public Integer getKolPaleta() {
        return kolPaleta;
    }

    public void setKolPaleta(Integer kolPaleta) {
        this.kolPaleta = kolPaleta;
    }

    public Integer getKolOrmanaM() {
        return kolOrmanaM;
    }

    public void setKolOrmanaM(Integer kolOrmanaM) {
        this.kolOrmanaM = kolOrmanaM;
    }
}
