package filters;

import java.io.File;
import java.util.ArrayList;

public class ReadableFilter extends PermissionsFilter {

	public ReadableFilter(ArrayList<String> param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canRead();
	}


}
