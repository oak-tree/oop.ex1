package actions;

import java.io.File;
/**
 * 
 * Remove a file action
 *
 */
public class RemoveAction extends Action {

	/**
	 * remove a file
	 * @param f the file
	 */
	
	public void performAction(File f)
	{
		f.delete();
	}
	
	/**
	 * the remove file is the last command in an action section 
	 */
	public boolean isItLastAction(){
		return true;
	}
	
	/**
	 * We should get the files against after a remove file 
	 */
	public boolean isActionRequireReset()
	{
		return true;
	}
}
