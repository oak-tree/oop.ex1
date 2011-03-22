package filters;
import commands.*;
import java.io.File;
import java.util.ArrayList;

public abstract class filter implements  Command {
	
	
	private boolean _isNegativeFilter;
	
	public filter()
	{
		_isNegativeFilter = false;
	}
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
	public String[] runCommand(String[] filenames) {
		return null;
		// TODO Auto-generated method stub

	}
	
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
	abstract public boolean isFileFilterd(File f);
	
	
	
}
