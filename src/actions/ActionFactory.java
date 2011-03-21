package actions;




import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import myFileScriptExceptions.*;
/**
 * this class is the factory of actions. it uses maphash to check for saved
 * words and create the object related to them
 * @author oak
 *
 */
public abstract  class ActionFactory {
	   
	
	@SuppressWarnings("unchecked")
	    private static final HashMap<String, Class> ACTION_TABLE =
	        new HashMap<String, Class>() { 
	        private static final long serialVersionUID = 1L;

	        {
	        
	            try {
	                put("COPY",
	                		CopyAction.class);
	                put("EXEC",
	        	        	ExecAction.class);
	                put("MOVE",
	                		MoveAction.class);
	                put("PRINT",
	                		PrintAction.class);
	                put("READ",
	                		ReadAction.class);
	                put("REMOVE",
	                		RemoveAction.class);
	                put("WRITE",
	                		WriteAction.class);
	               
	                
	              
	            } catch (Exception e) {
	                throw new RuntimeException("unknown error", e);
	            }

	        }
	    };
	  
	    
	    /**
	     * The function is a factory to create action.
	     * the function receive the filter name and its parameter and return
	     * a matching filter with the given parameter
	     * 
	     * @param filter the name of the filter 
	     * @param param the parameter of the filter
	     * @return the filter object initialized with the parameter
	     * @throws InvocationTargetException 
	     * @throws IllegalAccessException 
	     * @throws InstantiationException 
	     * @throws SecurityException 
	     * @throws IllegalArgumentException 
	     * @throws InvalidFilterParameterException if the filter parameters ware wrong
	     * @throws UnsupportedFilterException if the filter name is not defined
	     */
	    public static Action actionFactory(String action , String param) 
	    throws ParsingException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException {
	        if (!ACTION_TABLE.containsKey(action)) {
	           //TODO //throw new UnsupportedFilterException();
	        }
	    //TODO add try and catch and throw some exepction    
	            return (Action) (ACTION_TABLE.get(action).
	                    getConstructors()[0].newInstance(param));
	        	       
	       
	    
	    
	
	    }
}



