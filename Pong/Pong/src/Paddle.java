
public class Paddle {
	
	private int height;
	private int width;
	private int x;
	private int y;
	private int dy;
	private int score;
	
	
	
	public Paddle(int posx, int posy, int w, int h) {
		
		x=posx;
		y=posy;
		width=w;
		height=h;
		dy=0;
		score=0;
	}
	
	public void move() {
		
		y+=dy;
	}
	
	public void setDy(int movevalue) {
		
		dy=movevalue;
	}
	
	int getScore() {
		
		return score;
	}
	
	public void addPoint(int s) {
		
		score+=s;
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
}
