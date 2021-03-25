package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Kontrola {
    @EmbeddedId
    private KontrolaKey kontrolaKey;

    @ManyToOne
    @MapsId("qsId")
    @JoinColumn(name = "qsId")
    private QS_kontrola qsId;

    @ManyToOne
    @MapsId("tosId")
    @JoinColumn(name = "tosId")
    private Tip_os tosId;

    @Column(name = "nazKont")
    private String nazKont;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reId")
    private Reparacija reId;

    @OneToOne(mappedBy = "kontrola", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Osigurac osigurac;

    public Kontrola() {
    }

    public Kontrola(KontrolaKey kontrolaKey, QS_kontrola qsId, Tip_os tosId, String nazKont) {
        this.kontrolaKey = kontrolaKey;
        this.qsId = qsId;
        this.tosId = tosId;
        this.nazKont = nazKont;
    }

    public KontrolaKey getKontrolaKey() {
        return kontrolaKey;
    }

    public void setKontrolaKey(KontrolaKey kontrolaKey) {
        this.kontrolaKey = kontrolaKey;
    }

    public QS_kontrola getQsId() {
        return qsId;
    }

    public void setQsId(QS_kontrola qsId) {
        this.qsId = qsId;
    }

    public Tip_os getTosId() {
        return tosId;
    }

    public void setTosId(Tip_os tosId) {
        this.tosId = tosId;
    }

    public String getNazKont() {
        return nazKont;
    }

    public void setNazKont(String nazKont) {
        this.nazKont = nazKont;
    }

    public Reparacija getReId() {
        return reId;
    }

    public void setReId(Reparacija reId) {
        this.reId = reId;
    }

    public Osigurac getOsigurac() {
        return osigurac;
    }

    public void setOsigurac(Osigurac osigurac) {
        this.osigurac = osigurac;
    }
}
