package orders;

import java.io.File;

import fileManager.FileElement;

public class FileOrder  extends AbsOrder {

	AbsOrder _defaultOrder;
	public FileOrder()
	{
		
	}
	protected void insertData(FileElement fe)
	{
		File f = new File (fe.getFileName());
		fe.setData(f.getName());
	}
	@Override
	/**
	 * compare file based on their name
	 * @param o1 the first element we compare
	 * @param o2 the second element we compare
	 */
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		checkData(o1, o2);
		int res = ((String) o1.getData()).compareTo((String) (o2.getData()));
		if (res == 0)
		{
			return super.compare(o1, o2);
		}
		return res;
	}

}
