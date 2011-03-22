package orders;

import fileManager.FileElement;

public class AbsOrder extends order {

	protected void insertData(FileElement fe)
	{
	}
	
	/**
	 * compare file based on their full path
	 * @param o1 the first element we compare
	 * @param o2 the second element we compare
	 */
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		return o1.getFileName().compareTo(o2.getFileName());
	}
}
