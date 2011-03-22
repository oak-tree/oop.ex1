package filters;

import java.io.File;
import java.util.ArrayList;

public class ExecutableFilter extends PermissionsFilter {
	public ExecutableFilter(ArrayList<String> param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canExecute();
	}

}
