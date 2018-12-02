import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameField extends JPanel
{
	private boolean init = false;

	//private Game game = new Game();
	private Steuerung managerX = new Steuerung();
	
	public GameField(int w, int h)
	{
		JFrame fenster = new JFrame();
		fenster.setResizable(false);
		fenster.setLayout(null);
		fenster.setBounds(0, 0, w, h);
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0,0,w,h);
		this.setBackground(Color.CYAN);
		fenster.add(this);
		
		fenster.setVisible(true);
		requestFocus();
		
		

	}

	public GameField()
	{

	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if(!init) // Das init zeichnung nicht bei repaint
		{
			
			for(Kugel gegnerX : managerX.getGegner()) //FIXME Nullpointer
			{
				gegnerX.drawGegner(g2d);
			}
		}
		else
		{
			init = true;
		}
		
		//game.update(g2d); //Updatet die ganzen Grafiken (Ohne Timer, yey :D )

	}

}
