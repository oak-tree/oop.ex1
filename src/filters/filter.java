package filters;
import commands.*;
import java.io.File;

public abstract class filter implements  Command {
	
	public String[] runCommand(String[] filenames) {
		return null;
		// TODO Auto-generated method stub

	}
	
	abstract public boolean isFileFilterd(File f);
	
	
	
}
