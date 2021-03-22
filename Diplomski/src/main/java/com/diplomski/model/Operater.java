package com.diplomski.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Operater")
public class Operater extends Radnik {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pogonPId")
    private Pogon pogonPId;

    public Operater() {
    }

    public Operater(Pogon pogonPId) {
        this.pogonPId = pogonPId;
    }

    public Pogon getPogonPId() {
        return pogonPId;
    }

    public void setPogonPId(Pogon pogonPId) {
        this.pogonPId = pogonPId;
    }
}
