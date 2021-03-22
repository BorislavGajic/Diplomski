package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Print_centar")
public class Print_centar extends Sektor_pogona {

    public Print_centar() {
    }

}
