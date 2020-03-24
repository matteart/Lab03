package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class FXMLController {
	ObservableList<String> list = FXCollections.observableArrayList("English", "Italiano");
    private Model model;
    String resultTXT="";
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choicheBox;

    @FXML
    private TextArea txtInsert;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtResult;

    @FXML
    private Text txtError;

    @FXML
    private Button btnClear;

    @FXML
    private Text txtTime;

    @FXML
    void handleClear(ActionEvent event) {
    	Long start = System.nanoTime();
    	
      resultTXT="";
      txtResult.setText(resultTXT);
      
      txtError.setText("Ci sono "+0+" errori");
     
      Long end = System.nanoTime();     
      txtTime.setText("Tempo impiegato :" + this.checkTime(start, end)+ "ms");
    }

    @FXML
    void handleSpell(ActionEvent event) {
    	Long start = System.nanoTime();
    	List <String> inputTextList = new LinkedList<String>();   	
    	
    	
        String lingua = choicheBox.getValue();
        model.loadDictionary(lingua);
        
        String input = txtInsert.getText();
        String [] inputAr= input.split(" ");
        
        for(String s:inputAr) 
        	if(s!=null)
              inputTextList.add(s);
        
        List <RichWord> tempRW= new LinkedList<RichWord>(this.model.spellCheckText(inputTextList));
        
        for(RichWord r:tempRW)
        	if(r!=null)
        		resultTXT+=r.getWord()+"\n";
        
        txtError.setText("Ci sono "+tempRW.size()+" errori");
        
        txtResult.setText(resultTXT);
        Long end = System.nanoTime();
        txtTime.setText("Tempo impiegato :" + this.checkTime(start, end)+ "ms");
    }
    
    public int checkTime(Long start, Long end) {
    	return (int) (end-start);
    }
    @FXML
    void initialize() {
        assert choicheBox != null : "fx:id=\"choicheBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        choicheBox.setItems(list);
    }
    void setModel(Model model) {
    	this.model=model;
    }
}

