/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		// You fill in this part
		
		if(frontIsBlocked()){
			singlecolumn();
		}
		else{checkdimension();}
		
		}
		private void turnright(){
			turnLeft();
			turnLeft();
			turnLeft();
		}
		private void singlecolumn(){
			turnLeft();
			putBeeper();
			while(frontIsClear()){
				if(frontIsClear()){
					move();}
				if(frontIsClear()){
					move();
					putBeeper();
				}
				}
			}
	private void checkdimension(){
		putBeeper();
		while(frontIsClear()){
			if(frontIsClear()){
				move();}
			if(frontIsClear()){
				move();
				putBeeper();
			}
			}
		if(beepersPresent()){odddimension_1();}
		else{evendimension_1();}
			
		}
	private void odddimension_1(){
	if(leftIsClear()){
		turnLeft();
		move();
		turnLeft();
		while(frontIsClear()){
			if(frontIsClear()){
				move();putBeeper();}
			if(frontIsClear()){
				move();
			}
		
	}
		turnright();
	}
	if(rightIsClear()){
	odddimension_2();}
	}
	private void evendimension_1(){
		if(leftIsClear()){
		turnLeft();
		move();
		turnLeft();
		putBeeper();
		while(frontIsClear()){
			if(frontIsClear()){
				move();}
			if(frontIsClear()){
				move();putBeeper();
			}
		
	}
		turnright();
		}
		if(rightIsClear()){
			evendimension_2();}
		}
		
		private void odddimension_2(){
		if(frontIsClear()){
			move();
			turnright();
			putBeeper();
			while(frontIsClear()){
				if(frontIsClear()){
					move();}
				if(frontIsClear()){
					move();putBeeper();
				}
				
			}
			odddimension_1();
		}
		}
		private void turnaround(){
			turnLeft();
			turnLeft();
		}
		private void evendimension_2(){
			
			if(frontIsClear()){
				move();
				turnright();
				putBeeper();
				while(frontIsClear()){
					if(frontIsClear()){
						move();}
					if(frontIsClear()){
						move();putBeeper();
					}
					
				}
				evendimension_1();
			}
		}
		
}	
		
		
		
		
		

	




