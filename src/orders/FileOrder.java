package orders;

import java.io.File;

import fileManager.FileElement;

public class FileOrder  extends order {

	protected void insertData(FileElement fe)
	{
		File f = new File (fe.getFileName());
		fe.setData(f.getName());
	}
	@Override
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		checkData(o1, o2);
		return ((String) o1.getData()).compareTo((String) (o2.getData())); 
	}

}
