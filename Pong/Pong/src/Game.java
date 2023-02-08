import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private Paddle player1;
	private Paddle player2;
	private Ball ball;
	//private int movevalue;
	private ImageIcon pongbackground;
	private ImageIcon screensaver;
	private ImageIcon vaporwave;
	
	
	
	public Game() {
		
		back=null;
		
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		player1= new Paddle(20,440,50,100);
		player2= new Paddle(1530,440,50,100);
		ball = new Ball();
		pongbackground = new ImageIcon(ball.getpongbackground());
		screensaver = new ImageIcon(ball.getscreensaver());
		vaporwave = new ImageIcon(ball.getvaporwave());
		//new Thread(this).start();
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(1);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		
		// Game Background
		g2d.drawImage(pongbackground.getImage(), 0, 0, 1620, 1080, this);
		//g2d.drawImage(vaporwave.getImage(),0,0, 1620, 1080, this);
		
		// The Ball
		g2d.drawImage(screensaver.getImage(), ball.getX(), ball.getY(), ball.getW(), ball.getH(), this);
		
		// The Paddles
		g2d.setColor(Color.WHITE);
		g2d.fillRect(player1.getX(),player1.getY(),player1.getWidth(),player1.getHeight());
		g2d.fillRect(player2.getX(),player2.getY(),player2.getWidth(),player2.getHeight());
		
		// The Text/Score
		g2d.setFont(new Font("Nasalization", Font.BOLD, 30));
		g2d.setColor(Color.PINK);
		g2d.drawString("Press Space to Start!",600,50);
		g2d.drawString("Player 1 Score: " + player1.getScore(), 100, 50);
		g2d.drawString("Player 2 Score: " + player2.getScore(), 1200, 50);
	
		move();
		
		// Win/Loss Screens
		Color colour = new Color(245,72,66);
		g2d.setColor(colour);
		g2d.setFont(new Font("Futura-CondExtraBoldObl", Font.BOLD,150));
		
		Player pl = new Player();
		
		if(player1.getScore()>=7) {
			
			pl.win("win.wav");
			g2d.drawImage(vaporwave.getImage(),0,0, 1620,1080, this);
			g2d.drawString("Player 1 Wins!", 300, 550);
			//System.out.println("Player 1 wins");
		}
		
		if(player2.getScore()>=7) {
			
			pl.loss("loss.wav");
			g2d.drawImage(vaporwave.getImage(),0,0, 1620, 1080, this);
			g2d.drawString("Player 2 Wins!", 300, 550);
			//System.out.println("Player 2 wins");
		}
		
		

		twoDgraph.drawImage(back, null, 0, 0);
		
		
	}
	
	
	
	
	
	
	public void move() {
		player1.move();
		player2.move();
		ball.move();
		wallCollision();
		//ball.collisionp1(player1);
	}
	
	
	public void wallCollision() {
		
		if(ball.getX()+ball.getW() > player2.getX() && !ball.collisionp2(player2)) {
			
			//System.out.println("bounce");
			player1.addPoint(1);
			ball.reset();
		}
		
		if(ball.getX()-ball.getW() < player1.getX() - player1.getWidth() && !ball.collisionp1(player1)) {
			
			//System.out.println("bounce");
			player2.addPoint(1);
			ball.reset();
		}
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(key==87) {
			player1.setDy(-3);
		}
		
		if(key==83) {
			player1.setDy(3);
		}
		
		if(key==38) {
			player2.setDy(-3);
		}
		
		if(key==40) {
			player2.setDy(3);
		}
		
		if(key==32) {
			ball.setdx(2);
			ball.setdy(3);
		}
		
		if(key==61) {
			player1.addPoint(1);
		}
		
		if(key==45) {
			player1.addPoint(-1);
		}
		
		if(key==80) {
			player2.addPoint(1);
		}
		
		if(key==79) {
			player2.addPoint(-1);
		}
		
		if(key==123) {
			ball.setdx(4);
			ball.setdy(3);
		}
		
		if(key==122) {
			ball.setdx(1);
			ball.setdy(3);
		}
		
		
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
	
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			player1.setDy(0);
		}
		
		if(e.getKeyCode()==38||e.getKeyCode()==40) {
			player2.setDy(0);
		}
		
		
	}
	
	
	

	
}