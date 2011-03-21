package fileManager;
import java.util.*;


public class FileManager {
	
	List<String> _allFiles;
	TreeSet <String> _tree;
	
	public void reset()
	{
		for (Iterator <String>i1 = _allFiles.iterator(); i1.hasNext() ;)
		{
			String st = i1.next();
			_tree.add(st);
		}
	}
	public FileManager (List <String> files)
	{
		_allFiles = files;
		
		_tree = new TreeSet<String> (String.CASE_INSENSITIVE_ORDER);
		
		// initializing the tree with the default comparator
		reset();
	}
	
	public void ChangeComparator(Comparator newCom)
	{
		_tree = new TreeSet<String> (newCom);
		for (Iterator <String>i1 = _tree.iterator(); i1.hasNext() ;)
		{
			String st = i1.next();
			_tree.add(st);
		}
	}

}
