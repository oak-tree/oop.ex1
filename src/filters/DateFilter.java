package filters;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import myFileScriptExceptions.*;
public abstract class DateFilter extends filter {

	private Date _comparisonDate;
	
	public DateFilter(ArrayList<String> param)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
		_comparisonDate = sdf.parse(param.get(0));
		}
		catch (ParseException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	
	abstract protected boolean isDateValid(Date fileDate, Date ComparisonDate);
	
	public boolean isFileFilterd(File f)
	{
		return isDateValid(_comparisonDate, new Date(f.lastModified()));
	}


}
