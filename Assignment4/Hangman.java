/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

//Name: 
//Section Leader:

public class Hangman extends ConsoleProgram {
	private int turns=8;
    public void run() {
		/* You fill this in */
    	canvas = new HangmanCanvas(); 
    	setLayout(new GridLayout(1,2)); 
    	add(canvas);
    	validate();
    	z=0;
    	hl.run();
    	canvas.changethehangman(z);
    	println("WELCOME TO HANGMAN");
    	strorig=gettheword();
    	length=strorig.length();
    	constructspaces(length);
    	println("YOU HAV 8 GUESSES LEFT");
    	while(!gameover()){
    	askforch();
    	comparewithoriginal(strorig);
    	}
    	if(turns==0){
    		if(!(blank.equals(strorig))){
    		println("sorry the game is over");
    		println("YOU LOSE");}
    	}
    	if(gameover()){
    		if(blank.equals(strorig)){
    		println("THE WORD IS :"+blank);	
    		canvas.displayWord(blank);
    		println("You WIN");}
    	}
    	}
    	private String gettheword(){
    		int y=hl.getWordCount();
    		int x=rgen.nextInt(0,y-1);
    		String str=hl.getWord(x);
    		//String str=hl.getWord(x);
    		return str;
    	}
    	private void constructspaces(int length){
    		c=new char[length];
        	for(int i=0;i<length;i++){
        		c[i]='-';
        		blank+=c[i];
        	}
           	println("THE WORD LOOKS LIKE :"+blank);
           	canvas.displayWord(blank);
    	}
    	private void askforch(){
    		println("YOUR GUESS:");
    		ch=readLine();
    		ch=ch.toUpperCase();
    		if(ch.length()>1){
    			println("retry");
    			askforch();
    		}
    		ch2=ch.charAt(0);
    		if((ch2>='a')&&(ch2<='z')||(ch2>='A')&&(ch2<='Z')){
    			
    		if(!comparewithprevious(ch2)){
    			println("key already pressed,retry with other alphabet");
    			askforch();
    		}
    		canvas.displaych(ch);}
    		else{
    			println("retry");
    			askforch();
    		}
    	}
    	private void comparewithoriginal(String strorig){
    		length=strorig.length();
    		boolean b=false;
    		int i=0;
    		for(i=0;i<length;i++){
    			ch1=strorig.charAt(i);
    			if(ch1==ch2){
    				b=true;
    				c[i]=ch2;
    			}
    		}
    		blank="";
    		if(b==true){
    		for(i=0;i<length;i++){
    		blank+=c[i];}
    		if(!(blank.equals(strorig))){
    		println("THE WORD LOOKS LIKE :"+blank);
    		canvas.displayWord(blank);
    			}
    		}
    		if(b==false){
    			println("the are no "+ch2+"'s in the word");
    			turns--;
    			z++;
    			canvas.changethehangman(z);
    			println("YOU HAVE "+turns+" GUESSES LEFT");
    		}
    		
    	}
    	private boolean gameover(){
    		if(blank.equals(strorig)){
    			return true;
    		}
    		if((turns!=0))
    		{
    			return false;
    		}
    		return true;
    	}
    	private boolean comparewithprevious(char ch){
    		int plen=previous.length();
    		for(int j=0;j<plen;j++){
    			if(ch==previous.charAt(j)){
    				return false;
    			}
    		}
    		previous+=ch;
    		return true;
    	}
    	
private RandomGenerator rgen=new RandomGenerator().getInstance();
private String strorig="";
private String blank="";
private String ch;
private char ch2;
private char ch1;
private String previous=""; 
private int length;
private char[] c=new char[10];
private HangmanCanvas canvas; 
private int z=0;
private GLabel gl;
HangmanLexicon hl=new HangmanLexicon();
}
