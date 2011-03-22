package filters;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import myFileScriptExceptions.*;

/**
 * 
 * a date-based filter
 *
 */
public abstract class DateFilter extends filter {

	private Date _comparisonDate;
	
	/**
	 * Create a date filter
	 * @param param the data we compare to
	 */
	public DateFilter(ArrayList<String> param)
	{
		super(param);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			String d = param.get(0);
			_comparisonDate = sdf.parse(param.get(0));
			param.remove(0);
		}
		catch (ParseException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	
	/**
	 * checks whether the date is filtered
	 * @param fileDate the file's date
	 * @param ComparisonDate the date we compare all the files to
	 * @return whether the file has passed the test
	 */
	abstract protected boolean isDateValid(Date fileDate, Date ComparisonDate);
	
	
	/**
	 * checks if the file has passsed the date test 
	 */
	public boolean isFileFilterd(File f)
	{
		return returnResult(isDateValid(_comparisonDate, new Date(f.lastModified())));
	}


}
