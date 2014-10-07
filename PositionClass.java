public class PositionClass
{
	private int x, y;

	public void PositionClass ()
	{
		x = 0;
		y = 0;
	}
 
	public void setX ()
	{
		x = 0;
	}

	public void setY ()
	{
		y = 0;
	}

	public void setX (int inX)
	{
		x = inX;
	}

	public void setY (int inY)
	{
		y = inY;
	}

	public void setPosition(int inX, int inY)
	{
		x = inX;
		y = inY;
	}

	public int getX ()
	{
		return x;
	}

	public int getY ()
	{
		return y;
	}

	public String getPosition()
	{
		return x + ", " + y;
	}

}