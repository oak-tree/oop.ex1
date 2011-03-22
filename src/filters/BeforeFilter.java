package filters;

import java.util.ArrayList;
import java.util.Date;

public class BeforeFilter extends DateFilter  {

	public BeforeFilter(ArrayList<String> param)
	{
		super(param);
	}

	
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return fileDate.after(comparisonDate);
	}
}
