package actions;

import java.io.File;

public class ReadAction extends PermissionAction {

	public ReadAction(String param){
		super(param);
	}
	protected void setPermission(File f, boolean doable)
	{
		f.setReadable(doable);
	}
	

}
