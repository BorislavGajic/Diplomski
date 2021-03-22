package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Tos_multipolKey implements Serializable {
    @Column(name = "muId")
    private Integer muId;
    @Column(name = "tosId")
    private Integer tosId;

    public Tos_multipolKey() {
    }

    public Tos_multipolKey(Integer muId, Integer tosId) {
        this.muId = muId;
        this.tosId = tosId;
    }

    public Integer getMuId() {
        return muId;
    }

    public void setMuId(Integer muId) {
        this.muId = muId;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }
}
