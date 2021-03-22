package com.diplomski.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Magacioner")
public class Magacioner extends Radnik {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magacinMId")
    private Magacin magacinMId;

    public Magacioner(){}

    public Magacioner(Magacin magacinMId) {
        this.magacinMId = magacinMId;
    }

    public Magacin getMagacinMId() {
        return this.magacinMId;
    }

    public void setMagacinMId(Magacin magacinMId) {
        this.magacinMId = magacinMId;
    }
}
