package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Stavka_rnKey implements Serializable {

    @Column(name = "rnId")
    private Integer rnId;
    @Column(name = "srnId")
    private Integer srnId;

    public Stavka_rnKey() {
    }

    public Stavka_rnKey(Integer rnId, Integer srnId) {
        this.rnId = rnId;
        this.srnId = srnId;
    }

    public Integer getSrnId() {
        return srnId;
    }

    public void setSrnId(Integer srnId) {
        this.srnId = srnId;
    }

    public Integer getRnId() {
        return rnId;
    }

    public void setRnId(Integer rnId) {
        this.rnId = rnId;
    }
}