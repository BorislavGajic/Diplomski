package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Tos_multipol {
    @EmbeddedId
    private Tos_multipolKey tos_multipolKey;

    @ManyToOne
    @MapsId("muId")
    @JoinColumn(name = "muId")
    private Multipol muId;

    @ManyToOne
    @MapsId("tosId")
    @JoinColumn(name = "tosId")
    private Tip_os tosId;

    public Tos_multipol() {
    }

    public Tos_multipol(Tos_multipolKey tos_multipolKey, Multipol muId, Tip_os tosId) {
        this.tos_multipolKey = tos_multipolKey;
        this.muId = muId;
        this.tosId = tosId;
    }

    public Tos_multipolKey getTos_multipolKey() {
        return tos_multipolKey;
    }

    public void setTos_multipolKey(Tos_multipolKey tos_multipolKey) {
        this.tos_multipolKey = tos_multipolKey;
    }

    public Multipol getMuId() {
        return muId;
    }

    public void setMuId(Multipol muId) {
        this.muId = muId;
    }

    public Tip_os getTosId() {
        return tosId;
    }

    public void setTosId(Tip_os tosId) {
        this.tosId = tosId;
    }
}
