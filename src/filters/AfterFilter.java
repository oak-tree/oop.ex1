package filters;

import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * Filter files if they are after a certain date
 *
 */
public class AfterFilter  extends DateFilter  {
	

	public AfterFilter(ArrayList<String> param){
		super(param);
	}

	/**
	 * 
	 * Checks if the date of the file is after the given date
	 */
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return comparisonDate.after(fileDate);
	}

}
