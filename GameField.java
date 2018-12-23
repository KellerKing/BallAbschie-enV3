import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;;

public class GameField extends JPanel
{

	private Steuerung managerX = new Steuerung();
	private Game game = new Game();

	private static int width, height;
	

	
	public GameField(int w, int h)
	{
		JFrame fenster = new JFrame();
		fenster.setResizable(false);
		fenster.setLayout(null);
		fenster.setBounds(0, 0, w, h);
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);
		this.setBounds(0, 0, w, h);
		this.setBackground(Color.BLACK);

		fenster.add(this);
		
		fenster.setVisible(true);
		requestFocus();

		width = fenster.getContentPane().getWidth();
		height = fenster.getHeight();
		
		this.addMouseMotionListener(game.manager.getCursor());
		this.addMouseListener(game.manager.getCursor());
		

	}

	public GameField()
	{
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Gegner ArrayList
		for (Kugel gegnerX : game.manager.getGegner())
		{
			gegnerX.drawGegner(g2d);
		}

		// Fadenkreuz
		game.manager.getCursor().render(g2d);
	}
}
