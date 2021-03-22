package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Radni_nalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rnId")
    private Integer rnId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Kancelarija kancelarijaKaId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pogon pogonPId;


    public Radni_nalog() {
    }

    public Radni_nalog(Integer rnId, Kancelarija kancelarijaKaId, Pogon pogonPId) {
        this.rnId = rnId;
        this.kancelarijaKaId = kancelarijaKaId;
        this.pogonPId = pogonPId;
    }

    public Integer getRnId() {
        return rnId;
    }

    public void setRnId(Integer rnId) {
        this.rnId = rnId;
    }

    public Kancelarija getKancelarijaKaId() {
        return kancelarijaKaId;
    }

    public void setKancelarijaKaId(Kancelarija kancelarijaKaId) {
        this.kancelarijaKaId = kancelarijaKaId;
    }

    public Pogon getPogonPId() {
        return pogonPId;
    }

    public void setPogonPId(Pogon pogonPId) {
        this.pogonPId = pogonPId;
    }
}
