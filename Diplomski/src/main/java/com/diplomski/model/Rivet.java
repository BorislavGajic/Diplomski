package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rivet")
public class Rivet extends Sektor_pogona{

    public Rivet() {
    }


}
