package actions;

import java.io.File;

import commands.Command;

public abstract class Action implements Command {
	public String[] runCommand(String[] filenames) {
		return null;
		// TODO Auto-generated method stub

	}
	
	abstract protected void performAction(File f);
}
