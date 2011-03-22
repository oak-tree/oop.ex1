package filters;
import java.io.File;
import java.lang.NumberFormatException;
import java.util.ArrayList;

import myFileScriptExceptions.*;

public abstract class SizeFilter   extends filter {

	int _size; 
	
	public SizeFilter(ArrayList<String> param) {
		super(param);
		try
		{
		_size = Integer.parseInt(param.get(0));
		}
		catch (NumberFormatException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	
	abstract protected boolean isSizeValid(long paramSize, long fileSize);
	
	public boolean isFileFilterd(File f)
	{
		return returnResult(isSizeValid(_size, f.length()));
	}


}
