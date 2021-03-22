package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestKey implements Serializable {
    @Column(name = "tlId")
    private Integer tlId;
    @Column(name = "tosId")
    private Integer tosId;

    public TestKey() {
    }

    public TestKey(Integer tlId, Integer tosId) {
        this.tlId = tlId;
        this.tosId = tosId;
    }

    public Integer getTlId() {
        return tlId;
    }

    public void setTlId(Integer tlId) {
        this.tlId = tlId;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }
}
