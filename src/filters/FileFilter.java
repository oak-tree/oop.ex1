package filters;

import java.io.File;
import java.util.ArrayList;

public class FileFilter extends filter {
	
	String _pattern;
	public FileFilter(ArrayList<String> param)
	{
		super(param);
		_pattern = param.get(0);
	}
	
	/**
	 * Checks if the file contains the pattern we look for where * can be interpreted  
	 * by as many chars as needed
	 * @param text the string we look in
	 * @param pattern the pattern we look for
	 * @return whether the pattern was found
	 */
	private boolean patternSearch(String text, String pattern)
	{
	    // split by the * symbol
	    String [] strings = pattern.split("\\*");
        
	    if (strings.length == 0)
	    {
	    	return true;
	    }
	    
	    // checks to see that the name begins with the first part of the pattern
	    if(!text.startsWith(strings[0]))
	    {
	    	return false;
	    }
	    
	    // checks if the filename ends with the end of the pattern
	    if(!pattern.endsWith("*") &&
	    		!text.endsWith(strings[strings.length - 1]))
	    {
	    	return false;
	    }

	    // look for all of the parts of the pattern
	    for (String str : strings)
	    {
	    	int index = text.indexOf(str);
	    	
	    	if(index == -1)
	    	{
	    		return false;
	    	}
	    	
	    	
	    	text = text.substring(index + str.length());
	    }
	    
	    
	        
	    return true;
	 }
	/**
	 * Checks if the filename contains the pattern we look for where * can be interpreted  
	 * by as many chars as needed
	 * @param f the file we look at his filename 
	 * 
	 * */
	public boolean isFileFilterd(File f)
	{
		return returnResult(patternSearch(f.getName(), _pattern));
	}


}
