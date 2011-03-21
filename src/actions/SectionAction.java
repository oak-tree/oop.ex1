package actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;


public class SectionAction extends Action {

	List <Action> _actionsList;
	SectionAction(List <Action> l)
	{
		_actionsList = l;
	}
	@Override
	protected void performAction(File f) {
		for (Iterator <Action>i1 = _actionsList.iterator(); i1.hasNext() ;)
		{
			Action act = i1.next();
			act.performAction(f);
		}

	}

}
