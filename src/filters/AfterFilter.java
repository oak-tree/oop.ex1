package filters;

public class AfterFilter  extends DateFilter  {
	

	public AfterFilter(String param){
		super(param);
		isBefore = false;
		System.out.println("hello from after filter");
		System.out.println(param);
		System.out.println("goodbye from after filter");
	}


}
