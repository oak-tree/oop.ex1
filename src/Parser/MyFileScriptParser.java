package Parser;

// dont have this file right now import myFileScriptExceptions.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import orders.OrderFactory;
import myFileScriptExceptions.ParsingException;
import actions.ActionFactory;

import commands.Command;

import filters.*;
//import filters.FilterFactory;
//import filters.GreaterFilter;

public class MyFileScriptParser {

	private final static String[] SaveWords = { "%", "ACTION", "FILTER",
			"ORDER", };

	// private final static int[]
	private final static String LINE_STR_ORDER_COMMENT = "%";
	private final static String LINE_STR_FILTER_START = "FILTER";
	private final static String LINE_STR_ACTION_START = "ACTION";
	private final static String LINE_STR_ORDER_START = "ORDER";

	private final static int LINE_TYPE_COMMENT = 0;
	private final static int LINE_TYPE_ACTION_START = LINE_TYPE_COMMENT + 1;
	private final static int LINE_TYPE_FILTER_START = LINE_TYPE_ACTION_START + 1;
	private final static int LINE_TYPE_ORDER_START = LINE_TYPE_FILTER_START + 1;
	private final static int LINE_TYPE_OTHER = LINE_TYPE_ORDER_START + 1;// saveWords.length

	private final static int INT_STR_MATCH = 0;

	/**
	 * get first word in line
	 * 
	 * @param string
	 *            holding line data
	 * @return string first word
	 */
	private static String getFirstWord(String line) {
		// TODO insert error checking
		return line.split(" ")[0];
	}

	/**
	 * check what kind of line current line is possible options: 1. comment line
	 * 2. start of action block 3. start of filter block 4. start of order block
	 * 5. other . consider this option as the data of the current block
	 * 
	 * @param firstWordInLine
	 * @param words
	 * @return index that points what kind of block is it
	 * 
	 */

	// TODO now this works on loop and return the index of the word. but maybe
	// this will change for three if statement

	private int whatKindOfLineIsIt(String firstWordInLine, String[] words) {
		int i = 0;
		// scan for known words
		while ((i < words.length)
				&& (firstWordInLine.compareTo(words[i]) != INT_STR_MATCH)) {
			i++;

		}
		// return index of known words. if not found return words.length(1based)
		return i;
	}

	/**
	 * this function scans for blocks in scripts and try to create each related
	 * object for each block with the related data which means. this scans for
	 * "ACTION","FILTER" and "ORDER" in the entered buffer
	 * 
	 * @param buffer
	 *            = script buffer
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ParsingException
	 */
	private void scanForBlocksInScript(String buffer) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		// use scanner to check for new lines in files. easier this wy
		Scanner scn = new Scanner(buffer);
		// make sure scanner check for new line and not new words
		scn.useDelimiter(System.getProperty("line.separator"));

		// get first line in file
		// cannot be %. this is the rules

		String currentLine = scn.next();
		int currentLineType = whatKindOfLineIsIt(getFirstWord(currentLine),
				SaveWords);
		int currentBlockType = currentLineType;

		String currentBlockBuffer = ""; // Collect block data

		while (scn.hasNext()) {
			currentLine = scn.next();
			currentLineType = whatKindOfLineIsIt(getFirstWord(currentLine),
					SaveWords);
			if (currentLineType != LINE_TYPE_COMMENT) {

				// this means we still at the same block
				if ((currentLineType >= SaveWords.length)) {
					// add this line to the block
					currentBlockBuffer = currentBlockBuffer + " " + currentLine;
				} else {

					// its time to create new block

					// so now we do
					// 1.try to create last block
					// 2.start collecting info on the new block

					createNewObject(currentBlockType, currentBlockBuffer);
					currentBlockBuffer = ""; // empty last block
					currentBlockType = currentLineType;

				}

			}
		}// while

		// create last block object
		createNewObject(currentBlockType, currentBlockBuffer);

		System.out.println();
	}

	private boolean createNewObject(int objectType, String buffer)
			throws ParsingException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException {

		//TODO maybe the parser blow, e.g"parseFilter" can be here 
		//TODO and not in different method
		switch (objectType) {
		case LINE_TYPE_ACTION_START:
			parseAction(buffer.split(" "));
			break;
		case LINE_TYPE_FILTER_START:
			parseFilter(buffer.split(" "));
			break;
		case LINE_TYPE_ORDER_START:
			
			parseOrder(buffer.split(" "));
			break;
		default:
		}

		// let the user know what are the results

		System.out.println("new buffer  - type " + SaveWords[objectType] + " "
				+ objectType);
		System.out.println(buffer);
		return true;
	}
	

	public Command[] parseFile(String fileString) {
		
			try {
				String fileBuffer ="FILTER GREATER_";// fileFunctions.readFileAsString(fileString);
			
				scanForBlocksInScript(fileBuffer);
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
			} finally {
	
			}
			System.out.println("adfa");
			return null;
		} 
	

	
	void parseCommanrd() {
	}


	
	
	//TODO note: the 3 methods parse* are very similar maybe its better to combine them together
	//TODO this fuction will return array of commands
	void parseAction(String[] buffer) throws ParsingException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException {

		// TODO add try and catch
		System.out.println("parseAction - begin");
		int i;
		String[] currentWord;
		String param;
		for (i = 0; i < buffer.length; i++) {

			currentWord = buffer[i].split("_");
			//check if this word or new line 
			if (currentWord[0].length() >= 1) {

				// does this filter has a param?
				if (currentWord.length == 1)
					param = null;
				else
					param = currentWord[1];
				
				System.out.println(currentWord[0]);
				//try to create this filter from Factory
				ActionFactory.actionFactory(currentWord[0], param);
			}
		}
		System.out.println("parseAction - end");


		
		
		try {
			new GreaterFilter("1234");
		} catch (ParsingException e) {
			System.out.println(e.getMessage());
		}
	}
/**this function parse filter block parameters and creates
 * for each one of them the right object
 *
 * 
 * @param buffer
 * @throws ParsingException
 * @throws IllegalArgumentException
 * @throws SecurityException
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 */
	//TODO this function will return an array of commands
	//TOOD so the method "parseFile" will be able to collect it 
void parseFilter(String[] buffer) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		
	//TODO if buffer is empty do something 
	
	
		// TODO add try and catch
		System.out.println("parseFilter - begin");
		int i;
		String[] currentWord;
		String param;
		for (i = 0; i < buffer.length; i++) {

			currentWord = buffer[i].split("_");
			//check if this word or new line 
			if (currentWord[0].length() >= 1) {

				// does this filter has a param?
				if (currentWord.length == 1)
					param = null;
				else
					param = currentWord[1];
				
				System.out.println(currentWord[0]);
				//try to create this filter from Factory
				FilterFactory.filterFactory(currentWord[0], param);
			}
		}
		System.out.println("parseFilter - end");

	}
	//TODO its allmost as same as the method above . so maybe its better to combine them
	void parseOrder(String[] buffer) throws ParsingException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException {
	
		//TODO if buffer is empty do ABS order
		// TODO add try and catch
		System.out.println("parseOrder - begin");
		int i;
		String[] currentWord;
		String param;
		for (i = 0; i < buffer.length; i++) {

			currentWord = buffer[i].split("_");
			//check if this word or new line 
			if (currentWord[0].length() >= 1) {

				// does this filter has a param?
				if (currentWord.length == 1)
					param = null;
				else
					param = currentWord[1];
				
				System.out.println(currentWord[0]);
				//try to create this filter from Factory
				OrderFactory.orderFactory(currentWord[0], param);
			}
		}
		System.out.println("parseOrder - end");

	}
}
