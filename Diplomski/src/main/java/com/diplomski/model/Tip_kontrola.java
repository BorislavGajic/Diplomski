package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Tip_kontrola {
    @EmbeddedId
    private TipKontrolaKey tipKontrolaKey;

    @ManyToOne
    @MapsId("qsId")
    @JoinColumn(name = "qsId")
    private QS_kontrola qsId;

    @ManyToOne
    @MapsId("tosId")
    @JoinColumn(name = "tosId")
    private Tip_os tosId;

    public Tip_kontrola() {
    }

    public Tip_kontrola(TipKontrolaKey tipKontrolaKey, QS_kontrola qsId, Tip_os tosId) {
        this.tipKontrolaKey = tipKontrolaKey;
        this.qsId = qsId;
        this.tosId = tosId;
    }

    public TipKontrolaKey getTipKontrolaKey() {
        return tipKontrolaKey;
    }

    public void setTipKontrolaKey(TipKontrolaKey tipKontrolaKey) {
        this.tipKontrolaKey = tipKontrolaKey;
    }

    public QS_kontrola getQsId() {
        return qsId;
    }

    public void setQsId(QS_kontrola qsId) {
        this.qsId = qsId;
    }

    public Tip_os getTosId() {
        return tosId;
    }

    public void setTosId(Tip_os tosId) {
        this.tosId = tosId;
    }
}
