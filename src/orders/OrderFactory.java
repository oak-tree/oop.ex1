package orders;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import myFileScriptExceptions.*;
/**
 * this class is the factory of orders. it uses maphash to check for saved
 * words and create the object related to them
 * @author oak
 *
 */
public abstract  class OrderFactory  {
	   
	
	@SuppressWarnings("unchecked")
	    private static final HashMap<String, Class> ORDER_TABLE =
	        new HashMap<String, Class>() { 
	        private static final long serialVersionUID = 1L;

	        {
	            try {
	            	put("",AbsOrder.class);//empty order act same as ABS
	            			
	                put("ABS",
	                		AbsOrder.class);
	                put("FILE",
	                		FileOrder.class);
	                put("MOD",
	                		ModOrder.class);
	                put("SIZE",
	                		SizeOrder.class);
	                
	              
	            } catch (Exception e) {
	                throw new RuntimeException("unknown error", e);
	            }

	        }
	    };
	  
	    
	    /**
	     * The function is a factory to create ORDERs.
	     * the function receive the ORDER name and its parameter and return
	     * a matching ORDER with the given parameter
	     * @param ORDER the name of the ORDER 
	     * @param param the parameter of the ORDER
	     * @return the filter object initialized with the parameter
	     * @throws InvocationTargetException 
	     * @throws IllegalAccessException 
	     * @throws InstantiationException 
	     * @throws SecurityException 
	     * @throws IllegalArgumentException 
	     * @throws InvalidFilterParameterException if the filter parameters ware wrong
	     * @throws UnsupportedFilterExK,V>

java.lang.Object
ception if the filter name is not defined
	     */
	    public static order orderFactory(String order) 
	    throws ParsingException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException {
	        if (!ORDER_TABLE.containsKey(order)) {
	           //TODO //throw new UnsupportedFilterException();
	        }
	    //TODO add try and catch and throw some exepction    
	            return (order) (ORDER_TABLE.get(order).
	                    getConstructors()[0].newInstance());
	        	       
	       
	    
	    
	
	    }
}


