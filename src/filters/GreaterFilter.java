package filters;

import java.util.ArrayList;

public class GreaterFilter extends SizeFilter  {

	
	public GreaterFilter(ArrayList<String> param)
	{
		super(param);
	}

	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize < fileSize;
	}


}
