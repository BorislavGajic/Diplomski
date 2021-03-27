package com.diplomski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @Column(name="testId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="tipTestTlId") ,
            @JoinColumn(name="tipTestTosId") ,
    })
    private Tip_test tip_test;

    @Column(name = "nazTest")
    private String nazTest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reId")
    private Reparacija reId;

    @OneToOne(mappedBy = "test", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Osigurac osigurac;

    public Test() {
    }

    public Test(Integer testId, Tip_test tip_test, String nazTest, Reparacija reId, Osigurac osigurac) {
        this.testId = testId;
        this.tip_test = tip_test;
        this.nazTest = nazTest;
        this.reId = reId;
        this.osigurac = osigurac;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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


    public Tip_test getTip_test() {
        return tip_test;
    }

    public void setTip_test(Tip_test tip_test) {
        this.tip_test = tip_test;
    }
}
