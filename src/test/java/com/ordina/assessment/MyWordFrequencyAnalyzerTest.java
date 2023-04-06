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
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(2, myWordFrequencyAnalyzer.calculateHighestFrequency());
	}

	@Test
	public void ordinaExampleCalculateFrequencyForSun(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord("sun"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForThe(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord("the"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForTheAllCap(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord("THE"));
	}

	@Test
	public void ordinaExampleCalculateFrequencyForSunSpongeCase(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord("sUn"));
	}

	@Test
	public void ordinaExampleCalculateMostFrequentOneWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		int wordAmount = 1;
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(1)[0].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(1)[0].getFrequency());
	}

	@Test
	public void ordinaExampleCalculateMostFrequentThreeWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines over the lake";
		int wordAmount = 3;
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[0].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[0].getFrequency());

		assertEquals("lake",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[1].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[1].getFrequency());

		assertEquals("over",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[2].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[2].getFrequency());
	}

	@Test
	public void myExampleCalculateHighestFrequency(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(3, myWordFrequencyAnalyzer.calculateHighestFrequency());
	}

	@Test
	public void myExampleCalculateFrequencyForSun(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord("sun"));
	}

	@Test
	public void myExampleCalculateFrequencyForThe(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(3, myWordFrequencyAnalyzer.calculateFrequencyForWord("the"));
	}

	@Test
	public void myExampleCalculateFrequencyForLa(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord("LA"));
	}

	@Test
	public void myExampleCalculateMostFrequentOneWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		int wordAmount = 1;
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals("q",myWordFrequencyAnalyzer.calculateMostFrequentNWords(1)[0].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(1)[0].getFrequency());
	}

	@Test
	public void myExampleCalculateMostFrequentFourWords(){
		MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
		String testString = "The sun shines lala la over the the     q q q     ===!! la==ke";
		int wordAmount = 4;
		TextDto testDto = new TextDto(testString);
		myWordFrequencyAnalyzer.setData(testDto);

		assertEquals("q",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[0].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[0].getFrequency());

		assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[1].getWord());
		assertEquals(3,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[1].getFrequency());

		assertEquals("la",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[2].getWord());
		assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[2].getFrequency());

		assertEquals("ke",myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[3].getWord());
		assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(wordAmount)[3].getFrequency());
	}
}
