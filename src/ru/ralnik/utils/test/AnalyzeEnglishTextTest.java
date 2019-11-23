package ru.ralnik.utils.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import ru.ralnik.utils.AnalyzeEnglishText;


class AnalyzeEnglishTextTest {
	
	public AnalyzeEnglishText anal;
	
	@Before
	void beforeTest() {
		String text = "My name is Sasha! i'm 20.";
		anal = new AnalyzeEnglishText(text);
	}

	@Test
	void test() {
		String text = "My name is Sasha! i'm 20.";
		anal = new AnalyzeEnglishText(text);
//		for(String stroka : anal.massiveOfWords)
//			System.out.println(stroka);
		assertEquals(text, anal.getText());
	}
	
	@Test
	void isSuffixTest() {
		String word = "runing";
		String suffix = "ing";
		String text = "My name is Sasha! i'm 20.";
		anal = new AnalyzeEnglishText(text);
		assertTrue(anal.isSuffix(word, suffix));
	}
	
	@Test
	void handleSuffixTest() {
		String text = "jump!";
		anal = new AnalyzeEnglishText(text);
		String[] suffix = {"ing"};
		anal.setSuffix(suffix);
		assertEquals(anal.getText(), anal.handleSuffix("jumping"));
	}
	
	@Test
	public void handlePrefixTest() {
		String text = "load!";
		anal = new AnalyzeEnglishText(text);
		String[] prefix = {"pre"};
		anal.setPrefix(prefix);
		assertEquals(anal.getText(), anal.handlePrefix("preload"));	
	}
	
	@Test
	public void runTest() {
		String text = "My name is Sasha! i'm 20. i'm jumping man. I like preload my data.";
		anal = new AnalyzeEnglishText(text);		
		String[] prefix = {"pre"};
		String[] suffix = {"ing"};
		anal.setPrefix(prefix);	
		anal.setSuffix(suffix);
		assertTrue(anal.run());
	}

}
