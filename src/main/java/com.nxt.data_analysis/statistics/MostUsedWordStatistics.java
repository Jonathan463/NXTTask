package com.nxt.data_analysis.statistics;

import com.nxt.data_analysis.interfaces.Statistics;
import com.nxt.data_analysis.models.StatisticsModel;

import java.util.HashMap;
import java.util.Map;

public class MostUsedWordStatistics  implements Statistics {

    private final String nameOfStat = "Most used word ";

    @Override
    public StatisticsModel getStatistics(String fileContent) {
        String [] words = fileContent.split(" ");
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String word: words){
            if (mapOfWords.keySet().contains(word)){
                mapOfWords.put(word, mapOfWords.get(word)+1);
            }else{
                mapOfWords.put(word, 1);
            }
        }
        String wordWithMaxOccurence = "";
        int maximuOccurenceVal = 0;
        for (Map.Entry<String, Integer> wordEntry: mapOfWords.entrySet()){
            String word = wordEntry.getKey();
            Integer count = wordEntry.getValue();
            if (count>maximuOccurenceVal){
                maximuOccurenceVal = count;
                wordWithMaxOccurence = word;
            }
            else if (count == maximuOccurenceVal){
                if(word.length() < wordWithMaxOccurence.length()){
                    wordWithMaxOccurence = word;
                }
            }

        }
        StatisticsModel statisticsModel = new StatisticsModel(nameOfStat, wordWithMaxOccurence );

        return statisticsModel;
    }
}
