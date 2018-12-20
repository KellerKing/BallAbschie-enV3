import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Cursor implements MouseMotionListener, MouseListener
{

	private BufferedImage cursor;

	public Cursor()
	{

	}

	public Cursor(Steuerung game)
	{
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
		}
		else
		{
			g2d.drawImage(cursor, mouseX, mouseY, null);
		}
	}

	// public void updatePos() // TODO variablen
	// {
	// mouseX = -1280 + (int) MouseInfo.getPointerInfo().getLocation().getX();
	// mouseY = -720 + (int) MouseInfo.getPointerInfo().getLocation().getY();
	//
	// System.out.printf("X: %s \n Y: %s", mouseX, mouseY);
	// }

	public Cursor getCursor()
	{
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

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
		mouseX = e.getX();
		mouseY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

}
