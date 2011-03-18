package filescript;
import Parser.*;


public class MyFileScript {

	private static boolean validation(String[] args){
		//check here if user enter file name
		//check if filename is legal? maybe dont need a check here;
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----welcome screen----");
		if (validation(args)==true) { 
			MyFileScriptParser scriptParser = new MyFileScriptParser();
			//scriptParser.parseFile(args[0]);
			scriptParser.parseFile("testfiles/test.txt");
		}
		
	}

}
