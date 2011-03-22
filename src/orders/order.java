package orders;


import java.util.Comparator;
import fileManager.FileElement;
public abstract class order implements Comparator<FileElement> {

	

	/**
	 * insert the data for the comparision to the file element,
	 * so we will do it only once per object
	 */
	 
	abstract protected void insertData(FileElement fe);
	
	/**
	 * Check if we need to add the dat to the elemtn
	 */
	protected void checkData (FileElement fe1, FileElement fe2)
	{
		if (fe1.getData() == null)
		{
			insertData(fe1);
		}
		if (fe2.getData() == null)
		{
			insertData(fe2);
		}

		
	}
}
