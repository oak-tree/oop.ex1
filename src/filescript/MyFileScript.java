package filescript;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyFileScript {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try 
		{
			Date d = sdf.parse("1923/03/10");
			Date d2 = sdf.parse("1923/04/10");
			
			System.out.println(d);
			if (d2.after(d))
				System.out.println("11111");
		}
		catch (Exception e)
		{
			return ;
		}
		

	}

}
