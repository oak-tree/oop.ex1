package filters;

public class BeforeFilter extends DateFilter  {

	public BeforeFilter(String params)
	{
		super(params);
		isBefore = true;
	}

}
