

import stanford.karel.SuperKarel;

/*
 * Name: 
 * Section Leader: 
 */

public class mountainclimb extends SuperKarel {

	public void run() {
while(frontIsClear()){move();}
climbthemountain();
putBeeper();
getdownfrommountain();



	}
	private void climbthemountain(){
	while(frontIsBlocked()){
		turnLeft();
		move();
		turnright();
		move();
	}
	}
	private void turnright(){
	turnLeft();
	turnLeft();
	turnLeft();
	}
	
    private void getdownfrommountain(){
      while(frontIsClear()){
    	  move();
    	  turnright();
    	  if(frontIsClear()){
    	  move();
    	  turnLeft();}}




}
}
