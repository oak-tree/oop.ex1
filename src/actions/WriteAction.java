package actions;

import java.io.File;

public class WriteAction  extends PermissionAction {

	public WriteAction(String param){
		super(param);
	}
	protected void setPermission(File f, boolean doable)
	{
		f.setWritable(doable);
	}
}
