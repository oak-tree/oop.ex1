package actions;

import java.io.File;

public class WriteAction  extends PermissionAction {

	public WriteAction(String param){
		super(param);
	}
	
	/**
	 * set the file's permission
	 * @param f the file to change the permission
	 * @param doable if the file is set to writable
	 */
	protected void setPermission(File f, boolean doable)
	{
		f.setWritable(doable);
	}
}
