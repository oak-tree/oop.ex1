package filters;

import java.util.Date;

public class BeforeFilter extends DateFilter  {

	public BeforeFilter(String params)
	{
		super(params);
	}

	
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return fileDate.after(comparisonDate);
	}
}
