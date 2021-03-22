package com.diplomski.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QS_kontrola")
public class QS_kontrola extends Sektor_pogona{
    public QS_kontrola() {

    }

}
