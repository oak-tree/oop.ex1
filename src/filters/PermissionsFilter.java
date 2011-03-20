package filters;
import java.io.File;
public abstract class PermissionsFilter extends filter {
	boolean _isPermisiionAllowed;
	public PermissionsFilter(String param)
	{
		if (param.equals("Y"))
		{
			_isPermisiionAllowed = true;
		}
		else if (param.equals("N"))
		{
			_isPermisiionAllowed = false;
			
		}
		else
		{
			// TODO
		}
	}
	public abstract boolean hasPermission(File f);

}
