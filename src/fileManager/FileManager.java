package fileManager;
import java.io.File;
import java.util.*;
import java.io.IOException;
import orders.AbsOrder;

/**
 * Data sturucture for contating all the files sorted
 *
 */
public class FileManager {
	
	private List<String> _allFiles;
	private TreeSet <FileElement> _tree;
	private String _dirName; 
	
	/**
	 * reset the file manager: get all the files from the given directory
	 */
	public void reset()
	{
		File dir = new File(_dirName);
		_allFiles = getAllFiles(dir);
		for (Iterator <String> i1 = _allFiles.iterator(); i1.hasNext() ;)
		{
			String st = i1.next();
			FileElement newFileElement = new FileElement(st, null);
			_tree.add(newFileElement);
		}
	}
	
	/**
	 * get all the files in a directory
	 * @param f the directory
	 * @return array list with all the files
	 */
	private ArrayList<String> getAllFiles(File f)
	{
		
		ArrayList<String> filesList = new ArrayList<String>();
		File[] flist = f.listFiles();
		if (flist == null)
		{
			return filesList;
		}
		
		// iterating over all the files in the directory
		for (int i = 0; i < flist.length; i++ )
		{
			// if it is a directory, get all the files in it
			if (flist[i].isDirectory())
			{
				filesList.addAll(getAllFiles(flist[i]));
			}
			// else add the file to the list
			else
			{
				try
				{
					filesList.add(flist[i].getCanonicalPath());
				}
				catch (IOException e)
				{
					
				}
			}
		}
		return filesList;
	}
	
	/**
	 * Constructor from a directory 
	 * @param dirName the directory we run the script on all of its files
	 */
	public FileManager (String dirName)
	{
		
		_dirName = dirName;
		
		
		AbsOrder df = new AbsOrder();
		_tree = new TreeSet<FileElement> (df);
		
		// initializing the tree with the default comparator
		reset();
	}
	
	
	/**
	 * sort the files using a new comparator
	 * @param newCom the new comparator
	 */
	public void ChangeComparator(Comparator<FileElement> newCom)
	{
		if (newCom == null)
		{
			newCom = new AbsOrder();
		}
		TreeSet <FileElement> newTree = new TreeSet<FileElement> (newCom);
		for (Iterator <FileElement>i1 = _tree.iterator(); i1.hasNext() ;)
		{
			
			/* after replacing the comparator the data for 
			 * comparison needs to be changed
			 */
			FileElement el = new FileElement(i1.next());
			el.setData(null);
			newTree.add(el);
		}
		
		_tree = newTree;
	}
	
	/**
	 * get Iterator for the files
	 * @return iterator of the files
	 */
	public Iterator<FileElement> getFilesIterator()
	{
		return _tree.iterator();
	}
	

}
