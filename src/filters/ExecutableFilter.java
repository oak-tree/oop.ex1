package filters;

import java.io.File;

public class ExecutableFilter extends PermissionsFilter {
	public ExecutableFilter(String param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canExecute();
	}

}
