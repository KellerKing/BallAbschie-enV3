import java.util.ArrayList;

public class Steuerung
{

	private final int STARTANZ = 3;
	

	private ArrayList<Kugel> gegner = new ArrayList<Kugel>();

	public void update(ArrayList<Kugel> arrayList)
	{
		for (Kugel a : arrayList)
		{
			a.move();
//			a.ballKollision();
		}
	}

	public ArrayList<Kugel> getGegner()
	{
			return gegner;
	}

	public void init()
	{
		for (int i = 0; i < STARTANZ; i++)
		{
			gegner.add(new Ballon());
		}
	}

}
