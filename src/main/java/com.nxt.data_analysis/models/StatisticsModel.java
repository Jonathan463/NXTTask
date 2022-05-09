package com.nxt.data_analysis.models;

public class StatisticsModel {
    private String nameOfStat;
    private String valueOfStat;
    private String nameOfFile;
    public StatisticsModel() {
    }

    public StatisticsModel(String nameOfStat, String valueOfStat) {
        this.nameOfStat = nameOfStat;
        this.valueOfStat = valueOfStat;
    }

    public String getNameOfStat() {
        return nameOfStat;
    }

    public void setNameOfStat(String nameOfStat) {
        this.nameOfStat = nameOfStat;
    }

    public String getValueOfStat() {
        return valueOfStat;
    }

    public void setValueOfStat(String valueOfStat) {
        this.valueOfStat = valueOfStat;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public void logStatNameAndValue(){
        System.out.println("Name of file  " + getNameOfFile());
        System.out.println(getNameOfStat() + "   ===   " + getValueOfStat());
        System.out.println("=================================================>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("=================================================>>>>>>>>>>>>>>>>>>>>>");

    }
}
