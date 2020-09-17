package serviceChecker;

import java.util.Scanner;

public class cheker {
	public boolean isProcessRunning(final String processName) throws Exception{
	    final Process process = Runtime.getRuntime().exec("sc query "+processName);
	    final Scanner reader = new Scanner(process.getInputStream(), "UTF-8");
	    while(reader.hasNextLine())
	        if(reader.nextLine().startsWith("        STATE              : 4  RUNNING")) {
	        	
	        	System.out.println("to vrika");
	        	return true;
	        	
	        }
	            
	    
	    reader.close();
	    return false;
	}
}
