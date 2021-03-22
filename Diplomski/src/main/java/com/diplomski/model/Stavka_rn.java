package com.diplomski.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stavka_rn{

    @EmbeddedId
    private Stavka_rnKey stavka_rnKey;

    @ManyToOne
    @MapsId("rnId")
    @JoinColumn(name = "rnId")
    private Radni_nalog rnId;

    @Column(name = "kolicinaRn")
    private Integer kolicinaRn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matId")
    private Materijal matId;

    @ManyToMany
    Set<Stavka_sas> stavka_sasSet;

    public Stavka_rn(Radni_nalog rnId, Integer kolicinaRn, Materijal matId) {
        this.rnId = rnId;
        this.kolicinaRn = kolicinaRn;
        this.matId = matId;
    }

    public Stavka_rn() {
    }

    public Stavka_rnKey getStavka_rnKey() {
        return stavka_rnKey;
    }

    public void setStavka_rnKey(Stavka_rnKey stavka_rnKey) {
        this.stavka_rnKey = stavka_rnKey;
    }

    public Radni_nalog getRnId() {
        return rnId;
    }

    public void setRnId(Radni_nalog rnId) {
        this.rnId = rnId;
    }

    public Integer getKolicinaRn() {
        return kolicinaRn;
    }

    public void setKolicinaRn(Integer kolicinaRn) {
        this.kolicinaRn = kolicinaRn;
    }

    public Materijal getMatId() {
        return matId;
    }

    public void setMatId(Materijal matId) {
        this.matId = matId;
    }

    public Set<Stavka_sas> getStavka_sasSet() {
        return stavka_sasSet;
    }

    public void setStavka_sasSet(Set<Stavka_sas> stavka_sasSet) {
        this.stavka_sasSet = stavka_sasSet;
    }


}
