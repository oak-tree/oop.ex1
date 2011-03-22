package filters;
import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import myFileScriptExceptions.*;

/**
 * this class is the factory of filters. it uses maphash to check for saved
 * words and create the object related to them
 * 
 * @author oak
 * 
 */
public abstract class FilterFactory {

	@SuppressWarnings("unchecked")
	private static final HashMap<String, Class> FILTER_TABLE = new HashMap<String, Class>() {
		private static final long serialVersionUID = 1L;

		{
			try {
				put("AFTER", AfterFilter.class);
				put("BEFORE", BeforeFilter.class);
				put("GREATER", GreaterFilter.class);
				put("SMALLER", SmallerFilter.class);
				put("FILE", FileFilter.class);
				put("READABLE", ReadableFilter.class);
				put("WRITEABLE", WriteableFilter.class);
				put("EXECUTABLE", ExecutableFilter.class);


			} catch (Exception e) {
				throw new RuntimeException("unknown error", e);
			}

		}
	};


	/**
	 * /** The function is a factory to create filters. the function receive the
	 * filter name and its parameter and return a matching filter with the given
	 * parameter
	 * 
	 * @param filter
	 *            the name of the filter
	 * @param param
	 *            the parameter of the filter
	 * @return the filter object initialized with the parameter
	 * @param filter
	 * @param param
	 * @return
	 * @throws UnkownFilterException if 'filter' contains unknown filter
	 * @throws BadParametersException if param filter are wrong
	 */
	public static filter filterFactory(String filter, ArrayList<String> param)
			throws UnkownFilterException, BadParametersException {

		if (!FILTER_TABLE.containsKey(filter)) {
			throw new UnkownFilterException("unkown filter");
		}

		try {
			return (filter) (FILTER_TABLE.get(filter).getConstructors()[0]
					.newInstance(param));

		} catch (InvocationTargetException e) {
			throw (BadParametersException) e.getCause();
		} catch (Exception e) {
			// reflection exception should never happen
			throw new RuntimeException("unknown error", e);
		}

	}
}
