package fileManager;

public class FileElement{
	private String _fileName;
	private Object _data;
	public FileElement(String fName, Object data)
	{
		_fileName = fName;
		_data = data;

	}
	
	public FileElement(FileElement other)
	{
		_fileName = other._fileName;
		_data = other._data;
	}
	
	
	public Object getData()
	{
		return _data;
	}
	
	public void setData(Object data)
	{
		_data = data;
	}
	
	public void reset()
	
	{
		_data = null;
	}
	
	public String getFileName()
	{
		return _fileName;
	}
}
