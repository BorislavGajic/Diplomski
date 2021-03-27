package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Tip_test {
    @EmbeddedId
    private TipTestKey tipTestKey;

    @ManyToOne
    @MapsId("tlId")
    @JoinColumn(name = "tlId")
    private Test_linija tlId;

    @ManyToOne
    @MapsId("tosId")
    @JoinColumn(name = "tosId")
    private Tip_os tosId;

    public Tip_test() {
    }

    public Tip_test(TipTestKey tipTestKey, Test_linija tlId, Tip_os tosId) {
        this.tipTestKey = tipTestKey;
        this.tlId = tlId;
        this.tosId = tosId;
    }

    public TipTestKey getTipTestKey() {
        return tipTestKey;
    }

    public void setTipTestKey(TipTestKey tipTestKey) {
        this.tipTestKey = tipTestKey;
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
}
