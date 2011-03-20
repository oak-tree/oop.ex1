package filters;

import java.io.File;

public class ReadableFilter extends PermissionsFilter {

	public ReadableFilter(String param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canRead();
	}


}
