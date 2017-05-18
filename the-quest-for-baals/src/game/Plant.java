package game;

public class Plant extends Enemy {
	
	int x;
	int y;
	int health;
	

	public Plant(int startx, int starty){
		super();
		x = startx;
		y = starty;
		health = 2;
	}
	
}
