package actions;
import java.io.File;

import myFileScriptExceptions.*;
public abstract class PermissionAction extends Action {
	private boolean _isSetToTrue;
	public PermissionAction (String param)
	{
		if (param.equals("Y"))
		{
			_isSetToTrue = true;
		}
		else if (param.equals("N"))
		{
			_isSetToTrue  = false;
		}
		// TODO
		throw new ParsingException ("bla");
	}
	
	abstract protected void setPermission(File f, boolean doable);

	protected void performAction(File f)
	{
		setPermission(f, _isSetToTrue);
	}
}
