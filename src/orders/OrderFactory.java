package orders;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import actions.Action;

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
	 * 
	 * The function is a factory to create ORDERs.
	 * the function receive the ORDER name and its parameter and return
	 * a matching ORDER with the given parameter
	 * @param ORDER the name of the ORDER 
	 * @param param the parameter of the ORDER
	 * @return the filter object initialized with the parameter
	 * @param order
	 * @return
	 * @throws UnkownActionException if action contains unknown action
	 */
	public static order orderFactory(String order) 
	throws UnkownOrderException {
		if (!ORDER_TABLE.containsKey(order)) {
			throw new UnkownOrderException("unkown order");
		}
		try {
			return (order) (ORDER_TABLE.get(order).
					getConstructors()[0].newInstance());
			
		} 

		catch (Exception e) {
			//reflection exception should never happen
			throw new RuntimeException("unknown error", e);
		}

	}
}


