package filters;
import java.util.List;
public abstract class BinaryOperatorFilter extends filter {


	private List <filter> _filterList;
	abstract protected boolean binaryOperator(boolean b1, boolean b2); 
	

}
