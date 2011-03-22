package actions;
import java.io.File;

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
			throw new ParsingException ("bla");
		}
		// TODO
	
	}
	
	abstract protected void setPermission(File f, boolean doable);

	public void performAction(File f)
	{
		setPermission(f, _isSetToTrue);
	}
}
