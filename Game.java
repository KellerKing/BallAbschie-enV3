import java.awt.Graphics2D;
import java.io.IOException;

/**
 * @author Luca Luca Keller
 *
 */

public class Game
{
	private final static int W = 1280;
	private final static int H = 720;
	private final double FPS = 60.0;
	private boolean running = false;

	private Thread thread;

	public static Steuerung manager = new Steuerung();
	private static GameField gamefield;
	
	

	private synchronized void start()
	{
		if (running)
			return;

		running = true;

	}

	private synchronized void stop()
	{
		if (!running)
			return;

		running = false;
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.exit(1);

	}

	public void run() 
	{
		// TODO auslagern in Steuerungsklasse
		long start = System.nanoTime();
		double ns = 1000000000 / FPS;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running)
		{
			long last = System.nanoTime();
			delta += (last - start) / ns;

			if (delta >= 1)
			{
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(updates + " Ticks, FPS " + frames);
				updates = 0;
				frames = 0;
			}

			manager.update(manager.getGegner());
			
			
			try
			{
				thread.sleep(2);
				gamefield.repaint();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		stop();
	}

	private void tick()
	{

	}

	private void render()
	{

	}

	public static void main(String[] argv) throws IOException
	{
		Game game = new Game();

		manager.init();
		gamefield = new GameField(W, H);
		game.start();
		game.run();
	}

}
