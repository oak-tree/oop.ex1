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
	private boolean patternSearch(String text, String pattern)
	{
	    // split by the * symbol
	    String [] strings = pattern.split("\\*");
        
	    if(!text.startsWith(strings[0]))
	    {
	    	return false;
	    }
	    if(!pattern.endsWith("*") &&
	    		!text.endsWith(strings[strings.length - 1]))
	    {
	    	return false;
	    }
	    // look for all of the cards
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
	
	public boolean isFileFilterd(File f)
	{
		return returnResult(patternSearch(f.getName(), _pattern));
	}


}
