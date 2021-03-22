package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Montaza")
public class Montaza extends Sektor_pogona{

    public Montaza() {
    }

}
