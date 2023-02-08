public class Ball {
	
	private int height;
	private int width;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private boolean moveup;
	private boolean moveright;
	private String pongbackground;
	private String screensaver;
	private String vaporwave;
	private Player pl;
	
	
	public Ball() {
		
		height=100;
		width=100;
		x=720;
		y=450;
		dx=0;
		dy=0;
		moveup=false;
		moveright=false;
		pongbackground="pongbackground.jpg";
		screensaver="screensaver.png";
		vaporwave = "vaporwave.jpg";
		pl = new Player();
		
	}
	
	public String getvaporwave() {
		return vaporwave;
	}
	
	public String getscreensaver() {
		return screensaver;
	}
	
	public String getpongbackground() {
		return pongbackground;
	}
	
	public void reset() {
		
		dy=0;
		dx=0;
		x=720;
		y=450;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return height;
	}
	
	public void setMoveup() {
		moveup=!moveup;
	}
	
	public void setMovert() {
		moveright=!moveright;
	}
	
	
	public void setdx(int newdx) {
		dx=newdx;
	}
	
	public void setdy(int newdy) {
		dy=newdy;
	}
	
	
	public void move() {
		
		if(moveup) {
			y-=dy;
		}
		
		else {
			y+=dy;
		}
		
		if(moveright) {
			x-=dx;
		}
		
		else {
			x+=dx;
		}
		
		if(y<=0  ||y>=940) {
			setMoveup();
		}
		
		
	}
	
	//COLLISION CODE 
	
	public boolean collisionp1 (Paddle p) {
		
		if(getX()<= p.getX() + p.getWidth() && getY() <= p.getY() + p.getHeight()&& getY()+ getH() >= p.getY()) {
		
		pl.bounce("bounce.wav");
		setMovert();
		return true;
	}
		else{
			
			return false;
		}
	}
	
	
	
	public boolean collisionp2 (Paddle p) {
		
		
		if(getX()+getW()>= p.getX() && getY()<=p.getY() + p.getHeight() && getY()+getH()>=p.getY()) {
		
		pl.bounce("bounce.wav");
			setMovert();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
























