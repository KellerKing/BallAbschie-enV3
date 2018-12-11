import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Cursor extends JPanel implements MouseListener
{	
	
	private CursorMove move = new CursorMove();

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.drawLine(move.getMouseX() -10, move.getMouseY() - 10, move.getMouseX() +10, move.getMouseX() +10);
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
}
class CursorMove implements MouseMotionListener
{
	
	private Cursor cursor = new Cursor();

	int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
	int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		this.mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		this.mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();		
		cursor.repaint();
	}

	/**
	 * @return the mouseX
	 */
	public int getMouseX()
	{
		return mouseX;
	}

	/**
	 * @return the mouseY
	 */
	public int getMouseY()
	{
		return mouseY;
	}
	
	
	
}
