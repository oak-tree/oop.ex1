package orders;

import fileManager.FileElement;

public class AbsOrder extends order {

	protected void insertData(FileElement fe)
	{
	}
	@Override
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		return o1.getFileName().compareTo(o2.getFileName());
	}
}
