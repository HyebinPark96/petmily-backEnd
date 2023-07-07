package com.example.demo.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "animal")
public class AnimalDTO {
    @JacksonXmlProperty(localName = "kindCd")
    private Long kindCd;

    @JacksonXmlProperty(localName = "krm")
    private String krm;

    public Long getKindCd() {
        return kindCd;
    }

    public void setKindCd(Long kindCd) {
        this.kindCd = kindCd;
    }

    public String getKrm() {
        return krm;
    }

    public void setKrm(String krm) {
        this.krm = krm;
    }
}
