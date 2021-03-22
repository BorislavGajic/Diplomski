package com.diplomski.model;

import javax.persistence.*;

@Entity
public class Stanje {
    @EmbeddedId
    private StanjeKey stanjeKey;

    @ManyToOne
    @MapsId("mId")
    @JoinColumn(name = "mId")
    private Magacin magacin;

    @ManyToOne
    @MapsId("matId")
    @JoinColumn(name = "matId")
    private Materijal materijal;

    public Stanje() {
    }

    public Stanje(Magacin magacin, Materijal materijal) {
        this.magacin = magacin;
        this.materijal = materijal;
    }

    public StanjeKey getStanjeKey() {
        return stanjeKey;
    }

    public void setStanjeKey(StanjeKey stanjeKey) {
        this.stanjeKey = stanjeKey;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }
}
