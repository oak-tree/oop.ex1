package filters;

public class GreaterFilter extends SizeFilter  {

	
	public GreaterFilter(String param)
	{
		super(param);
	}

	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize > fileSize;
	}


}
