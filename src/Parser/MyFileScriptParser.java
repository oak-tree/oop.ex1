package Parser;
import java.io.IOException;
import java.util.Scanner;

import commands.*;
import filters.*;
import Exceptions.*;
public class MyFileScriptParser {
	
	
	
	private final static String[] SaveWords = {"%","ACTION","FILTER","ORDER",};
//	private final static int[] 
	private final static String LINE_STR_ORDER_COMMENT="%";
	private final static String LINE_STR_FILTER_START="FILTER";
	private final static String LINE_STR_ACTION_START="ACTION";
	private final static String LINE_STR_ORDER_START="ORDER";

	
	private final static int LINE_TYPE_COMMENT = 0;
	private final static int LINE_TYPE_ACTION_START = LINE_TYPE_COMMENT+1;
	private final static int LINE_TYPE_FILTER_START = LINE_TYPE_ACTION_START+1;
	private final static int LINE_TYPE_ORDER_START = LINE_TYPE_FILTER_START+1;
	private final static int LINE_TYPE_OTHER=LINE_TYPE_ORDER_START +1;//saveWords.length
	
	private final static int INT_STR_MATCH=0;
	
	/**
	 * 
	 * @param buffer
	 * @param words
	 * @return
	 */
	private  boolean parseFilterBlock(String[] buffer,String[] words){
		
		int j = 0,i=0;
		String param;
		// go thru all words in buffer. check if each one of them is known
		String[] currentWord=buffer[i].split("_");
		for (i=0;i<buffer.length;i++) {
			currentWord=buffer[i].split("_");
			if (currentWord.length==1)
				param=null;
			else
				param=currentWord[1];
	//	getObjectBySaveWord(currentWord[0],param).getSaveWord();
		
		}	
		return true;
	}
	
	
	
	/**
	 * get first word in line 
	 * @param line
	 * @return
	 */
	//TODO insert error checking 
	private static String getFirstWord(String line){
		return line.split(" ")[0];
		}
		
	/**
	 * check what kind of line current line is 
	 * possible options: 
	 * 		1. comment line 
	 * 		2. start of action block
	 * 		3. start of filter block
	 * 		4. start of order  block
	 * 		5. other . consider this option as the data of the current block
	 * 
	 * @param firstWordInLine
	 * @param words
	 * @return index that points what kind of block  is it 
	 * 
	 */
	
	//TODO now this works on loop and return the index of the word. but maybe this will change for three if statement 
	
	private  int whatKindOfLineIsIt(String firstWordInLine,String[] words){
			
			
				int i=0;
				//scan for known words
				while ((i< words.length) && (firstWordInLine.compareTo(words[i])!=INT_STR_MATCH)){
					 	i++;
						
				}
				//return index of known words. if not found return words.length(1based)
				return i;
		}
	
	/**
	 * this function scans for blocks in scripts and 
	 * try to create each related object
	 * for each block with the related data
	 * which means. this scans for "ACTION","FILTER" and "ORDER" 
	 * in the entered buffer
	 * 
	 * @param buffer = script buffer
	 */
	private void  scanForBlocksInScript(String buffer) {
				
		   
		   // use scanner to check for new lines in files. easier this wy 
		   Scanner scn = new Scanner(buffer);
		   // make sure scanner check for new line and not new words
		   scn.useDelimiter
	         (System.getProperty("line.separator"));
		  

		   
		   // get first line in file
		   // cannot be %. this is the rules
		   

		   String  currentLine=scn.next();
		   int    currentLineType=whatKindOfLineIsIt(getFirstWord(currentLine),SaveWords);
		   int currentBlockType=currentLineType;
		
		   
		   String currentBlockBuffer=""; //Collect block data
	
		   while(scn.hasNext()) {
			   currentLine=scn.next();
			   currentLineType=whatKindOfLineIsIt(getFirstWord(currentLine),SaveWords);
			   if (currentLineType!=LINE_TYPE_COMMENT) {
				   
			       		//this means we still at the same block 
			   			if ((currentLineType>=SaveWords.length))	{
			   			//add this line to the block
			   				currentBlockBuffer=currentBlockBuffer+ " " + currentLine;
			   			}
			   			else {

			   				//its time to create new block

			   				//so now we do 
				   			//1.try to create  last block 
				   			//2.start collecting info on the new block

			   				createNewObject(currentBlockType,currentBlockBuffer);
			   				currentBlockBuffer=""; //empty last block 
			   				currentBlockType=currentLineType;
			   				
			   					
	
			   			}
		
			   			 
			   }
		   }//while
		   
		   
		   //create last block object
		   createNewObject(currentBlockType,currentBlockBuffer);
					   
			   
		   System.out.println();
		   }
		   	
	


	private  boolean createNewObject(int objectType,String buffer){
		
		switch (objectType){
		case LINE_TYPE_ACTION_START:
		break;
		case LINE_TYPE_FILTER_START:
			parseFilterBlock(buffer.split(" "),SaveWords);
		break;
		case LINE_TYPE_ORDER_START:
		break;
		default:
		}
		
		
		//let the user know what are the results
		  
		System.out.println("new buffer  - type " + SaveWords[objectType] + " " + objectType);
		System.out.println(buffer);
		return true;
	}
	
	
	public Command[] parseFile(String fileString)
	{
		try {
		String fileBuffer = fileFunctions.readFileAsString(fileString);
		  scanForBlocksInScript(fileBuffer);
			 System.out.println("adfa");
		return null;
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			return null;	
		}
		
	}
	void parseCommanrd() {}
	
	void parseAction(String filterType,String filterParam) 
	{
		
		
		
		try {
			new GreaterFilter();
		}
		catch (ParsingException e)
		{
			System.out.println(e.getMessage());
		}
	}
	void parseFilter() {}
	void parseOrder() {}
}
