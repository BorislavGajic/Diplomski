package com.diplomski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Kontrola {
    @Id
    @Column(name="kontrolaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kontrolaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="tipKontrolaQsId") ,
            @JoinColumn(name="tipKontrolaTosId") ,
    })
    private Tip_kontrola tip_kontrola;

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

    public Kontrola(Integer kontrolaId, Tip_kontrola tip_kontrola, String nazKont, Reparacija reId, Osigurac osigurac) {
        this.kontrolaId = kontrolaId;
        this.tip_kontrola = tip_kontrola;
        this.nazKont = nazKont;
        this.reId = reId;
        this.osigurac = osigurac;
    }

    public Integer getKontrolaId() {
        return kontrolaId;
    }

    public void setKontrolaId(Integer kontrolaId) {
        this.kontrolaId = kontrolaId;
    }

    public Tip_kontrola getTip_kontrola() {
        return tip_kontrola;
    }

    public void setTip_kontrola(Tip_kontrola tip_kontrola) {
        this.tip_kontrola = tip_kontrola;
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
