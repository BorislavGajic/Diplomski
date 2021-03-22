package com.diplomski.model;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tipSp", discriminatorType = STRING)
public abstract class Sektor_pogona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spId")
    private Integer spId;
    @Column(name = "maxKolZap")
    private Integer maxKolZap;
    @Column(name = "kolMasinaSp")
    private Integer kolMasinaSp;
    @Column(name = "povrsina")
    private Integer povrsina;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pogonPId")
    private Pogon pogonPId;
    @Column(name = "nazivSp")
    private String nazivSp;
    @Column(name = "tipSp", insertable = false, updatable = false)
    private String tipSp;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getMaxKolZap() {
        return maxKolZap;
    }

    public void setMaxKolZap(Integer maxKolZap) {
        this.maxKolZap = maxKolZap;
    }

    public Integer getKolMasinaSp() {
        return kolMasinaSp;
    }

    public void setKolMasinaSp(Integer kolMasinaSp) {
        this.kolMasinaSp = kolMasinaSp;
    }

    public Integer getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(Integer povrsina) {
        this.povrsina = povrsina;
    }

    public Pogon getPogonPId() {
        return pogonPId;
    }

    public void setPogonPId(Pogon pogonPId) {
        this.pogonPId = pogonPId;
    }

    public String getNazivSp() {
        return nazivSp;
    }

    public void setNazivSp(String nazivSp) {
        this.nazivSp = nazivSp;
    }

    public String getTipSp() {
        return tipSp;
    }

    public void setTipSp(String tipSp) {
        this.tipSp = tipSp;
    }
}
