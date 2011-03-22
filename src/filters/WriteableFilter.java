package filters;

import java.io.File;
import java.util.ArrayList;

public class WriteableFilter extends PermissionsFilter{

	public WriteableFilter(ArrayList<String> param)
	{
		super(param);
	}
	
	/**
	 * checks if the file has writing permissions
	 * @param f the file
	 * @return whether it has writing permissions
	 */
	public boolean hasPermission(File f)
	{
		return f.canWrite();
	}
	
}
