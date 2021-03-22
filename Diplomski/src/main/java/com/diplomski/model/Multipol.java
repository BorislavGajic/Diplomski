package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Multipol")
public class Multipol extends Sektor_pogona{

    public Multipol() {
    }
}
