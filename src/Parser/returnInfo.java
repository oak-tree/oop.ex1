package Parser;

public class returnInfo {

	Object _object;
	int _newBlock;

	public returnInfo(Object obj, int newBlock) {
		_newBlock = newBlock;
		_object = obj;
	}

	public Object getObject() {
		return _object;

	}

	public int getNewBlock() {
		return _newBlock;
	}
}
