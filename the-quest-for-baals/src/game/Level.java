package game;

public class Level {

	public Level(int i)
	{
		Ground.clear();
		if (i == 1)
			constructOne();
	}
	
	public void constructOne()
	{
		Ground.add(new Block(0, 0, 600));
		Ground.add(new Block(0, 100, 600));
		Ground.add(new Block(0, 200, 600));
		Ground.add(new Block(0, 300, 600));
		Ground.add(new Block(0, 400, 600));
		Ground.add(new Block(0, 500, 600));
		
	}
	
}
