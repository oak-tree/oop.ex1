package filters;

public class AfterFilter  extends DateFilter  {
	private  String _param;
	

	public AfterFilter(String param){
		_param=param;
		System.out.println("hello from after filter");
		System.out.println(_param);
		System.out.println("goodbye from after filter");
	}
	@Override
	public void runCommand() {
		// TODO Auto-generated method stub

	}

}
