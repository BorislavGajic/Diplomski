package com.diplomski.model;

public class Trebovanje {
    private Integer stavkaSasSsId;
    private Integer stavkaSasSastavnicaSId;
    private Integer stanjeMagacinMId;
    private Integer stanjeMaterijalMatId;

    public Trebovanje() {
    }

    public Trebovanje(Integer stavkaSasSsId, Integer stavkaSasSastavnicaSId, Integer stanjeMagacinMId, Integer stanjeMaterijalMatId) {
        this.stavkaSasSsId = stavkaSasSsId;
        this.stavkaSasSastavnicaSId = stavkaSasSastavnicaSId;
        this.stanjeMagacinMId = stanjeMagacinMId;
        this.stanjeMaterijalMatId = stanjeMaterijalMatId;
    }

    public Integer getStavkaSasSsId() {
        return stavkaSasSsId;
    }

    public void setStavkaSasSsId(Integer stavkaSasSsId) {
        this.stavkaSasSsId = stavkaSasSsId;
    }

    public Integer getStavkaSasSastavnicaSId() {
        return stavkaSasSastavnicaSId;
    }

    public void setStavkaSasSastavnicaSId(Integer stavkaSasSastavnicaSId) {
        this.stavkaSasSastavnicaSId = stavkaSasSastavnicaSId;
    }

    public Integer getStanjeMagacinMId() {
        return stanjeMagacinMId;
    }

    public void setStanjeMagacinMId(Integer stanjeMagacinMId) {
        this.stanjeMagacinMId = stanjeMagacinMId;
    }

    public Integer getStanjeMaterijalMatId() {
        return stanjeMaterijalMatId;
    }

    public void setStanjeMaterijalMatId(Integer stanjeMaterijalMatId) {
        this.stanjeMaterijalMatId = stanjeMaterijalMatId;
    }
}
