package com.nxt.data_analysis.statistics;

import com.nxt.data_analysis.models.StatisticsModel;
import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class NumberOfDotsStatisticsTest extends TestCase {


    public void testGetStatistics() {

        StatisticsModel actualStatistics = (new NumberOfDotsStatistics()).getStatistics("Not all who wander are lost. Some may be. We don't know for sure...");
        assertEquals("5", actualStatistics.getValueOfStat());
        assertEquals("Number of dots ", actualStatistics.getNameOfStat());
    }

    public void testGetStatistics2(){
        StatisticsModel actualStatistics = (new NumberOfDotsStatistics()).getStatistics("U");
        assertEquals("0", actualStatistics.getValueOfStat());
        assertEquals("Number of dots ", actualStatistics.getNameOfStat());
    }
}