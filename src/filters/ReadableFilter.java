package filters;

import java.io.File;
import java.util.ArrayList;

public class ReadableFilter extends PermissionsFilter {

	public ReadableFilter(ArrayList<String> param)
	{
		super(param);
	}
	
	/**
	 * checks if the file has reading permissions
	 * @param f the file
	 * @return whether it has reading permissions
	 */
	public boolean hasPermission(File f)
	{
		return f.canRead();
	}


}
