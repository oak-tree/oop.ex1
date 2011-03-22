package actions;
import java.io.File;

/**
 * All the permissions changing actions' interface
 */

import myFileScriptExceptions.*;
public abstract class PermissionAction extends Action {
	private boolean _isSetToTrue;
	
	
	public PermissionAction (String param)
	{
		if (param!=null) {
			if (param.equals("Y"))
			{
			_isSetToTrue = true;
			}
			else if (param.equals("N"))
			{
			_isSetToTrue  = false;
			}
		}	
		else{
			throw new BadParametersException ("Unknown paramter given");
		}
	
	}
	/**
	 * Set a permission
	 * @param f the file to set the permission
	 * @param doable whether to give the permission or to take it
	 */
	abstract protected void setPermission(File f, boolean doable);

	/**
	 * perform the change permission action
	 */
	public void performAction(File f)
	{
		setPermission(f, _isSetToTrue);
	}
}
