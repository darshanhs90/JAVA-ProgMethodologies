/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		ascend();descend();
		movetonextpillar();
		ascend();descend();
		movetonextpillar();
		ascend();descend();
		movetonextpillar();
		ascend();descend();
		movetonextpillar();
		
		// You fill in this part
	}
	private void ascend(){
		turnLeft();
		while(frontIsClear()) { 
			if(noBeepersPresent()){
				putBeeper();
				}
			move();
			}
		if(noBeepersPresent()){putBeeper();}
		turnLeft();
		turnLeft();
		}
			private void turnright() {
				turnLeft();
				turnLeft();
				turnLeft();
			}
			private void movetonextpillar() {
				if(frontIsClear()){
				for(int i = 0;i<4;i++){
					move();
				}
				}
			}
			private void descend() {
				while(frontIsClear()) {
					move();
				}
				turnLeft();
	}
}
