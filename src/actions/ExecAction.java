package actions;

import java.io.File;

public class ExecAction extends PermissionAction {

	public ExecAction(String param){
		super(param);
	}
	
	
	protected void setPermission(File f, boolean doable)
	{
		f.setExecutable(doable);
	}
	

}
