package actions;

import java.io.File;

import commands.Command;

public abstract class Action implements Command {
	public String[] runCommand(String[] filenames) {
		return null;
		// TODO Auto-generated method stub

	}
	public boolean isLastCommand() {
		return false;
		// TODO Auto-generated method stub

	}
	
	abstract public void performAction(File f);

	public boolean isActionRequireReset()
	{
		return false;
	}
}
