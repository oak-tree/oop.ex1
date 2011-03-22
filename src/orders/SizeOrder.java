package orders;

import java.io.File;

import fileManager.FileElement;

public class SizeOrder  extends order {

	protected void insertData(FileElement fe)
	{
		File f = new File (fe.getFileName());
		fe.setData(new Long(f.length()));
	}
	@Override
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		checkData(o1, o2);
		return ((Long) o1.getData()).compareTo((Long) (o2.getData())); 
	}
}
