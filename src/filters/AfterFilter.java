package filters;

public class AfterFilter extends DateFilter {
	public AfterFilter(String params)

	{
		super(params);
		isBefore = false;
	}

}
