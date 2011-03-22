package actions;

import java.io.File;

public class MoveAction extends Action {

	private String _dirName; 
	public MoveAction(String param) {
		_dirName = param;
	}

	public void performAction(File f)
	{
		File outFileDir = new File (_dirName);
		if (!outFileDir.exists())
		{
			outFileDir.mkdirs();
		}
		File outFile = new File (_dirName + File.separator + f.getName());
		f.renameTo(outFile);
	}
	
	public boolean isItLastAction(){
		return true;
	}
}
