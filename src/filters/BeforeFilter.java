package filters;

import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * Filter files if they are before a certain date
 *
 */
public class BeforeFilter extends DateFilter  {

	public BeforeFilter(ArrayList<String> param)
	{
		super(param);
	}

	/**
	 * 
	 * Checks if the date of the file is before the given date
	 */
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return comparisonDate.before(fileDate);
	}
}
