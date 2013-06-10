   import javax.swing.*;

   import java.awt.event.*;
   import java.awt.*;

   public class Frame implements ActionListener
   {
  		//default constructor to call sky level    
		public Frame()
      {
         JFrame frame = new JFrame();	//create new frame to hold level
         frame.add(new Board());		//add level
         frame.setTitle("Shoot Em Up : Sky Level");	//add title 
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(700,365);	//set level dimensions
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
      	
      }
   	
		//constructor to call the next level 	  
      public Frame(int i1)
      {
         JFrame frame = new JFrame();	//create new frame to hold level
         frame.add(new Board2());		//add level
         frame.setTitle("Shoot Em Up : Ground Level");	//add title 
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(700,365);	//set level dimensions
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
      	
      }
   	
		//construcor to call another level
      public Frame(int i1, int i2, int i3, int i4)
      {
         JFrame frame = new JFrame();	//create new frame to hold level
         frame.add(new Board3());		//add level
         frame.setTitle("Shoot Em Up : Water Level");	//add title 
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(700,365);	//set level dimensions
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
      	
      }
   	
		//construcot to call main menu	  
      public Frame(int i1, int i2)
      {
         JFrame frame2 = new JFrame();	//create new frame to hold menu
         frame2.setSize(210,200);	//set frame sound
			frame2.setTitle("Shoot Em Up");
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	  
         JButton startButton = new JButton("Sky Level");	//first button for level one
         startButton.setSize(100,150);	
         JButton startButton2 = new JButton("Ground Level");	//second button for second level
         startButton2.setSize(100,50);
         JButton startButton3 = new JButton("Water Level");	//third button for third level
         startButton3.setSize(100,50);
         startButton.addActionListener(this);
         startButton2.addActionListener(this);
         startButton3.addActionListener(this);
         startButton.setActionCommand("stop");
         startButton2.setActionCommand("stop2");
         startButton3.setActionCommand("stop3");		  
         frame2.add(startButton, BorderLayout.EAST);
         frame2.add(startButton2, BorderLayout.WEST);
         frame2.add(startButton3, BorderLayout.SOUTH);
      	  
         frame2.setVisible(true);
      }
   	
		//method to check which button was pressed	  
      public void actionPerformed(ActionEvent e) 
      {
         if ("stop".equals(e.getActionCommand()))
         {
            new Frame();
         		
         }
         else if ("stop2".equals(e.getActionCommand()))
         {
            new Frame(1);
         }
         else if ("stop3".equals(e.getActionCommand()))
         {
            new Frame(1,2,3,4);
         }
      }
   		 
   		  
      public static void main(String[] args)
      {
         new Frame(1,2);	//call method to run main menu
      }
   }

