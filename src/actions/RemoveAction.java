package actions;

import java.io.File;

public class RemoveAction extends Action {

	public RemoveAction(String param) {
	
	}

	public void performAction(File f)
	{
		f.delete();
	}
	public boolean isItLastAction(){
		return true;
	}
	public boolean isActionRequireReset()
	{
		return true;
	}
}
