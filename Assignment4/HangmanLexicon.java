/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import java.util.*;

import acm.program.Program;
import acm.util.*;

//Name: 
//Section Leader: 

public class HangmanLexicon extends Program{

	/** Declare Instance Variables you need here */
	
	
	/** HangmanLexicon constructor. Do any initialization of your lexicon here. 
	 * @return */
	public void run() {
		try{
		BufferedReader rd=new BufferedReader(new FileReader("ShorterLexicon.txt"));
	while(true){
		String line=rd.readLine();
		if(line==null){
			break;
		}
		createStringList(line);
	}
	
	rd.close();
		}catch(IOException ex){
			println("badfile");}
		}
	
		
	public void createStringList(String str){
		strlist.add(str);
	}
	

	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return(strlist.size());
	}
	
	public String getWord(int index){
		return(strlist.get(index));
	}

/** Returns the word at the specified index. */
	/*public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	}*/
private ArrayList<String> strlist=new ArrayList<String>();


}


