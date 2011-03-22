package orders;

import fileManager.FileElement;
import java.io.File;
import java.io.IOException;
public class AbsOrder extends order {

	protected void insertData(FileElement fe)
	{
		File f = new File (fe.getFileName());
		try
		{
			fe.setData(f.getCanonicalFile());
		}
		catch (IOException e)
		{
			
		}
	}
	@Override
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		checkData(o1, o2);
		return ((String) o1.getData()).compareTo((String) (o2.getData())); 
		}


}
