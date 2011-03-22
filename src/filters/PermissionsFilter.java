package filters;
import java.io.File;
import java.util.ArrayList;
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
			// TODO
		}
	}
	public abstract boolean hasPermission(File f);

	
	public boolean isFileFilterd(File f)
	{
		return hasPermission(f) == _isPermisiionAllowed;
	}
}
