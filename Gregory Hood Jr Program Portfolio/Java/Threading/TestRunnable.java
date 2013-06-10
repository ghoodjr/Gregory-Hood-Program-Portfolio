/*
		Description: 	Test Runnable Synchronize Multithreads Printing
		Programmer:  	Gregory Hood Jr
		Program Name:	TestRunnable
		Course Name:	COSC 420
		Date:				April 18, 2013
	*/


// TestRunnable.java: Define threads using the Runnable interface
//package chapter18;

   public class TestRunnable 
   {
   /** Main method */
      public static void main(String[] args) 
      {
         new TestRunnable();
      }
   
   /** Default constructor */
      public TestRunnable() 
      {
      // Create threads
         Thread print100 = new Thread(new PrintNum(100));
      
      // Start threads
         print100.start();
      
      }
   
   // The thread class for printing a specified character
   // in specified times
      class PrintChar implements Runnable 
      {
         private char charToPrint;  // The character to print
         private int times;  // The times to repeat
      
      /** Construct a thread with specified character and number of
       times to print the character
      */
         public PrintChar(char c, int t) 
         {
            charToPrint = c;
            times = t;
         }
      
      /** Override the run() method to tell the system
       what the thread will do
      */
         public void run() 
         {
            for (int i = 0; i < times; i++)
               System.out.print(charToPrint);
            System.out.println();
         }
      }
   
   // The thread class for printing number from 1 to n for a given n
      class PrintNum implements Runnable 
      {
         private int lastNum;
      
      /** Construct a thread for print 1, 2, ... i */
         public PrintNum(int n) 
         {
            lastNum = n;
         }
      
      /** Tell the thread how to run */
         public void run() 
         {
            printNum(lastNum);
         }
      
      //Synchronize: print with round robbin
         private synchronized void printNum(int num)
         {
            for(int i = 1; i <= num; i++)
            { 
               if (i%10 == 0)
               {
                  if (i == 100)
                  {
                     System.out.print(" " + i);
                  }
                  else
                  {          
                     System.out.print(" " + i);
                     System.out.println();
                     try
                     {
                        Thread pca = new Thread(new PrintChar('a', 100));                    
                        pca.start();
                        pca.join();
                     
                        Thread pcb = new Thread(new PrintChar('b', 100));
                        pcb.start();
                        pcb.join();
                     }
                        catch (InterruptedException e)
                        {
                        } 
                  }
               }
               else if(i == 1)
               {
                  try
                  {
                     Thread pca = new Thread(new PrintChar('a', 100));                    
                     pca.start();
                     pca.join();
                     
                     Thread pcb = new Thread(new PrintChar('b', 100));
                     pcb.start();
                     pcb.join();
                  }
                     catch (InterruptedException e)
                     {
                     } 
               	
                  System.out.print(" " + i);
               }
               else
               {
                  System.out.print(" " + i);
               }
            }
            System.out.println();
         }
      }
   }