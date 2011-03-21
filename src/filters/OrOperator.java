package filters;

import java.util.List;

import commands.Command;

public class OrOperator extends BinaryOperatorFilter {


	public OrOperator(List<filter> filterList) {
		super(filterList);
		// TODO Auto-generated constructor stub
	}

	protected boolean binaryOperator(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		return b1 || b2;
	}

}
