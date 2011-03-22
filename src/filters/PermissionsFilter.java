package filters;
import java.io.File;
import java.util.ArrayList;
import myFileScriptExceptions.BadParametersException;

/**
 * 
 * a filter based on the file's permissions
 *
 */
public abstract class PermissionsFilter extends filter {
	boolean _isPermisiionAllowed;
	public PermissionsFilter(ArrayList<String> param)
	{
		if (param.get(0).equals("Y"))
		{
			_isPermisiionAllowed = true;
		}
		else if (param.get(0).equals("N"))
		{
			_isPermisiionAllowed = false;
			
		}
		else
		{
			throw new BadParametersException("unknown parameter");
		}

	}
	
	/**
	 * checks if the file is filtered based on its permissions
	 * @param f the file
	 * @return whether it is filtered
	 */
	public abstract boolean hasPermission(File f);

	
	public boolean isFileFilterd(File f)
	{
		return returnResult(hasPermission(f) == _isPermisiionAllowed);
	}
}
