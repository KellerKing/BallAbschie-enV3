import java.awt.Graphics2D;

/**
 * @author Luca Luca Keller
 *
 */

public class Game
{
	private final static int W = 1280;
	private final static int H = 720;

	public static Steuerung manager = new Steuerung();
	private static GameField gamefield;
	

	
	public void update(Graphics2D g2d)
	{
		
	}

	public static void start()

	{
		new Thread()
		{
			public void run()
			{
				while(true)
				{
					manager.calcFps();
					//TODO manager.logic(manager.getFPS());
					manager.update(manager.getGegner());
					gamefield.repaint();
					try
					{
						Thread.sleep(25); //TODO FPS begrenzung
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	
	public static void main(String[] argv)
	{
		manager.init();
		gamefield = new GameField(W, H);
		//gamefield.repaint();
		//start();
	}

}
