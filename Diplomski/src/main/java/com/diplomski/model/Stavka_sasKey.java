package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Stavka_sasKey implements Serializable {

    @Column(name = "sId")
    private Integer sId;
    @Column(name = "ssId")
    private Integer ssId;

    public Stavka_sasKey() {
    }

    public Stavka_sasKey(Integer sId, Integer ssId) {
        this.sId = sId;
        this.ssId = ssId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }
}
