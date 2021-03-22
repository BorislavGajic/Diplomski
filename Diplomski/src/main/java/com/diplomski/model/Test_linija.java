package com.diplomski.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Test_linija")
public class Test_linija extends Sektor_pogona{
    public Test_linija() { }

}
