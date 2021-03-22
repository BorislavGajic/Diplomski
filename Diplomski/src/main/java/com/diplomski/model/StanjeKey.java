package com.diplomski.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class StanjeKey implements Serializable {
    @Column(name = "mId")
    private Integer mId;
    @Column(name = "matId")
    private Integer matId;

    public StanjeKey() {
    }

    public StanjeKey(Integer mId, Integer matId) {
        this.mId = mId;
        this.matId = matId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

}
