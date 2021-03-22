package com.diplomski.model;

public class Popunjava {
    private Integer sastavnicaSId;
    private Integer materijalMatId;

    public Popunjava() {
    }

    public Popunjava(Integer sastavnicaSId, Integer materijalMatId) {
        this.sastavnicaSId = sastavnicaSId;
        this.materijalMatId = materijalMatId;
    }

    public Integer getSastavnicaSId() {
        return sastavnicaSId;
    }

    public void setSastavnicaSId(Integer sastavnicaSId) {
        this.sastavnicaSId = sastavnicaSId;
    }

    public Integer getMaterijalMatId() {
        return materijalMatId;
    }

    public void setMaterijalMatId(Integer materijalMatId) {
        this.materijalMatId = materijalMatId;
    }
}
