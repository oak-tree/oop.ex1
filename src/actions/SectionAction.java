package actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * All the actions in a section
 */
public class SectionAction extends Action {

	List <Action> _actionsList;
	/**
	 * Checks whether there are actions in the section 	
	 * @return whether there are actions in the section
	 */
	public boolean isEmpty(){
		if (_actionsList.size()>0)
			return false;
			else
				return true;
	}
	
	/**
	 * Create a secton of action command
	 * @param l all the actions in the section
	 */
	public SectionAction(List <Action> l)
	{
		_actionsList = l;
	}

	/**
	 * performing all the actions in the section 
	 */
	public void performAction(File f) {
		for (Iterator <Action>i1 = _actionsList.iterator(); i1.hasNext() ;)
		{
			Action act = i1.next();
			act.performAction(f);
		}

	}
	
	/**
	 * if one action require reset, it means that there must
	 * be a reset after this section
	 */
	public boolean isActionRequireReset()
	{
		for (Iterator <Action>i1 = _actionsList.iterator(); i1.hasNext() ;)
		{
			Action act = i1.next();
			if (act.isActionRequireReset())
			{
				return true;
			}
		}
		return false;
	}

}
