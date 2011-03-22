package filescript;
import Parser.*;
import java.util.List;

import java.io.FilePermission;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import myFileScriptExceptions.ParsingException;
import fileManager.*;
public class MyFileScript {

	private static boolean validation(String[] args){
		//check here if user enter file name
		//check if filename is legal? maybe dont need a check here;
		return true;
	}
	
	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 * @throws ParsingException 
	 */
	public static void main(String[] args) throws ParsingException, IllegalArgumentException, SecurityException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		

		MyFileScriptParser scriptParser = new MyFileScriptParser();
		//scriptParser.parseFile("testfiles/test2.txt");

			try {

				List<Script> scripts = scriptParser.parseFile("testfiles\\test2.txt");
				//FileManager fm = new FileManager(args[1]);
				FileManager fm = new FileManager("C:\\Users\\ami\\Documents\\srefat");
				Script script = scripts.remove(0);
				script.runScript(fm);


			} catch (ParsingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
		
	}

}
