package filters;

import java.util.List;



/**
 * 
 * or-operator of several filters
 *
 */
public class OrFilter extends BinaryOperatorFilter {


	public OrFilter(List<filter> filterList)
	{
		super(filterList);
	}
	
	/**
	 * the binary operation is or
	 */
	protected boolean binaryOperator(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		return b1 || b2;
	}

}
