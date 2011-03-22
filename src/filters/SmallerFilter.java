package filters;

import java.util.ArrayList;

public class SmallerFilter  extends SizeFilter {

	
	public SmallerFilter(ArrayList<String> param)
	{
		super(param);
	}
	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize > fileSize;
	}

}
