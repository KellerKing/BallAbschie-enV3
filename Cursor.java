import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Cursor implements MouseMotionListener, MouseListener
{
	private Steuerung game;

	private BufferedImage cursor;

	private Rectangle hitbox;

	public Cursor()
	{

	}

	public Cursor(Steuerung game)
	{
		this.game = game;

		SpriteSheet spritesFianly = new SpriteSheet(game.getSpriteSheet());

		cursor = spritesFianly.grabImage(1, 1, 32, 32);

	}

	private boolean outOf = false;
	private int mouseX;
	private int mouseY;

	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		if (outOf == true)
		{
		} else
		{
			g2d.drawImage(cursor, mouseX - 16, mouseY - 16, null);
			g2d.drawRect(mouseX, mouseY, 15, 15);
		}
	}

	public Cursor getCursor()
	{
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		updateCursorHit(e);
		CheckHit();

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		outOf = false;
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		outOf = true;

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		updateCursorHit(e);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		updateCursorHit(e);
		CheckHit();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		updateCursorHit(e);
	}

	public void updateCursorHit(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();

		hitbox = new Rectangle(mouseX, mouseY, 10, 10);
	}

	public void CheckHit()
	{
		for (int i = 0; i < game.getGegner().size(); i++)
		{
			Rectangle gegner = game.getGegner().get(i).getBounds();

			if (hitbox.intersects(gegner))
			{
				game.getGegner().remove(i);
				System.out.println("Treffer");
			}
		}
	}

}
