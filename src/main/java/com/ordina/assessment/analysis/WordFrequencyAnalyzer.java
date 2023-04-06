package com.ordina.assessment.analysis;

import com.ordina.assessment.domains.WordFrequency;
import com.ordina.assessment.dto.TextDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface WordFrequencyAnalyzer {

    @GetMapping("api/highestfrequency")
    int calculateHighestFrequency(@RequestBody TextDto textDto);

    @GetMapping("api/frequency/{word}")
    int calculateFrequencyForWord(@RequestBody TextDto textDto, @PathVariable String word);

    @GetMapping("api/nmostfrequent/{n}")
    WordFrequency[] calculateMostFrequentNWords (@RequestBody TextDto textDto, @PathVariable int n);
}
