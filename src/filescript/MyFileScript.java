package filescript;
import Parser.*;

import java.io.FilePermission;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import myFileScriptExceptions.ParsingException;
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
		
		
		//FilePermission fp = new FilePermission("C:\\Users\\ami\\My Documents\\bla.txt","");
	//	System.out.println(wildCardMatch("amiamiami", "ami*ami"));
		
		System.out.println("----welcome screen----");
	//	if (validation(args)==true) { 
			MyFileScriptParser scriptParser = new MyFileScriptParser();
			//scriptParser.parseFile(args[0]);
			try {
				scriptParser.parseFile("testfiles/test.txt");
			} catch (ParsingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
	}

}
