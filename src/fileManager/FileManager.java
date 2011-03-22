package fileManager;
import java.io.File;
import java.util.*;
import java.io.IOException;



public class FileManager {
	
	private List<String> _allFiles;
	private TreeSet <FileElement> _tree;
	private String _dirName; 
	
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
	
	
	private ArrayList<String> getAllFiles(File f)
	{
		ArrayList<String> filesList = new ArrayList<String>();
		File[] flist = f.listFiles();
		if (flist == null)
		{
			return filesList;
		}
		for (int i = 0; i < flist.length; i++ )
		{
			if (flist[i].isDirectory())
			{
				filesList.addAll(getAllFiles(flist[i]));
			}
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
	public FileManager (String dirName)
	{
		
		_dirName = dirName;
		
		
		DefaultComparator df = new DefaultComparator();
		_tree = new TreeSet<FileElement> (df);
		
		// initializing the tree with the default comparator
		reset();
	}
	
	
	// sort the
	public void ChangeComparator(Comparator<FileElement> newCom)
	{
		if (newCom == null)
		{
			newCom = new DefaultComparator();
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
	
	public Iterator<FileElement> getFilesIterator()
	{
		return _tree.iterator();
	}
	

}
