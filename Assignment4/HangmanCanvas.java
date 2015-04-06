/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import acm.util.ErrorException;
import acm.program.*;

//Name: 
//Section Leader: 

public class HangmanCanvas extends GCanvas {

	/* Constants for the simple version of the picture (in pixels) */
		private static final int SCAFFOLD_HEIGHT = 360;
		private static final int BEAM_LENGTH = 150;
		private static final int ROPE_LENGTH = 18;
		private static final int HEAD_RADIUS = 36;
		private static final int BODY_LENGTH = 144;
		private static final int ARM_OFFSET_FROM_HEAD = 28;
		private static final int UPPER_ARM_LENGTH = 72;
		private static final int LOWER_ARM_LENGTH = 44;
		private static final int HIP_WIDTH = 36;
		private static final int LEG_LENGTH = 108;
		private static final int FOOT_LENGTH = 28;
		private int xw=50;
		private int yw=50;
	
	/** HangmanCanvas constructor. You can do initialization (if needed) here. */
	public HangmanCanvas() {
		/*drawscaffold();
		drawhead();
		drawneck();
		drawlefthand();
		drawrighthand();
		drawstomach();
		drawhip();
		drawleftleg();
		drawrightleg();*/
	}
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		remove(gl);
		gl=new GLabel(word,50,400);
		add(gl);
	}
	
	
	public void displaych(String ch){
		g2=new GLabel(ch,50+space,450);
		space+=9;
		add(g2);
		
		
	}
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void changethehangman(int index) {
		/* You fill this in */
		switch(index){
		case 0: drawscaffold();
				break;
		case 1: drawhead();break;
		case 2:	drawneck();	break;
		case 3: drawlefthand();break;
		case 4:	drawrighthand();break;
		case 5:	drawstomach();break;
		case 6:	drawhip();	break;
		case 7:	drawleftleg();break;
		case 8:	drawrightleg();break;
		default: break;
		}
		
	}
	private void drawhead(){
		GOval head=new GOval((xw+150)-(HEAD_RADIUS/2),(yw+100),HEAD_RADIUS,HEAD_RADIUS);
		add(head);
	}
	private void drawneck(){
		GLine neck=new GLine(xw+150,yw+100+(HEAD_RADIUS),xw+150,yw+100+(HEAD_RADIUS)+ROPE_LENGTH);
		add(neck);
	}
	private void drawlefthand(){
		GLine lefthand=new GLine(xw+150,yw+100+(HEAD_RADIUS)+ROPE_LENGTH,xw+150-ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH);
		add(lefthand);
		GLine lthand=new GLine(xw+150-ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH,xw+150-ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH+50);
		add(lthand);
	}
	private void drawrighthand(){
		GLine righthand=new GLine(xw+150,yw+100+(HEAD_RADIUS)+ROPE_LENGTH,xw+150+ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH);
		add(righthand);
		GLine rthand=new GLine(xw+150+ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH,xw+150+ARM_OFFSET_FROM_HEAD,yw+100+(HEAD_RADIUS)+ROPE_LENGTH+50);
		add(rthand);
	}
	private void drawstomach(){
		GLine stomach=new GLine(xw+150,yw+100+(HEAD_RADIUS)+ROPE_LENGTH,xw+150,yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100); 
		add(stomach);
	}
	private void drawhip(){
		GLine hip=new GLine(((xw+150)-(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100,((xw+150)+(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100);
		add(hip);
	}
	private void drawleftleg(){
		GLine leftleg=new GLine(((xw+150)-(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100,((xw+150)-(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH);
		add(leftleg);
		GLine lleg=new GLine(((xw+150)-(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH,((xw+150)-(HIP_WIDTH/2))-FOOT_LENGTH,yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH);
		add(lleg);
	}
	private void drawrightleg(){
		GLine rightleg=new GLine(((xw+150)+(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100,((xw+150)+(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH);
		add(rightleg);
		GLine rteg=new GLine(((xw+150)+(HIP_WIDTH/2)),yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH,((xw+150)+(HIP_WIDTH/2))+FOOT_LENGTH,yw+100+(HEAD_RADIUS)+ROPE_LENGTH+100+LEG_LENGTH);
		add(rteg);
	}
	
	
	private void drawscaffold(){
		GLine ln=new GLine(xw,yw,50,500);
		add(ln);
		GLine ln1=new GLine(xw,yw,(xw+150),yw);
		add(ln1);
		GLine ln2=new GLine(xw+150,yw,xw+150,yw+100);
		add(ln2);
	}
	
	private GLabel gl=new GLabel("",50,400);
	private int space=20;
	private GLabel g2=new GLabel("",50,600);
}
