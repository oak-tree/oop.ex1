package fileManager;

import java.util.Comparator;

public class DefaultComparator implements Comparator<FileElement> 
{

	@Override
	public int compare(FileElement o1, FileElement o2) {
		// TODO Auto-generated method stub
		return o1.getFileName().compareTo(o2.getFileName());
	}

	
}
