package com.diplomski.dto;

public class KontrolaDTO {
    private Integer kontrolaId;
    private Integer qsId;
    private Integer tosId;
    private String nazKont;
    private Integer reId;
    private Integer osId;

    public Integer getKontrolaId() {
        return kontrolaId;
    }

    public void setKontrolaId(Integer kontrolaId) {
        this.kontrolaId = kontrolaId;
    }

    public Integer getQsId() {
        return qsId;
    }

    public void setQsId(Integer qsId) {
        this.qsId = qsId;
    }

    public Integer getTosId() {
        return tosId;
    }

    public void setTosId(Integer tosId) {
        this.tosId = tosId;
    }

    public String getNazKont() {
        return nazKont;
    }

    public void setNazKont(String nazKont) {
        this.nazKont = nazKont;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }
}
