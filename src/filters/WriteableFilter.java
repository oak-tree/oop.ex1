package filters;

import java.io.File;
import java.util.ArrayList;

public class WriteableFilter extends PermissionsFilter{

	public WriteableFilter(ArrayList<String> param)
	{
		super(param);
	}
	public boolean hasPermission(File f)
	{
		return f.canWrite();
	}
	
}
