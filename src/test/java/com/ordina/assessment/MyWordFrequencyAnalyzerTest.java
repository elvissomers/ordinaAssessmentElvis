package com.ordina.assessment;

import com.ordina.assessment.analysis.MyWordFrequencyAnalyzer;
import com.ordina.assessment.dto.TextDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MyWordFrequencyAnalyzerTest {

	@Test
	public void ordinaExampleCalculateHighestFrequency(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);

		assertEquals(2, myWordFrequencyAnalyzer.calculateHighestFrequency(testDto));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForSun(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "sun"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForThe(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "the"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForTheAllCap(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "THE"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForSunSpongeCase(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "sUn"));
	}

	@Test
	public void ordinaExampleCalculateMostFrequentOneWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		int wordAmount = 1;
		TextDto testDto = new TextDto(testString);

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, 1)[0].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, 1)[0].getFrequency());
	}

	@Test
	public void ordinaExampleCalculateMostFrequentThreeWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		int wordAmount = 3;
		TextDto testDto = new TextDto(testString);

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[0].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[0].getFrequency());

		assertEquals("lake",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[1].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[1].getFrequency());

		assertEquals("over",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[2].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[2].getFrequency());
	}

	@Test
	public void myExampleCalculateHighestFrequency(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);

		assertEquals(3, myWordFrequencyAnalyzer.calculateHighestFrequency(testDto));
	}

	@Test
	public void myExampleCalculateFrequencyForSun(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "sun"));
	}

	@Test
	public void myExampleCalculateFrequencyForThe(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);

		assertEquals(3, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "the"));
	}

	@Test
	public void myExampleCalculateFrequencyForLa(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord(testDto, "LA"));
	}

	@Test
	public void myExampleCalculateMostFrequentOneWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		int wordAmount = 1;
		TextDto testDto = new TextDto(testString);

		assertEquals("q",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, 1)[0].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, 1)[0].getFrequency());
	}

	@Test
	public void myExampleCalculateMostFrequentFourWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "       \n \n   The sun shines lala la over the the     q q q     ===!! la==ke";
		int wordAmount = 4;
		TextDto testDto = new TextDto(testString);

		assertEquals("q",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[0].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[0].getFrequency());

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[1].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[1].getFrequency());

		assertEquals("la",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[2].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[2].getFrequency());

		assertEquals("ke",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[3].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testDto, wordAmount)[3].getFrequency());
	}
}
