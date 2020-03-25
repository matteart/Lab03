package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
private List <String> dictionary = new ArrayList<String> ();

public Dictionary(String titolo) {
	try {
		FileReader fr= new FileReader("src/main/resources/"+titolo);
		BufferedReader br= new BufferedReader(fr);
		String word;
		while((word = br.readLine())!=null) {
			dictionary.add(word);
		} br.close();
	} catch (IOException e) {
		System.out.println("Errore nella lettura del file");
	}
}
public List<String> getList(){
	return dictionary;
}
}
