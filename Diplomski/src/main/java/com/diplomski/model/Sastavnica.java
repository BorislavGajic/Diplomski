package com.diplomski.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sastavnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sId")
    private Integer sId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tip_sastavnica tip_sastavnicaTsId;

    @ManyToMany
    private Set<Sastavnica> sastavnicaSet;

    @ManyToMany
    private Set<Materijal> materijalSet;

    public Sastavnica() {
    }

    public Sastavnica(Integer sId, Tip_sastavnica tsId) {
        this.sId = sId;
        this.tip_sastavnicaTsId = tsId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Tip_sastavnica getTip_sastavnicaTsId() {
        return tip_sastavnicaTsId;
    }

    public void setTip_sastavnicaTsId(Tip_sastavnica tip_sastavnicaTsId) {
        this.tip_sastavnicaTsId = tip_sastavnicaTsId;
    }

    public Set<Sastavnica> getSastavn1icaSet() {
        return sastavnicaSet;
    }

    public void setSastavn1icaSet(Set<Sastavnica> sastavn1icaSet) {
        this.sastavnicaSet = sastavn1icaSet;
    }

    public Set<Materijal> getMaterijalSet() {
        return materijalSet;
    }

    public void setMaterijalSet(Set<Materijal> materijalSet) {
        this.materijalSet = materijalSet;
    }
}
