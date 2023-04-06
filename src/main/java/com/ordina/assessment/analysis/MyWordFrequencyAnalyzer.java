package com.ordina.assessment.analysis;

import com.ordina.assessment.domains.MyWordFrequency;
import com.ordina.assessment.domains.WordFrequency;
import com.ordina.assessment.dto.TextDto;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyWordFrequencyAnalyzer implements WordFrequencyAnalyzer{

    @Override
    @GetMapping("api/highestfrequency")
    public int calculateHighestFrequency(@RequestBody TextDto textDto){
        String text = textDto.getText();
        HashMap<String, Integer> wordMap = getWordMap(text);
        WordFrequency[] sortedWords = getSortedWords(wordMap);

        return sortedWords[0].getFrequency();
    }

    @Override
    @GetMapping("api/frequency/{word}")
    public int calculateFrequencyForWord(@RequestBody TextDto textDto, @PathVariable String word){
        String text = textDto.getText();
        HashMap<String, Integer> wordMap = getWordMap(text);
        String inputWord = word.toLowerCase();

        return wordMap.get(inputWord);
    }

    @Override
    @GetMapping("api/nmostfrequent/{n}")
    public WordFrequency[] calculateMostFrequentNWords(@RequestBody TextDto textDto, @PathVariable int n){
        if (n < 1){
            throw new IllegalArgumentException("N should be at least 1");
        }
        String text = textDto.getText();
        HashMap<String, Integer> wordMap = getWordMap(text);
        WordFrequency[] sortedWords = getSortedWords(wordMap);

        return Arrays.copyOfRange(sortedWords, 0, n);
    }

    public HashMap<String, Integer> getWordMap(String text){
        String lowerCaseText = text.toLowerCase().trim();
        String[] allWords = lowerCaseText.split("[^a-z]+");

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String word : allWords){
            if (wordMap.containsKey(word)) {
                Integer currentCount = wordMap.get(word);
                wordMap.replace(word, currentCount + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }

    public WordFrequency[] getSortedWords(HashMap<String, Integer> unsortedMap){
        WordFrequency[] sortedWords = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> new MyWordFrequency(entry.getKey(), entry.getValue()))
                .toArray(WordFrequency[]::new);

        return sortedWords;
    }

}

