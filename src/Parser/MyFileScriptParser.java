package Parser;

// dont have this file right now import myFileScriptExceptions.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.logging.Filter;
import java.util.regex.*;

import actions.Action;
import actions.ActionFactory;
import actions.SectionAction;

import orders.OrderFactory;
import orders.order; //import filters.FilterFactory;
//import filters.GreaterFilter;

import myFileScriptExceptions.ParsingException;

import filescript.Script;
import filters.AndFilter;
import filters.FilterFactory;
import filters.OrFilter;
import filters.filter;

public class MyFileScriptParser {

	private final static String[] SaveWords = { "%", "FILTER", "ACTION",
			"ORDER", };

	private final static int LINE_TYPE_COMMENT = 0;
	private final static int LINE_TYPE_FILTER = LINE_TYPE_COMMENT + 1;
	private final static int LINE_TYPE_ACTION = LINE_TYPE_FILTER + 1;
	private final static int LINE_TYPE_ORDER = LINE_TYPE_ACTION + 1;
	private final static int LINE_TYPE_OTHER = LINE_TYPE_ORDER + 1;// saveWords.length
	private final static int LINE_TYPE_EMPTY_LINE=-1;
	private final static int NO_MORE_LINES = -1;

	/**
	 * get object parameter. note: cannot have more than 1 parameter and doesnt
	 * have to have one at all
	 * 
	 * @param buffer
	 * @return array of two string. first cell holds commands name, 2nd cell
	 *         holds commmand's parameter
	 * @throws ParsingException
	 */
	private String[] getObjectParam(String buffer) {
		String[] currentWord;

		currentWord = buffer.split("_");
		if (currentWord.length > 2) {
			throw new ParsingException("Error");
		} else {

			String[] returnValue = new String[2];

			returnValue[0] = currentWord[0];
			if (currentWord.length == 1)
				returnValue[1] = null;
			else
				returnValue[1] = currentWord[1];

			return returnValue;
		}

	}

	/**
	 * gets first word in line - used for checking what kind of section is it
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
	 * check what kind of line is it. line can be 1."start of filter block"
	 * 2."start of action block" 3."start of order block" 4."other". which means
	 * inside data of one of the blocks
	 * 
	 * @param firstWord
	 * @param savewords2
	 * @return
	 */
	private final static int INT_STR_MATCH = 0;

	private int whatKindOfLineIsIt(String firstWord) {

		if (firstWord.length()==0) 
			return LINE_TYPE_EMPTY_LINE;
		int i = 0;
		// scan for known words
		while ((i < SaveWords.length)
				&& (firstWord.compareTo(SaveWords[i]) != INT_STR_MATCH)) {
			i++;

		}
		// return index of known words. if not found return words.length(1based)
		return i;

	}

	private final String DEFAULT_ORDER = "ABS";

	/**
	 * creates script for act,flt and ord act and flt must not be null. if
	 * ord=null. creates default order
	 * 
	 * @param act
	 * @param flt
	 * @param ord
	 * @return Script
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ParsingException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ParsingException
	 */
	private Script createNewScript(Action act, filter flt, order ord)
			throws ParsingException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException {

		if ((act == null) || (flt == null)) {
			throw new ParsingException("Error");
		}

		if (ord == null) {
			ord = OrderFactory.orderFactory(DEFAULT_ORDER);
		}
		return new Script(act, flt, ord);

	}

	/**
	 * try to find one script
	 * 
	 * 
	 * @param scriptBuffer
	 * @return
	 */
	private final int NEW_SCRIPT = -1;

	private Script praseScript(Scanner scn) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		int currentLineType;
		String currentLine;
		int lastBlock = NEW_SCRIPT;
		int currentBlock;

		boolean scriptEnd = false;

		filter thisFilter = null;
		SectionAction thisAction = null;
		order thisOrder = null;

		currentLine = scn.next();
		currentLineType = whatKindOfLineIsIt(getFirstWord(currentLine));
		returnInfo retInfo = null;
		
		while ((scn.hasNext()) &&(scriptEnd==false)) {

			

				switch (currentLineType) {
				case LINE_TYPE_COMMENT:
				case LINE_TYPE_EMPTY_LINE:
					currentLine = scn.next();
					currentLineType = whatKindOfLineIsIt(getFirstWord(currentLine));
					break;

				case LINE_TYPE_FILTER:
					/*
					 * this section must exists,must be first. can be empty in
					 * here we do: 1.check if this new script. which means last
					 * block was order or action 2.otherwise parse section
					 */

					if (lastBlock == NEW_SCRIPT) {
						retInfo = praseFilter(scn);
						thisFilter = (filter) retInfo.getObject();
						
						lastBlock = LINE_TYPE_FILTER;
					} else
						scriptEnd = true;
					break;

				case LINE_TYPE_ACTION:
					/*
					 * this section must exists, must come after filter. cannot
					 * be empty
					 * 
					 * in here we do: 1.check if last section was filter 2.prase
					 * section 3.check if section isnot empty
					 */
					if (lastBlock == LINE_TYPE_FILTER) {
						retInfo=praseAction(scn);
						thisAction = (SectionAction)retInfo.getObject();
						if (thisAction.isEmpty()) {
							throw new ParsingException("Error");
						}

						lastBlock = LINE_TYPE_ACTION;
					} else {
						throw new ParsingException("Error");
					}

					break;

				case LINE_TYPE_ORDER:
					/*
					 * this section ends this script for sure.must come after
					 * action note: this section does not have to be at all
					 * 
					 * 
					 * in here we do: 1.check if last section was action 2.prase
					 * section(cannot have more than 1 command) 3.finish parsing
					 * this script
					 */

					if (lastBlock == LINE_TYPE_ACTION) {
						retInfo =praseOrder(scn);
						thisOrder = (order) retInfo.getObject();
						scriptEnd = true;
					} else {
						throw new ParsingException("Error");
					}

					break;

				default:

					throw new ParsingException("Error");
				}
				
				currentLineType=retInfo.getNewBlock();
		
		} // while

