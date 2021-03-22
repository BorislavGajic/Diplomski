package com.diplomski.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Radnik {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kancelarijaKaId")
    private Kancelarija kancelarijaKaId;

    public Admin(){}

    public Kancelarija getKancelarijaKaId() {
        return kancelarijaKaId;
    }

    public void setKancelarijaKaId(Kancelarija kancelarijaKaId) {
        this.kancelarijaKaId = kancelarijaKaId;
    }
}
