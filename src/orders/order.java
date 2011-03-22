package orders;

import commands.Command;
import java.util.Comparator;
import fileManager.FileElement;
public abstract class order implements Command, Comparator<FileElement> {

	public String[] runCommand(String[] filenames) {
		return null;
		// TODO Auto-generated method stub

	}

	abstract protected void insertData(FileElement fe);
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
