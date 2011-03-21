package fileManager;

import java.util.Comparator;

public class FileElement{
	private String _fileName;
	private Comparable _data;
	public FileElement(String fName, Comparable data)
	{
		_fileName = fName;
		_data = data;

	}
	
	Comparable getData()
	{
		return _data;
	}
	
	void setData(Comparable data)
	{
		_data = data;
	}
}
