package com.nxt.data_analysis.statistics;

import com.nxt.data_analysis.interfaces.Statistics;
import com.nxt.data_analysis.models.StatisticsModel;

public class NumberOfDotsStatistics implements Statistics {

    private final String nameOfStat = "Number of dots ";


    @Override
    public StatisticsModel getStatistics(String fileContent) {
        long count = fileContent.replaceAll("[^\\.]", "").length();
        StatisticsModel statistics = new StatisticsModel(nameOfStat, String.valueOf(count));
        return statistics;
    }
}
