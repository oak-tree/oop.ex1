package filters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import myFileScriptExceptions.*;
public class DateFilter implements filter {

	private Date _comparisonDate;
	protected boolean isBefore;
	
	public DateFilter(String params)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
		_comparisonDate = sdf.parse(params);
		}
		catch (ParseException e)
		{
			throw new ParsingException(e.getMessage());
		}
	}
	@Override
	public void runCommand() {
		

	}

}
