package orders;

import java.io.File;

import fileManager.FileElement;

public class SizeOrder  extends AbsOrder {

	protected void insertData(FileElement fe)
	{
		File f = new File (fe.getFileName());
		fe.setData(new Long(f.length()));
	}

	/**
	 * compare file based on their size
	 * @param o1 the first element we compare
	 * @param o2 the second element we compare
	 */
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		checkData(o1, o2);
		int res = ((Long) o1.getData()).compareTo((Long) (o2.getData()));
		if (res == 0)
		{
			return super.compare(o1, o2);
		}
		return res;
	}
}
