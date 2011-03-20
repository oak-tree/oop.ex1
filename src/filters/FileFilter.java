package filters;

public class FileFilter {
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


}
