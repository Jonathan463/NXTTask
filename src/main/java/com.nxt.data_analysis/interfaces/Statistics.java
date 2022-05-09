package com.nxt.data_analysis.interfaces;

import com.nxt.data_analysis.models.StatisticsModel;

public interface Statistics {
    StatisticsModel getStatistics(String fileContent);
}
