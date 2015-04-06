/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		collectnewspaper();
		getbacktohome();
		// You fill in this part
	}
 private void collectnewspaper() {
	 	move();
		move();
		turnright();
		move();
		turnLeft();
		move();
		pickBeeper();
 }
 private void turnright() {
	 turnLeft();
	 turnLeft();
	 turnLeft();
 }
 private void getbacktohome() {
	 turnaround();
	 move();
	 move();
	 move();
	 turnright();
	 move();
	 turnright();
 }
 private void turnaround() {
	 turnLeft();
	 turnLeft();
 }
 }
