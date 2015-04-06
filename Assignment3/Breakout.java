/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private int NTURNS = 3;
	
	private static final int x_width=2;

	private static final int y_width=2;
	
	/* Define your instance variables here */
	
	/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		createbricks();
		createpaddle();
		createball();
		addMouseListeners();
		moveballinit();
		//while(!gameover()){
	//	while(true){
		while(true){
			moveball();
			pause(25);
		}
		//	pause(20);}
			//checkforcollision();
			//pause(25);
		//}
	}
	
	
	
	public void mouseMoved(MouseEvent e){
		remove(paddle);
		if(e.getX()<(getWidth()-PADDLE_WIDTH)){
		add(paddle,e.getX(),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT));
	}
		else{
			add(paddle,(getWidth()-PADDLE_WIDTH),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT));
		}
	}
	//working correctly
	private void createbricks(){
		int i=1;
		int x=0;
		int j=0;
		int y=BRICK_Y_OFFSET;
		while(j<10){
		while(i<=10){
		GRect brick=new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
		brick.setFilled(true);
		
		if(j==0||j==1)
			brick.setColor(Color.RED);
		if(j==2|j==3)
			brick.setColor(Color.ORANGE);
		if(j==4|j==5)
			brick.setColor(Color.YELLOW);		
		if(j==7|j==6)
				brick.setColor(Color.GREEN);		
		if(j==8|j==9)
					brick.setColor(Color.CYAN);
			add(brick);
		
		i++;
		x=x+BRICK_SEP+BRICK_WIDTH;
			}
		i=1;
		x=0;
		y=y+BRICK_SEP+BRICK_HEIGHT;
		j++;
		}
	}
	//working correctly
	private void createpaddle(){
		paddle.setFilled(true);
		add(paddle);
	}
	//working correctly
	private void createball(){
		ball.setFilled(true);
		ball.setColor(Color.RED);
		add(ball,((getWidth()-BALL_RADIUS)/2),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT-BALL_RADIUS));
	}
	//working correctly
	private boolean gameover(){
		if((NTURNS==0)|(bricks==null)){
			return false;
		}
		return true;
	}
	//testing phase
	/*private void moveball(){
		int x=2;int y=2;
			println(getWidth());
			println(getHeight());
		while((ball.getX()>=0)&&(ball.getX()<=(WIDTH-BALL_RADIUS))){
			ball.move(x,-y);
			add(ball);
			pause(5);
		}
		if(ball.getX()>(WIDTH-BALL_RADIUS))
			while(ball.getY()>=0){
			//while(ball!=null){
			ball.move(-x,-y);
			add(ball);
			pause(5);
			//}
		}
		if(ball.getY()<=0){
		while(ball.getX()>=0){
			ball.move(-x,y);
			add(ball);
			pause(5);
		}
		if(ball.getX()<=0){
			while((ball.getY()<=HEIGHT)&&(ball.getX()<=(WIDTH-BALL_RADIUS))){
				ball.move(x,y);
				add(ball);
				pause(5);
			}
		}
		if(ball.getX()>=0){
			while((ball.getY()<=(HEIGHT-BALL_RADIUS))&&(ball.getX()>=0)){
				ball.move(-x,y);
				add(ball);
				pause(5);	
			}
			
			
		}
	}
	}	*/
	private void moveballinit(){
		ball.move(x_width,-y_width);
		add(ball);
		pause(10);
		x_old=ball.getX();
		y_old=ball.getY();

	}
	//works correctly
	private void moveball(){
		x_new=ball.getX();
		y_new=ball.getY();
		if(((x_new-x_old)>=0)&&((y_new-y_old)<=0)){
			x_old=ball.getX();
			y_old=ball.getY();
			ball.move(x_width,-y_width);
			add(ball);
			if((ball.getX()>=WIDTH)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(-2*x_width,-y_width);
				add(ball);
			}
			if((ball.getY()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(2*x_width,y_width);
				add(ball);
			}
		}
		else if(((x_new-x_old)>=0)&&((y_new-y_old)>=0)){
		 x_old=ball.getX();
		 y_old=ball.getY();
		 ball.move(x_width,y_width);
		 add(ball);
			if((ball.getX()>=WIDTH)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(-2*x_width,y_width);
				add(ball);
			}
			if((ball.getY()>=HEIGHT)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(2*x_width,-y_width);
				add(ball);
			}
		 
		}
		else if(((x_new-x_old)<=0)&&((y_new-y_old)<=0)){
			 x_old=ball.getX();
			 y_old=ball.getY();
			ball.move(-x_width,-y_width);
			add(ball);
			if((ball.getX()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(2*x_width,-y_width);
				add(ball);
			}
			if((ball.getY()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(-2*x_width,y_width);
				add(ball);
			}
		}
		else if(((x_new-x_old)<=0)&&((y_new-y_old)>=0)){
			 x_old=ball.getX();
			 y_old=ball.getY();
			ball.move(-x_width,y_width);
			add(ball);
			if((ball.getX()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(2*x_width,y_width);
				add(ball);
			}
			if((ball.getY()>=HEIGHT)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				pause(10);
				ball.move(-2*x_width,-y_width);
				add(ball);
			}
		}
	}
	//check condition for check collision method only
	private double x_old=0;
	private double x_new=0;
	private double y_old=0;
	private double y_new=0;
	private GOval ball=new GOval(BALL_RADIUS,BALL_RADIUS);
	private GRect paddle=new GRect(((getWidth()-PADDLE_WIDTH)/2),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT),PADDLE_WIDTH,PADDLE_HEIGHT);;
	private GRect bricks;
}

