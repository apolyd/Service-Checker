package serviceChecker;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextPane;

class checkerThread extends Thread {
	   private Thread t;
	   private String threadName;
	   private String serviceName;
	   private JTextPane JTextPane;
	   
	   checkerThread( String name, String serviceName, JTextPane JTextPane) {
	      threadName = name;
	      this.serviceName = serviceName;
	      this.JTextPane = JTextPane;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      int flag = 0;
	      int loop = 0;
	      while(loop!=1) {
	      try {
	    	flag = 0;
	        final Process process = Runtime.getRuntime().exec("sc query "+serviceName);
	  	    final Scanner reader = new Scanner(process.getInputStream(), "UTF-8");
	  	    while(reader.hasNextLine()) {
	  	        if(reader.nextLine().startsWith("        STATE              : 4  RUNNING")) {
	  	        	
	  	        	System.out.println("to vrika to "+serviceName);
	  	        	flag=1;
	  	        	JTextPane.setText("Running");
	  	        	break;
	  	        	
	  	        }
	  	    }
	  	    if(flag==0) {
	  	    	 
	  	    	 JTextPane.setText("Trying to start..."); 
	  	    	 final Process processStart = Runtime.getRuntime().exec("sc start "+serviceName);
	  	         System.out.println("prospathisa gia ekinisi sto "+serviceName);
	  	         final Scanner readerStatus = new Scanner(processStart.getInputStream(), "UTF-8");
	  	         while(readerStatus.hasNextLine()) {
		  	        if(readerStatus.nextLine().startsWith("        STATE              : 4  RUNNING")) {
		  	        	System.out.println("to vrika to meta to start "+serviceName);
		  	        	JTextPane.setText("Running");
		  	        	JTextPane.validate();
		  	        	flag = 0;
		  	        	break;
		  	        }
		  	        }
	  	         readerStatus.close();
	  	         
	  	    }
	  	    
	  	    reader.close();
	  	    
	    	  
	   			
	   		
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}