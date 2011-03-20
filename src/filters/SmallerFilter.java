package filters;

public class SmallerFilter  extends SizeFilter {

	
	public SmallerFilter(String param)
	{
		super(param);
	}
	protected boolean isSizeValid(long paramSize, long fileSize)
	{
		return paramSize < fileSize;
	}

}
