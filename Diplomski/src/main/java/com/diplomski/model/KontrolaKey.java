package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KontrolaKey implements Serializable {
    @Column(name = "qsId")
    private Integer qsId;
    @Column(name = "tosId")
    private Integer tosId;

    public KontrolaKey() {
    }

    public KontrolaKey(Integer qsId, Integer tosId) {
        this.qsId = qsId;
        this.tosId = tosId;
    }

    public Integer getQsId() {
        return qsId;
    }

    public void setQsId(Integer qsId) {
        this.qsId = qsId;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }
}
