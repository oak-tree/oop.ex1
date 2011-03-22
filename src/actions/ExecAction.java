package actions;

import java.io.File;

public class ExecAction extends PermissionAction {

	public ExecAction(String param){
		super(param);
	}
	
	/**
	 * set the file's permission
	 * @param f the file to change the permission
	 * @param doable if the file is set to executable
	 */
	protected void setPermission(File f, boolean doable)
	{
		f.setExecutable(doable);
	}
	

}
