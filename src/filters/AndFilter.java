package filters;
import java.util.List;

/**
 * 
 * And-connection of number of filters
 *
 */
public class AndFilter extends BinaryOperatorFilter {

	
	public AndFilter(List <filter> filterList)
	{
		super(filterList);
		_defaultValue = true;
	}
	
	/**
	 * the binary operation is and
	 */
	protected boolean binaryOperator(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		return b1 && b2;
	}

}
