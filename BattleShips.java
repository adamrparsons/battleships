import io.*;
public class BattleShips extends Map
{
	
	PositionClass 	position;
	boolean			finishedGame;
	int 			trycount,
					hitcount,
					misscount;
					
	public BattleShips(int size_in)
	{
		super(size_in);	
		position = new PositionClass();
	}

	public void populateMap(TextFile theMapFile)
	{
			
		for (int y = 0; y < getMapSize(); y++) 
				
			{
				for(int x = 0; x < getMapSize(); x++)	
					
					{
					char mapElement;

					mapElement = theMapFile.readChar();
					setMapElement(x,y,mapElement);
					System.out.print(getMapElement(x,y));
					}

				System.out.print("\n");
				theMapFile.clearRestOfLine();																		
			}
	}

	public void outputGrid ()
	{

		for (int y = 0; y < getMapSize(); y++ ) 

			{	
				for (int x = 0; x < getMapSize(); x++ ) 
				{
					char element;

					element  = getMapElement (x,y);
					System.out.print(element );				
				}
				System.out.println();
			}

	}



	public void play()
	{
		System.out.println("Welcome to BattleShips, your map size is " + super.getMapSize() + "\n" + "Goodluck! ");
		
		int shipPartCount = determineNumberOfShipParts();

		while (hitcount < shipPartCount)
			{
			trycount++;
			System.out.println("Enter the co-ordinates");

			position.setX(ConsoleInput.readInt("x position")-1);								//Correcting human perception of position (1 -> size) 
			position.setY(ConsoleInput.readInt("y position")-1);								//to java perception (0 -> size-1)

			hitDetection();
			if (ConsoleInput.readChar("show map? type y or press the any other key for no") == 'y') 
				{
					clearWindow();
					outputGrid();		
				}
			else
				{
					clearWindow();
				}
			}

		outputStats ();
	}



	public int determineNumberOfShipParts ()
	{		
		int shipPartCount = 0;
		for (int x = 0; x < getMapSize(); x++ ) 
		{
			for (int y = 0; y < getMapSize(); y++ ) 
			{
				if (getMapElement (x,y) == super.SHIP)
					shipPartCount++;
			}	
		}
		return shipPartCount;
	}



	public void hitDetection()
	{
		int 	inX, inY;
		char 	elementChar;

		inX = position.getX();
		inY = position.getY();
		
		elementChar = getMapElement(inX, inY);

		if (elementChar == super.SHIP) 
		{
			setMapElement(inX, inY, super.SHIPHIT);
			System.out.println("Ship hit!");
			hitcount++;
		} 
		else	
			if (elementChar == super.OCEAN) 
			{
				System.out.println("Miss! Ocean hit!");
				misscount++;
			}
			else
				if (elementChar == super.SHIPHIT) 
				{
			 		System.out.println("You have already sunk this area, try again");				
				}
				else 
					{
						System.out.println("something went wrong");
					}
	}	



	public void clearWindow ()
	{
		for (int clearIndex = 0; clearIndex<100 ; clearIndex++ ) 
			{											
				System.out.println();
			}
	}



	public void outputStats ()
	{
		System.out.println("Game complete");
		System.out.println("Total tries = " + trycount);
		System.out.println("Total misses = " + misscount);
		System.out.println("Total hits = " + hitcount);
	}

}