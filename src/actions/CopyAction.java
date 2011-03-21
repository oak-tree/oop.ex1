package actions;

import java.io.*;

public class CopyAction extends Action {

	private String _dirName;
	public CopyAction(String param){
		_dirName = param;
	}

	
	protected void performAction(File f)
	{
		File outFileDir = new File (_dirName);
		if (!outFileDir.exists())
		{
			outFileDir.mkdirs();
		}
		
		File outFile = new File (_dirName + f.getName());
		try
		{
			InputStream in = new FileInputStream(f);
			OutputStream out = new FileOutputStream(outFile);
			byte[] buf = new byte[1024];
		    int len;
		    while ((len = in.read(buf)) > 0){
		        out.write(buf, 0, len);
		    }
		    in.close();
		    out.close();
		}
		catch(FileNotFoundException ex){
			System.out.println(ex.getMessage() + " in the specified directory.");
		    System.exit(0);
		}
		catch(IOException e){
		    System.out.println(e.getMessage());      
		}
		
	}

}
