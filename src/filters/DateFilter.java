package filters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import myFileScriptExceptions.*;
public class DateFilter implements filter {

<<<<<<< HEAD
public class DateFilter implements filter {

	public DateFilter(){
		//do something 
=======
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
>>>>>>> a33ecd137e2e66ddcaf52fb56278767e3faabd11
	}
	@Override
	public void runCommand() {
		

	}

}
