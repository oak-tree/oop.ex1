package filters;

import java.util.ArrayList;

public class GreaterFilter extends SizeFilter  {

	
	public GreaterFilter(ArrayList<String> param)
	{
		super(param);
	}
	/**
	 * Checks if the file size is bigger that the given parameter
	 * @param paramSize the file we compare to
	 * @param fileSize the size of the file 
	 */
	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize < fileSize;
	}


}
