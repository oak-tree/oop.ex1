package actions;

import java.io.File;

public class ReadAction extends PermissionAction {

	public ReadAction(String param){
		super(param);
	}
	
	/**
	 * set the file's permission
	 * @param f the file to change the permission
	 * @param doable if the file is set to readable
	 */
	protected void setPermission(File f, boolean doable)
	{
		f.setReadable(doable);
	}
	

}
