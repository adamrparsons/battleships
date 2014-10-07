import io.*;

public class BsApp
{



	public static void main (String [] args)			//Main method, first asks for the name of the map file, then creates the relevant 
														//objects and calls the significant methods of BattleShips object bsObject							
	{	

		
		char 		elementTest;
		int 		size;
		TextFile 	theMapFile;

		theMapFile = readMap();

		size = theMapFile.readInt();
		theMapFile.clearRestOfLine();
		System.out.println("maps is " + size + " in both dimensions");

		BattleShips bsObject = new BattleShips(size);


		bsObject.populateMap(theMapFile);
		theMapFile.closeFile();			
		bsObject.play();

	}

	public static TextFile readMap ()				//Method for reading data file into memory
	{
		String 	fileNameInput;
		TextFile theMapFile;

		do{
			fileNameInput = ConsoleInput.readWord("enter map filename");
			theMapFile = new TextFile (fileNameInput, "r");
		} while	(theMapFile.openFile() == false);	

		return theMapFile;
	}
}
