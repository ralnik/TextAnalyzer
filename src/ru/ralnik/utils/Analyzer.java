package ru.ralnik.utils;

public abstract class Analyzer {
	private String text;
	private String[] prefix;
	private String[] suffix;
	public String[] massiveOfWords;
	
	public Analyzer(String text) {
		this.text = text;
		clearString();
		this.massiveOfWords = this.text.split(" ");
	}		
	
	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}	

	public String[] getPrefix() {
		return prefix;
	}

	public void setPrefix(String[] prefix) {
		this.prefix = prefix;
	}

	public String[] getSuffix() {
		return suffix;
	}

	public void setSuffix(String[] suffix) {
		this.suffix = suffix;
	}

	private void clearString() {
		String[] massiveOfSymbols = {",", ".", "!", "?", "'", "-", "+", "_", "="};
		for(String item : massiveOfSymbols) {
			if(this.text.indexOf(item) > 0) {
				this.text = this.text.replace(item, "");
			}
		}
	}
	
	public abstract String handlePrefix(String text);
	public abstract String handleSuffix(String text);
	public abstract boolean run();

}
