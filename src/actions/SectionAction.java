package actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;


public class SectionAction extends Action {

	List <Action> _actionsList;
	
	public boolean isEmpty(){
		if (_actionsList.size()>0)
			return false;
			else
				return true;
	}
	public SectionAction(List <Action> l)
	{
		_actionsList = l;
	}
	@Override
	public void performAction(File f) {
		for (Iterator <Action>i1 = _actionsList.iterator(); i1.hasNext() ;)
		{
			Action act = i1.next();
			act.performAction(f);
		}

	}

}
