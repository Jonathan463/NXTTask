package com.nxt.data_analysis.statistics;

import com.nxt.data_analysis.models.StatisticsModel;
import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class NumberOfWordsStatisticsTest extends TestCase {



    public void testGetStatistics() {
        StatisticsModel actualStatistics = (new NumberOfWordsStatistics()).getStatistics("all for one and one for all at all times");
        assertEquals("10", actualStatistics.getValueOfStat());
        assertEquals("number of words ", actualStatistics.getNameOfStat());
    }

    public void testGetStatistics2(){
        StatisticsModel actualStatistics = (new NumberOfWordsStatistics()).getStatistics(" ");
        assertEquals("0", actualStatistics.getValueOfStat());
        assertEquals("number of words ", actualStatistics.getNameOfStat());
    }
}