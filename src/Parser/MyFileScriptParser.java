package Parser;
import commands.*;
import filters.*;
import Exceptions.*;
public class MyFileScriptParser {
	public Command[] parseFile(String fileString)
	{
		return null;
	}
	void parseCommanrd() {}
	void parseAction() 
	{
		try {
			new GreaterFilter();
		}
		catch (ParsingException e)
		{
			System.out.println(e.getMessage());
		}
	}
	void parseFilter() {}
	void parseOrder() {}
}
