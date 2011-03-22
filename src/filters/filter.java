package filters;


import java.io.File;
import java.util.ArrayList;

public abstract class filter {
	
	
	private boolean _isNegativeFilter;
	
	public filter()
	{
		_isNegativeFilter = false;
	}
	/**
	 *  Construct a filter
	 * @param params the params of the filter. NOT means that we look at
	 * all the files that dont pass the filter
	 */
	
	public filter(ArrayList<String> params)
	{
		_isNegativeFilter = false;
		if (!params.isEmpty())
		{
			String st = params.get(params.size() - 1);
			if (st.equals("NOT"))
			{
				_isNegativeFilter = true;
			}
		}
	}
	/**
	 * return the result. filps between true/false if needed
	 */
	protected boolean returnResult(boolean res)
	{
		if (_isNegativeFilter)
		{
			return !res;
		}
		else
		{
			return res;
		}
	}
	
	/**
	 * checks if the file is filtered
	 * @param f the file we filter
	 * @return whether the file is filtered
	 */
	abstract public boolean isFileFilterd(File f);
	
	
	
}
