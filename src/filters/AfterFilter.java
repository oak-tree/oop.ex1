package filters;

import java.util.ArrayList;
import java.util.Date;

public class AfterFilter  extends DateFilter  {
	

	public AfterFilter(ArrayList<String> param){
		super(param);
		
	}

	
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return comparisonDate.after(fileDate);
	}

}
