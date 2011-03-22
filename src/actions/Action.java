package actions;

import java.io.File;


/**
 * 
 * Action interface for all the actions 
 */
public abstract class Action {

	
	/*
	 *  is the action is the last action in a section
	 *  @return whether there can't be another command follow this action
	 */
	public boolean isLastCommand() {
		return false;
		// TODO Auto-generated method stub

	}
	
	/**
	 * Perform the action
	 * @param f the file we perform the action on
	 */
	abstract public void performAction(File f);

	/**
	 * whether the action changes the file structure of the directory
	 * @return whether need to get all the files of the directory
	 */
	public boolean isActionRequireReset()
	{
		return false;
	}
}
