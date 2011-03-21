package Parser;

// dont have this file right now import myFileScriptExceptions.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import orders.OrderFactory;
import orders.order;
import myFileScriptExceptions.ParsingException;
import actions.Action;
import actions.ActionFactory;
import actions.SectionAction;

import commands.Command;

import filters.*;
import java.util.List;

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
	private List<Command> scanForBlocksInScript(String buffer)
			throws ParsingException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException {

		List<Command> commands = new ArrayList<Command>();
		List<Command> sectionCmd = new ArrayList<Command>();
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

					// sectionCmd.add(beginCreateNewSection(currentBlockType,currentLine));

					currentBlockBuffer = currentBlockBuffer + "\n"
							+ currentLine;

				} else {

					// its time to create new block

					// so now we do
					// 1.try to create last block
					// 2.start collecting info on the new block

					// create the section
					commands.add(createNewSecton(currentBlockType,
							currentBlockBuffer));

					// createNewObject(currentBlockType, currentBlockBuffer);

					currentBlockBuffer = ""; // empty last block
					currentBlockType = currentLineType;
					sectionCmd.clear();

				}

			}
		}// while

		// create last block object
		commands.add(createNewSecton(currentBlockType, currentBlockBuffer));

		return commands;
	}

	/**
	 * Separates command and param by the char "_"
	 * 
	 * @param buffer
	 * @return array of two string. [0] - holds command name [1] - param value.
	 *         null if no param.
	 * @exception raise
	 *                exepction if more than 1 parameter exists
	 */

	// TODO raise exepction
	// does this filter has a param?
	private String[] getObjectParam(String buffer) {
		String[] currentWord;

		currentWord = buffer.split("_");
		if (currentWord.length > 2) {
			// todo throw expection
			throw new ParsingException("bla");
		}
		// System.out.println("too much data");
		// return null; }
		else {

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
	 * creates new section according to section type
	 * 
	 * @param sectionType
	 *            integer. can hold 3 kinds of section
	 * @param buffer
	 *            string. holds section data
	 * @return Command
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws ParsingException
	 */
	private Command createNewSecton(int sectionType, String buffer)
			throws ParsingException, IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException {
		switch (sectionType) {

		case LINE_TYPE_ACTION_START:
			return new SectionAction(parseAction(buffer));
		case LINE_TYPE_FILTER_START:
			return new AndFilter(parseFilter(buffer));
		case LINE_TYPE_ORDER_START:
			return parseOrder(buffer);
		default:
			throw new ParsingException("bla");

			// TODO "error msg"
		}

	}

	private List<Action> parseAction(String buffer) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		System.out.println("Filter - Begin");
		Scanner scnLine = new Scanner(buffer);
		String currentWord;
		List<Action> filterList = new ArrayList<Action>();
		String[] params;

		while (scnLine.hasNext()) {
			currentWord = scnLine.next();
			System.out.println(currentWord);
			params = getObjectParam(currentWord);
			filterList.add(ActionFactory.actionFactory(params[0], params[1]));

		}

		return filterList;

	}

	/**
	 * this function parse filter block parameters and creates for each one of
	 * them the right object
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
	// TODO this function will return an array of commands
	// TOOD so the method "parseFile" will be able to collect it
	private List<filter> parseFilter(String buffer) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		System.out.println("Filter - Begin");
		Scanner scnLine = new Scanner(buffer);
		String currentLine;
		List<filter> filterList = new ArrayList<filter>();
		String[] params;

		while (scnLine.hasNext()) {
			currentLine = scnLine.next();
			System.out.println(currentLine);
			filterList.add(new OrFilter(parseFilterLine(currentLine)));
		}
		System.out.println("Filter - end");

		// TODO think on emtpy list. should take care of this as well
		// TODO if buffer is empty do something
		return filterList;

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

	private order parseOrder(String buffer) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		// TODO if buffer is empty do ABS order
		// TODO add try and catch

		System.out.println("parseOrder - begin");
		int i;
		String[] orderType;

		// this regex cuts new line and all whitespaces. but, always gives back
		// an empty string in orderType[0]
		orderType = buffer.split("\\s+");

		for (i = 0; i < orderType.length; i++) {
			System.out.println(orderType[i]);
		}

		if ((orderType == null) || (orderType.length == 1))
			return OrderFactory.orderFactory("ABS");
		else if (orderType.length > 2)
			throw new ParsingException("bla");
		else

			System.out.println("parseOrder - end");
		return OrderFactory.orderFactory(orderType[1]);

	}

	/**
	 * activate parser
	 * 
	 * @param fileString
	 *            file name + path
	 * @return list of commmands
	 * @throws ParsingException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */

	public List<Command> parseFile(String fileString) throws ParsingException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, IOException {
		String fileBuffer = fileFunctions.readFileAsString(fileString);
		return scanForBlocksInScript(fileBuffer);

	}
}