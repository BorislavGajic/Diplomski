package com.diplomski.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Osigurac {
    @Id
    @Column(name="osId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer osId;

    @Column(name = "maxNapon")
    private Integer maxNapon;
    @Column(name = "snaga")
    private Integer snaga;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moId")
    private Montaza moId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "riId")
    private Rivet riId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paId")
    private Pakeraj paId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mId")
    private Magacin mId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pcId")
    private Print_centar pcId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tosId")
    private Tip_os tosId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="tosMultipolMuId") ,
            @JoinColumn(name="tosMultipolTosId") ,
            })
    private Tos_multipol tosMultipolId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="kontrolaQsId") ,
            @JoinColumn(name="kontrolaTosId") ,
    })
    @JsonIgnore
    private Kontrola kontrola;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="testTlId") ,
            @JoinColumn(name="testTosId") ,
    })
    @JsonIgnore
    private Test test;



    public Osigurac() {
    }

    public Osigurac(Integer osId, Integer maxNapon, Integer snaga) {
        this.osId = osId;
        this.maxNapon = maxNapon;
        this.snaga = snaga;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public Integer getMaxNapon() {
        return maxNapon;
    }

    public void setMaxNapon(Integer maxNapon) {
        this.maxNapon = maxNapon;
    }

    public Integer getSnaga() {
        return snaga;
    }

    public void setSnaga(Integer snaga) {
        this.snaga = snaga;
    }

    public Kontrola getKontrola() {
        return kontrola;
    }

    public void setKontrola(Kontrola kontrola) {
        this.kontrola = kontrola;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Montaza getMoId() {
        return moId;
    }

    public void setMoId(Montaza moId) {
        this.moId = moId;
    }

    public Rivet getRiId() {
        return riId;
    }

    public void setRiId(Rivet riId) {
        this.riId = riId;
    }

    public Pakeraj getPaId() {
        return paId;
    }

    public void setPaId(Pakeraj paId) {
        this.paId = paId;
    }

    public Magacin getmId() {
        return mId;
    }

    public void setmId(Magacin mId) {
        this.mId = mId;
    }

    public Print_centar getPcId() {
        return pcId;
    }

    public void setPcId(Print_centar pcId) {
        this.pcId = pcId;
    }

    public Tip_os getTosId() {
        return tosId;
    }

    public void setTosId(Tip_os tosId) {
        this.tosId = tosId;
    }

    public Tos_multipol getTosMultipolId() {
        return tosMultipolId;
    }

    public void setTosMultipolId(Tos_multipol tosMultipolId) {
        this.tosMultipolId = tosMultipolId;
    }
}