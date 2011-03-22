package filescript;
import actions.Action;
import actions.SectionAction;
import filters.filter;
import orders.order;
import fileManager.*;
import myFileScriptExceptions.*;

public class Script {
	private Action _actionCommand;
	private filter _filterCommand;
	private order _orderCommand;
	
	public Script(Action act, filter filt, order ord)
	{
		_actionCommand = act;
		_filterCommand = filt;
		_orderCommand = ord;
	}
	
	public void runScript(FileManager fm)
	{

	}
	
	
}
