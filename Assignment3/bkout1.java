/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */
/*
	|\    |   __      ___  |   |  ____          _______    
	| \   |  /  \    /     |   | |        /\       |                   
	|  \  | |    |  |      |---| |____   /__\      |               
	|   \ | \    /  |      |   | |      /    \     |              
	|    \|  \__/    \___  |   | |____ / 	  \    |            
 */


import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class bkout1 extends GraphicsProgram {

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
	private static final int BALL_RADIUS = 7;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private int NTURNS = 3;
	
	private static int bricksnum=100;
	
	
	
	 
	
	/* Define your instance variables here */
	
	/** Runs the Breakout program. */	
public void run() {
		/* You fill this in, along with any subsidiary methods */
		
		createpaddle();
		createball();
		createbricks();
		x_width=rgen.nextInt(1,4);
		y_width=x_width;
		addMouseListeners();
		moveballinit();
		while(!gameover()){
			x_width=rgen.nextInt(1,4);
			y_width=x_width;
			moveball();
			checkpaddlecollision();
			checkbrickcollisions();
			pause(40);
			}

		}
	//changes expected
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
		brick=new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
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
		if((NTURNS!=0)&&(bricksnum!=0))
		{
			return false;
		}
		GLabel gover=new GLabel("GAMEOVER",WIDTH/4,HEIGHT/2);
		gover.setFont("ARIALBLACK-20");
		add(gover);
		return true;
	}
	//testing phase
	private void moveballinit(){
		ball.move(x_width,y_width);
		add(ball);
		pause(10);
		x_old=ball.getX();
		y_old=ball.getY();

	}
	//works correctly
	private void moveball(){
		x_new=ball.getX();
		y_new=ball.getY();
		/*		0
			   />
			  /	
			 /	
			0					*/
		if(((x_new-x_old)>=0)&&((y_new-y_old)<=0)){
			x_old=ball.getX();
			y_old=ball.getY();
			ball.move(x_width,-y_width);
			add(ball);
			if((ball.getX()>=WIDTH)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(-2*x_width,-y_width);
				add(ball);
			}
			if((ball.getY()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(2*x_width,y_width);
				add(ball);
			}
		}
		/*	0	
			 \	
			  \	
			   \
				\>	
		 		 0						*/
		else if(((x_new-x_old)>=0)&&((y_new-y_old)>=0)){
		 x_old=ball.getX();
		 y_old=ball.getY();
		 ball.move(x_width,y_width);
		 add(ball);
			if((ball.getX()>=WIDTH)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(-2*x_width,y_width);
				add(ball);
			}
			if((ball.getY()>=HEIGHT)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(2*x_width,-y_width);
				add(ball);
			}
		 
		}
		/*	 0
		  	 <\
		       \
		     	\
		 	  	 \
		 	   	  0			*/
		else if(((x_new-x_old)<=0)&&((y_new-y_old)<=0)){
			 x_old=ball.getX();
			 y_old=ball.getY();
			ball.move(-x_width,-y_width);
			add(ball);
			if((ball.getX()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(2*x_width,-y_width);
				add(ball);
			}
			if((ball.getY()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(-2*x_width,y_width);
				add(ball);
			}
		}
		/*	0
		 	 \
		 	  \
		 	   \
		 		\>
		 		 0*/	
		else if(((x_new-x_old)<=0)&&((y_new-y_old)>=0)){
			 x_old=ball.getX();
			 y_old=ball.getY();
			ball.move(-x_width,y_width);
			add(ball);
			if((ball.getX()<=0)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(2*x_width,y_width);
				add(ball);
			}
			if((ball.getY()>=HEIGHT)){
				 x_old=ball.getX();
				 y_old=ball.getY();
				//pause(10);
				ball.move(-2*x_width,-y_width);
				add(ball);
			}
		}
		if(ball.getY()>(getHeight()-PADDLE_Y_OFFSET+10)){
			NTURNS--;
			if(NTURNS!=0){
				pause(1000);
				GLabel g1=new GLabel(("Lives remaining is "+NTURNS),WIDTH/4,HEIGHT/2);
				g1.setFont("arial black-20");
				add(g1);
				pause(1000);
				remove(g1);
				add(ball,((getWidth()-BALL_RADIUS)/2),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT-BALL_RADIUS));
			moveballinit();}
		}
	}
	//check condition for check collision method only
	private void checkbrickcollisions(){
		x_new=ball.getX();
		y_new=ball.getY();
		getcollidingobject();
		if(b==true){
		if(((x_new-x_old)>=0)&&((y_new-y_old)<=0)){
			ball.move(x_width,y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
			b=false;
		}
		else if(((x_new-x_old)>=0)&&((y_new-y_old)>=0)){
			ball.move(x_width,-y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
			b=false;
		}
		else if(((x_new-x_old)<=0)&&((y_new-y_old)<=0)){
			ball.move(-x_width,-y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
			b=false;
		}
		else if(((x_new-x_old)<=0)&&((y_new-y_old)>=0)){
			ball.move(-x_width,y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
			b=false;
		}}
		}
	//testing stage
	private void getcollidingobject(){
	GObject obj=null;
		if((getElementAt(x_new,y_new)!=null)&&(getElementAt(x_new,y_new)!=paddle)){
			obj=getElementAt(x_new,y_new);
			remove(obj);
			bounceClip.play();
			b=true;
			bricksnum--;
		}
		else if(((getElementAt((x_new+(2*BALL_RADIUS)),y_new))!=null)&&((getElementAt((x_new+(2*BALL_RADIUS)),y_new))!=paddle)){
			obj=(getElementAt((x_new+(2*BALL_RADIUS)),y_new));
			remove(obj);
			bounceClip.play();
			b=true;
			bricksnum--;
			}
		else if(((getElementAt((x_new+(2*BALL_RADIUS)),y_new+(2*BALL_RADIUS)))!=null)&&((getElementAt((x_new+(2*BALL_RADIUS)),y_new+(2*BALL_RADIUS)))!=paddle)){
			obj=(getElementAt((x_new+(2*BALL_RADIUS)),y_new+(2*BALL_RADIUS)));
			remove(obj);
			bounceClip.play();
			b=true;
			bricksnum--;
			}
		else if(((getElementAt((x_new),y_new+(2*BALL_RADIUS)))!=null)&&((getElementAt((x_new),y_new+(2*BALL_RADIUS)))!=paddle)){
			obj=(getElementAt((x_new),y_new+(2*BALL_RADIUS)));
			remove(obj);
			bounceClip.play();
			b=true;
			bricksnum--;
		}
	}
	//contains mistakes which is to be rectified
	private void paddlerebound(){
		double x_new=ball.getX();
		double y_new=ball.getY();
		if(x_new-x_old>=0){
			ball.move(x_width,-y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
		}
		else if(x_new-x_old<=0){
			ball.move(-x_width,-y_width);
			add(ball);
			x_old=x_new;
			y_old=y_new;
		}
	}
	//works perfect
	private void checkpaddlecollision(){
		GObject g1=getElementAt(ball.getX(),ball.getY());
		if(g1==paddle){
			bounceClip.play();
			paddlerebound();
		}
	}
	//works perfect
	private int x_width;
	private int y_width;
	private RandomGenerator rgen=new RandomGenerator();
	private boolean b=false;
	private double x_old=0;
	private double x_new=0;
	private double y_old=0;
	private double y_new=0;
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private GOval ball=new GOval(BALL_RADIUS,BALL_RADIUS);
	private GRect paddle=new GRect(((getWidth()-PADDLE_WIDTH)/2),(getHeight()-PADDLE_Y_OFFSET-PADDLE_HEIGHT),PADDLE_WIDTH,PADDLE_HEIGHT);;
	private GRect brick=new GRect(BRICK_WIDTH,BRICK_HEIGHT);
}
