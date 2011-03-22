package filters;

import java.util.ArrayList;
import java.util.Date;

public class AfterFilter  extends DateFilter  {
	

	public AfterFilter(ArrayList<String> param){
		super(param);
		System.out.println("hello from after filter");
		//System.out.println(param);
		System.out.println("goodbye from after filter");
	}

	
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return comparisonDate.after(fileDate);
	}

}
