package filters;
import java.io.File;
import java.lang.NumberFormatException;
import myFileScriptExceptions.*;

public abstract class SizeFilter   extends filter {

	int _size; 
	
	public SizeFilter(String param) {
		try
		{
		_size = Integer.parseInt(param);
		}
		catch (NumberFormatException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	
	abstract protected boolean isSizeValid(long paramSize, long fileSize);
	
	public boolean isFileFilterd(File f)
	{
		return isSizeValid(_size, f.length());
	}


}
