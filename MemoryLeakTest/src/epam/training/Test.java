package epam.training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test {


	public final static String fileName = "src/text.txt";
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		List<String> list = new ArrayList<String>();
		String line = null;
		BufferedReader bufferedReader = null;
		
		try {
				for (int i = 0; i < 500; i++)
				{   
					bufferedReader = new BufferedReader(new FileReader(fileName));
					while ((line = bufferedReader.readLine()) != null)
					{  
						list.add(line.substring(0, 3));
			    	}
					if (bufferedReader != null)
					{
						bufferedReader.close();
		       		}
				}   
		 
		}
		catch (FileNotFoundException e)
		{
             throw new IOException("File not found: " + fileName, e);
        }
		catch (IOException e)
        {
             throw new IOException("Unable to read file: " + fileName, e);
        } finally {
        	try {
        		  if (bufferedReader != null)
        		  {
        		      bufferedReader.close();
        		  }
        	} catch (IOException e)
        	{
        		 throw new IOException("Unable to close file: " + fileName, e);
            }
        }
	}
}