		// TODO if order is empty
		return createNewScript(thisAction, thisFilter, thisOrder);
	}

	private returnInfo praseOrder(Scanner scn) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		System.out.println("parseOrder - begin");
		/*
		 * get first word. check if its one of the saved`s words insert it to
		 * factory. if there are more words error will raise later in code
		 */
		System.out.println("parseOrder - end");

		String currentLine = scn.next();
		int lineType = NO_MORE_LINES;
		
		

		while (scn.hasNext()) {
		
			currentLine = scn.next();
			lineType = whatKindOfLineIsIt(currentLine);
			if ((lineType != LINE_TYPE_COMMENT)  || (lineType!=LINE_TYPE_EMPTY_LINE)) {
				if (lineType < LINE_TYPE_OTHER) {
					break; // found next block
				}
				else
					
					System.out.println(currentLine);
					break;
				}
			}// while

		return new returnInfo(OrderFactory.orderFactory(currentLine), lineType);
	}
	


	private returnInfo praseAction(Scanner scn) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		System.out.println("Filter - Begin");

		String currentLine;
		List<Action> actionList = new ArrayList<Action>();
		String[] params;
		int lineType = NO_MORE_LINES;
		boolean allowMoreCommand = true;

		while (scn.hasNext()) {

			if (allowMoreCommand == false) {
				// this means last command was
				// "MOVE REMOVE - dont allow more commands"
				throw new ParsingException("bla");
			}
			currentLine = scn.next();
			lineType = whatKindOfLineIsIt(currentLine);
			if ((lineType != LINE_TYPE_COMMENT)  || (lineType!=LINE_TYPE_EMPTY_LINE)) {
				if (lineType < LINE_TYPE_OTHER)
					break; // found next block
				else
				{
					System.out.println(currentLine);
				params = getObjectParam(currentLine);
				Action newAction = ActionFactory.actionFactory(params[0],
						params[1]);
				actionList.add(newAction);
				
				if (newAction.isLastCommand()) {
					allowMoreCommand = false;
				}
				}
			}

		}// while
		return new returnInfo(new SectionAction(actionList), lineType);

	}

	private returnInfo praseFilter(Scanner scn) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		List<filter> filterList = new ArrayList<filter>();

		System.out.println("Filter - Begin");
		String currentLine;
		String[] params;
		int lineType = NO_MORE_LINES;
		// still search by line
		while (scn.hasNext()) {
			currentLine = scn.next();
			System.out.println(currentLine);
			lineType = whatKindOfLineIsIt(currentLine);
			if ((lineType != LINE_TYPE_COMMENT)  || (lineType!=LINE_TYPE_EMPTY_LINE)) {
				if (lineType < LINE_TYPE_OTHER)
					break; // found new section
				else
					filterList.add(new OrFilter(parseFilterLine(currentLine)));
			}
		}
		System.out.println("Filter - end");

		// TODO think on emtpy list. should take care of this as well
		// TODO if buffer is empty do something
		return new returnInfo(new AndFilter(filterList), lineType);

	}

	private List<filter> parseFilterLine(String Line) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		List<filter> filterList = new ArrayList<filter>();
		String[] wordsInLine = Line.split(" ");
		String[] params;
		int i;
		for (i = 0; i < wordsInLine.length; i++) {

			params = getObjectParam(wordsInLine[i]);
			filterList.add(FilterFactory.filterFactory(params[0], params[1]));

		} // for
		return filterList;
	}

	/**
	 * scans for script`s block in buffer
	 * 
	 * @param fileBuffer
	 * @return List. all scripts that have been found
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ParsingException
	 */
	private List<Script> scanForScriptsInBuffer(String fileBuffer)
			throws ParsingException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException {

		List<Script> scripts = new ArrayList<Script>();

		Scanner scn = new Scanner(fileBuffer);

		// make sure scanner check for new line and not new words
		scn.useDelimiter(System.getProperty("line.separator"));

		while (scn.hasNext()) {
			scripts.add(praseScript(scn));
		}

		return scripts;

	}

	/**
	 * start parse. create buffer of file and then it scans for scripts
	 * 
	 * @param fileString
	 * @return List. all scripts that found in file
	 * @throws ParsingException
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public List<Script> parseFile(String fileString) throws ParsingException,
			IOException, IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		String fileBuffer = fileFunctions.readFileAsString(fileString);
		return scanForScriptsInBuffer(fileBuffer);
		// return scanForBlocksInScript(fileBuffer);

	}
}
