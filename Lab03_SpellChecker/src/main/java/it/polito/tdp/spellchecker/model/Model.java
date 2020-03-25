package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Model {
private Dictionary dizionario ;


public void loadDictionary(String lingua) {
	this.dizionario= new Dictionary (lingua+".txt");
}

public List<RichWord> spellCheckText(List<String> inputTextList){
	List <RichWord> tempL= new LinkedList<RichWord>();
	RichWord tempR;
	for(String s:inputTextList) 
		if(s!=null) {
			tempR= new RichWord(s, dizionario);
			tempR.checkDictionaryDicotomic();
			if(!tempR.getIsCorrect())
			 tempL.add(tempR);
		}
	return tempL;
}



}
