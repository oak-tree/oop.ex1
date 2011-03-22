package filescript;
import actions.Action;
import actions.SectionAction;
import filters.filter;
import orders.order;
import fileManager.*;

import myFileScriptExceptions.*;

import java.util.*;
import java.io.File;


/**
 * 
 * class for performing the action-filter-order commands
 *
 */
public class Script {
	private Action _actionCommand;
	private filter _filterCommand;
	private order _orderCommand;
	private List<String> _comments;
	
	/**
	 *  construct one script
	 * @param act the action of the script
	 * @param filt the filter of the script
	 * @param ord the order in which we sort the files 
	 */
	public Script(Action act, filter filt, order ord, List<String> comments)
	{
		_actionCommand = act;
		_filterCommand = filt;
		_orderCommand = ord;
		_comments = comments;
	}
	
	/**
	 * run the action on the filtered files
	 * @param fm the file manager instance which we run
	 * all the actions on
	 */
	public void runScript(FileManager fm)
	{
		fm.ChangeComparator(_orderCommand);
		for (Iterator<String> i1 = _comments.iterator(); i1.hasNext();)
		{
			String st = i1.next();
			System.out.println(st);
		}
		for (Iterator<FileElement> i1 = fm.getFilesIterator(); i1.hasNext(); )
		{
			File f = new File (i1.next().getFileName());
			// if the file is filtered, run the action
			if (_filterCommand.isFileFilterd(f))
			{
				_actionCommand.performAction(f);
				if(_actionCommand.isActionRequireReset())
				{
					fm.reset();
				}
			}
		
		}

	}
	
	
}
