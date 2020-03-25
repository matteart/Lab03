package it.polito.tdp.spellchecker.model;

import java.util.*;

public class RichWord {
  private String word;
  private boolean isCorrect=false;
  private Dictionary d;
  
public RichWord(String word, Dictionary d) {
	super();
	this.word = word;
	this.d=d;
}
public void checkDictionary() {
	for(String s:d.getList()) 
	if(s!=null && s.contentEquals(word)) {
		this.isCorrect=true;
		return;
	}
}
  public boolean getIsCorrect() {
	  return this.isCorrect;
  }
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
  public void checkDictionaryDicotomic() {
	 List<String> tempL=new  ArrayList <String> (d.getList());
	  
	int half; 
	int size = tempL.size()-1;
	int start = 0;
	  
	while(start<size && !isCorrect) {
		half= (start+size)/2;
		if(word.contentEquals(tempL.get(half))) {
			isCorrect=true;
			return;
		}
		if(word.compareTo(tempL.get(half))>0)
			start=half+1;
		else
			size=half;
	}
			  
  }
}
