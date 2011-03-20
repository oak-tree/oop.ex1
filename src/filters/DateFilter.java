package filters;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import myFileScriptExceptions.*;
public abstract class DateFilter extends filter {

	private Date _comparisonDate;
	
	public DateFilter(String params)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
		_comparisonDate = sdf.parse(params);
		}
		catch (ParseException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	
	abstract protected boolean isDateValid(Date fileDate, Date ComparisonDate);
	
	protected boolean isFileFilterd(File f)
	{
		return isDateValid(_comparisonDate, new Date(f.lastModified()));
	}


}
