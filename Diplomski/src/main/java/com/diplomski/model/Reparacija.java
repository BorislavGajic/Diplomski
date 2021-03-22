package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Reparacija")
public class Reparacija extends Sektor_pogona {

    public Reparacija() {
    }

}
