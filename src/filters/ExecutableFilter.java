package filters;

import java.io.File;
import java.util.ArrayList;

public class ExecutableFilter extends PermissionsFilter {
	
	public ExecutableFilter(ArrayList<String> param)
	{
		super(param);
	}
	/**
	 * check if the file is executable
	 */
	public boolean hasPermission(File f)
	{
		return f.canExecute();
	}

}
