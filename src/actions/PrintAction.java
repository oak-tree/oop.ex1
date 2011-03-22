package actions;
import java.io.File;

import java.io.IOException;

public class PrintAction extends Action {

	
	private static final String _readPermission = "r";
	private static final String _writePermission = "w";
	private static final String _execPermission = "x";
	private static final String _noPermission = "-";
	public PrintAction(String param){
	
	}
	
	public void performAction(File f)
	{
		System.out.println(getReadPermission(f) +
						   getWritePermission(f) + 
						   getExecPermission(f) + " " +
						   getFileSize(f) + " " + 
						   getFullPath(f));
	}
	
	private String getReadPermission(File f)
	{
		if (f.canRead())
		{
			return _readPermission;
		}
		else
		{
			return _noPermission;
		}
	}
	
	private String getWritePermission(File f)
	{
		if (f.canExecute())
		{
			return _writePermission;
		}
		else
		{
			return _noPermission;
		}
	}
	
	private String getExecPermission(File f)
	{
		if (f.canExecute())
		{
			return _execPermission;
		}
		else
		{
			return _noPermission;
		}
	}
	
	private long getFileSize(File f)
	{
		return f.length();
	}
	
	private String getFullPath(File f)
	{
		try
		{
			return f.getCanonicalPath();
		
		}
		catch (IOException e)
		{
			return "";
		}
	}
	
	

}
