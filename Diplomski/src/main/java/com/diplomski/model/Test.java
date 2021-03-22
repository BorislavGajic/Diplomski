package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Test {
    @EmbeddedId
    private TestKey testKey;

    @ManyToOne
    @MapsId("tlId")
    @JoinColumn(name = "tlId")
    private Test_linija tlId;

    @ManyToOne
    @MapsId("tosId")
    @JoinColumn(name = "tosId")
    private Tip_os tosId;

    @Column(name = "nazTest")
    private String nazTest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reId")
    private Reparacija reId;

    @OneToOne
    private Osigurac osigurac;

    public Test() {
    }

    public Test(TestKey testKey, Test_linija tlId, Tip_os tosId, String nazTest) {
        this.testKey = testKey;
        this.tlId = tlId;
        this.tosId = tosId;
        this.nazTest = nazTest;
    }

    public TestKey getTestKey() {
        return testKey;
    }

    public void setTestKey(TestKey testKey) {
        this.testKey = testKey;
    }

    public Test_linija getTlId() {
        return tlId;
    }

    public void setTlId(Test_linija tlId) {
        this.tlId = tlId;
    }

    public Tip_os getTosId() {
        return tosId;
    }

    public void setTosId(Tip_os tosId) {
        this.tosId = tosId;
    }

    public String getNazTest() {
        return nazTest;
    }

    public void setNazTest(String nazTest) {
        this.nazTest = nazTest;
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
