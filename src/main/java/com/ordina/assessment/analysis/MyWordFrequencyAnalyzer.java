package com.ordina.assessment.analysis;

import com.ordina.assessment.domains.MyWordFrequency;
import com.ordina.assessment.domains.WordFrequency;
import com.ordina.assessment.dto.TextDto;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyWordFrequencyAnalyzer{
    
    @GetMapping("api/highestfrequency")
    public int calculateHighestFrequency(){
        return this.sortedWords[0].getFrequency();
    }

    @GetMapping("api/frequency/{word}")
    public int calculateFrequencyForWord (@PathVariable String word){
        String inputWord = word.toLowerCase();

        return this.wordMap.get(inputWord);
    }

    @GetMapping("api/nmostfrequent/{n}")
    public WordFrequency[] calculateMostFrequentNWords (@PathVariable int n){
        return Arrays.copyOfRange(this.sortedWords, 0, n);
    }

    @PostMapping("api/text")
    public void setData(@RequestBody TextDto textDto){
        String text = textDto.getText();
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

        this.wordMap = wordMap;
        getSortedWords(wordMap);
    }

    public void getSortedWords(HashMap<String, Integer> unsortedMap){
        WordFrequency[] sortedWords = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> new MyWordFrequency(entry.getKey(), entry.getValue()))
                .toArray(WordFrequency[]::new);

        this.sortedWords = sortedWords;
    }

}

