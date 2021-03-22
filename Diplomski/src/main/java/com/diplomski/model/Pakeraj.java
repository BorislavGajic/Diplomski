package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pakeraj")
public class Pakeraj extends Sektor_pogona{

    public Pakeraj() {
    }
}
