package actions;

import java.io.File;
/**
 * 
 * move a file action
 *
 */
public class MoveAction extends Action {

	private String _dirName; 
	public MoveAction(String param) {
		_dirName = param;
	}
	
	/**
	 * 	move the file
	 * * @param f the file to move 
	 */
	public void performAction(File f)
	{
		// create the directory if needed
		File outFileDir = new File (_dirName);
		if (!outFileDir.exists())
		{
			outFileDir.mkdirs();
		}
		File outFile = new File (_dirName + File.separator + f.getName());
		
		// move the file
		f.renameTo(outFile);
	}
	
	/**
	 * There cannot be actions after the move action
	 */
	public boolean isItLastAction(){
		return true;
	}

	/**
	 * There must be a reset after this action
	 */
	public boolean isActionRequireReset()
	{
		return true;
	}
}
