package filters;

import java.util.Date;

public class AfterFilter  extends DateFilter  {
	

	public AfterFilter(String param){
		super(param);
		System.out.println("hello from after filter");
		System.out.println(param);
		System.out.println("goodbye from after filter");
	}

	
	protected boolean isDateValid(Date fileDate, Date comparisonDate)
	{
		return fileDate.after(comparisonDate);
	}

}
