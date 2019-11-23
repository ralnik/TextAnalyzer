package ru.ralnik.utils;

public class AnalyzeEnglishText extends Analyzer {

	public AnalyzeEnglishText(String text) {
		super(text);
	}

	@Override	
	public String handlePrefix(String stroka) {
		for(String prefix : this.getPrefix()) {
			if(stroka.indexOf(prefix) == 0) {
				return stroka.replace(prefix, "");
			}	
		}
		return null;	
	}

	@Override
	public String handleSuffix(String stroka) {
		for(String suffix : this.getSuffix()) {
			if(stroka.indexOf(suffix) > 0 && isSuffix(stroka,suffix)) {
				return stroka.replace(suffix, "");
			}
		}
		return null;
	}
	
	public boolean isSuffix(String word, String suffix) {
		if(word.length() - suffix.length() == word.indexOf(suffix)) {
			return true;
		}else return false;
	}

	@Override
	public boolean run() {
		try {
			int index = 0;
			for(String word : super.massiveOfWords) {			
				super.massiveOfWords[index] = handlePrefix(word);		
				super.massiveOfWords[index] = handleSuffix(word);				
				index++;
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
