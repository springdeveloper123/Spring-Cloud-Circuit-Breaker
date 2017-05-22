package com.spring.results.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Marks {

    private int language;
    private int math;
    private int art;

    public Marks(int language, int math, int art) {
        super();
        this.language = language;
        this.math = math;
        this.art = art;
    }

    public int getLanguage() {
        return language;
    }
    public void setLanguage(int language) {
        this.language = language;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getArt() {
        return art;
    }
    public void setArt(int art) {
        this.art = art;
    }

}
