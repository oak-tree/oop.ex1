package filters;

import java.util.List;

import commands.Command;

public class OrFilter extends BinaryOperatorFilter {


	public OrFilter(List<filter> filterList)
	{
		super(filterList);
	}
	protected boolean binaryOperator(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		return b1 || b2;
	}

}
