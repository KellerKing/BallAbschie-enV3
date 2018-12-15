//Quelle: https://www.youtube.com/watch?v=jedilHUPO7c&index=5&list=PLWms45O3n--6KCNAEETGiVTEFvnqA7qCi

import java.awt.image.BufferedImage;

public class SpriteSheet
{
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image)
	{
		this.image = image;
	}
	
	public BufferedImage grabImage (int col, int row, int width, int heigth)
	{
		BufferedImage img = image.getSubimage((col * 32) - 32, (row * 32) - 32, width, heigth);
		return img;
	}
	
}
