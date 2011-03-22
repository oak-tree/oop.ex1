package filters;

import java.util.ArrayList;

public class SmallerFilter  extends SizeFilter {

	
	public SmallerFilter(ArrayList<String> param)
	{
		super(param);
	}
	
	
	/**
	 * Checks if the file size is smaller that the given parameter
	 * @param paramSize the file we compare to
	 * @param fileSize the size of the file 
	 */
	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize > fileSize;
	}

}
