package filters;
import java.util.List;

import commands.Command;

public class AndFilter extends BinaryOperatorFilter {

	
	//public AndFilter(List <command> filterList)
	public AndFilter(List <filter> filterList)
	{
		super(filterList);
		_defaultValue = true;
	}
	protected boolean binaryOperator(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		return b1 && b2;
	}

}
