package actions;

import java.io.File;

public class MoveAction extends Action {

	private String _dirName; 
	public MoveAction(String param) {
		_dirName = param;
	}

	protected void performAction(File f)
	{
		File outFileDir = new File (_dirName);
		if (!outFileDir.exists())
		{
			outFileDir.mkdirs();
		}
		File outFile = new File (_dirName + f.getName());
		f.renameTo(outFile);
	}
}
