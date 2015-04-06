import stanford.karel.SuperKarel;

/*
 * Name: 
 * Section Leader: 
 */

public class springkarel1 extends SuperKarel {

	public void run() {
		while(frontIsClear()){
    findtree();
    ascend();
    fixtree();
    descend();}
		}
	
	
	private void findtree(){
		while(frontIsClear()){
			move();
		}
		}
   private void ascend(){
	   turnLeft();
	   while(rightIsBlocked()){
		   if(frontIsClear()){
		   
		   move();
		   }
		   } 
	   
	   }
 private void turnright(){
		   turnLeft();
		   turnLeft();
		   turnLeft();
	   }
	   private void descend(){
		   while(frontIsClear()){
			   move();
			   
			   }
			   
		   
		   turnLeft();
	   }
		   private void fixtree(){
			   if(frontIsClear()){
			   putBeeper();
			   move();
			   putBeeper();
			   turnright();
			   move();
			   putBeeper();
			   turnright();
			   move();
			   putBeeper();
			   }
		   }
	  private void turnaround(){
		   turnLeft();
		   turnLeft();
	   }	   
}




