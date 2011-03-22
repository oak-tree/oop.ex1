package actions;

import java.io.File;

public class RemoveAction extends Action {

	public RemoveAction(String param) {
	
	}

	protected void performAction(File f)
	{
		f.delete();
	}
	public boolean isItLastAction(){
		return true;
	}
}
