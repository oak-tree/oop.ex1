package filters;

import java.io.File;
import java.util.ArrayList;

public class FileFilter extends filter {
	
	String _pattern;
	FileFilter(ArrayList<String> param)
	{
		//TODO  change it 
	_pattern = param.get(0);
	}
	private boolean patternSearch(String text, String pattern)
	{
	    // split by the * symbol
	    String [] strings = pattern.split("\\*");
        
	    
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
		return patternSearch(f.getName(), _pattern);
	}


}
