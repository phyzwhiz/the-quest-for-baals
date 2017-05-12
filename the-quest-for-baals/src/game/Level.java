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
		Ground.add(new Block(0, true, 0, 600));
		Ground.add(new Block(0, true, 100, 600));
		Ground.add(new Block(0, true, 200, 600));
		Ground.add(new Block(0, true, 300, 600));
		Ground.add(new Block(0, true, 400, 600));
		Ground.add(new Block(0, true, 500, 600));
		
	}
	
}
