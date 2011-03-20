package filters;

import java.io.File;

public class WriteableFilter extends PermissionsFilter{

	public WriteableFilter(String param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canWrite();
	}
	
}
