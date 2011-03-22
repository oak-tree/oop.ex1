package filters;
import java.io.File;
import java.util.List;
import java.util.Iterator;

import commands.Command;
public abstract class BinaryOperatorFilter extends filter {


	private List<filter> _filterList;
	abstract protected boolean binaryOperator(boolean b1, boolean b2); 
	protected boolean _defaultValue;

	
	public BinaryOperatorFilter(List<filter> filterList)
	{
		_filterList = filterList;
	}
	public boolean isFileFilterd(File f)
	{
		boolean res = _defaultValue;
		for (Iterator<filter>i1 = _filterList.iterator(); i1.hasNext() ;)
		{
			filter filt = i1.next();
			res = binaryOperator(res, filt.isFileFilterd(f));
			
			// assuming that the binary operator is either AND or OR,
			// so if we found false in the AND operator we can stop,
			// and if we found true in the OR we can stop.
			if (res != _defaultValue)
			{
				return res;
			}
		}
		return res;
	}
}
