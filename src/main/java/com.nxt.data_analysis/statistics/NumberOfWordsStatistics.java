package com.nxt.data_analysis.statistics;

import com.nxt.data_analysis.interfaces.Statistics;
import com.nxt.data_analysis.models.StatisticsModel;

import java.util.Arrays;

public class NumberOfWordsStatistics implements Statistics {

    private final String nameOfStat = "Number of words ";

    @Override
    public StatisticsModel getStatistics(String fileContent) {
        //I am inferring that special characters on their own constitute a word.
        String [] words = fileContent.split(" ");
        long count = Arrays.stream(words).filter(word-> word.matches(" ") == false).count();
        StatisticsModel statistics = new StatisticsModel( nameOfStat, String.valueOf(count));
        return statistics;
    }
}
