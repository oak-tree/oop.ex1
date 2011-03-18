package filters;

public class BeforeFilter  extends FilterFactory implements filter {
	
	
	private static  String SAVE_WORD="BEFORE";
	private  String _param;
	
	public static String getSaveWord() {
		return SAVE_WORD;
	}
	public BeforeFilter(String param){
		
		_param=param;
		System.out.println("hello from before filter");
		System.out.println(_param);
		System.out.println("goodbye from before filter");
		
	}
	public void msgToUser() {
		System.out.println("after filter "+ _param);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void runCommand() {
		// TODO Auto-generated method stub

	}

}
