 	/*
		Description: 	Fan Animation With Thread Class, SLider For Speed, and Buttons 
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_TakeHomeFinal_Task1
		Course Name:	COSC 420
		Date:				May 10, 2013
	*/
	
   import java.awt.*;
   import javax.swing.*;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import javax.swing.event.ChangeListener;
   import javax.swing.event.ChangeEvent;
   import java.util.Hashtable;

   public class Hood_TakeHomeFinal_FanAnimation_Thread_Class extends JApplet implements ChangeListener
   {
      Fan fan = new Fan();	//initiate object to start timer
   	
      JPanel p1 = new JPanel();	//initiate panel
      JPanel p2 = new JPanel();	//initiate panel
   
      //create resume, suspend and reverse buttons
      JButton b1 = new JButton("Start");
      JButton b2 = new JButton("Stop");
      JButton b3 = new JButton("Reverse");
   	
      private JSlider ds;			//create slider object
   
   	//inititate object for button actions
      ButtonHandler bh = new ButtonHandler();
   	
      public void init() 	//init method for applet
      {
         ds = new JSlider(SwingConstants.VERTICAL,0,500,500); 	//initiate slider object
         ds.setMajorTickSpacing(5);	//slider increments
         ds.addChangeListener(this);
      	
      	//table to set labels for slider
         Hashtable label = new Hashtable();
         label.put(new Integer(500), new JLabel("Low"));
         label.put(new Integer(250), new JLabel("Medium"));
         label.put(new Integer(0), new JLabel("High"));
         ds.setLabelTable(label);
         ds.setPaintLabels(true);
      
      	//add components to panel
         p1.add(b1);
         p1.add(b2);
         p1.add(b3);
         p2.add(ds);
      	
      	//set button action commands
         b1.setActionCommand("Start");
         b1.addActionListener(bh);
         b1.setToolTipText("Start Fan Again After Stop");
      	
         b2.setActionCommand("Stop");
         b2.addActionListener(bh); 
         b2.setToolTipText("Stop Fan");
      				
         b3.setActionCommand("Reverse");
         b3.addActionListener(bh);   
         b3.setToolTipText("Reverse Fan");	
      	
      	//add components to frame
         setSize(400,400);
         add(fan);
         add(p1, BorderLayout.SOUTH);
         add(p2, BorderLayout.EAST);
      }
   	
      public void stateChanged(ChangeEvent e)		//slider method to detect change and change fan speed
      {
         fan.speed = ds.getValue();
      } 	
   	
      private	class ButtonHandler implements ActionListener
      {
         public void actionPerformed(ActionEvent event)	//method for when button is clicked
         {
            if ("Start".equals(event.getActionCommand()))
            {
               fan.resume();
            }
            else if("Stop".equals(event.getActionCommand()))
            {
               fan.suspend();
            }
            else if("Reverse".equals(event.getActionCommand()))
            {	
               if(fan.counter3 == 0)
               {
                  fan.counter3 = 1;
               }
               else if(fan.counter3 == 1)
               {
                  fan.counter3 = 0;
               }
            }
         }
      }
   }
   
   class Fan extends JPanel implements Runnable
   {
      private Thread thread = null;
   
  		//counter to move arcs
      int counter = 0;
      int counter3 = 0;
   	
      int speed = 500;	//speed of fan
   
      public Fan() //default constructor
      {
         thread = new Thread(this);
         thread.start();
      }
   
      public void run() 	//run method
      {
         while (true) 
         {       
            if(counter3 == 0)
            {
               count();
            }
         
            if(counter3 == 1)
            {
               count2();
            }
              		
            repaint();  // repaints a component by scheduling
         			
            try 
            {
               thread.sleep(speed);   
            }
            catch (InterruptedException ex) 
            {
               System.out.println(ex);
            }
         }
      }
   
      public void count() //method to move arcs counter clockwise
      {
         counter = counter+25;
      }
      
      public void count2()	//method to move arcs clockwise
      {
         counter = counter-25;
      }
   	
      public void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
      	
         g.setColor(Color.BLUE);	//set arcs to blue
      	
      	//create arcs
         g.fillArc(20,40,280,280,counter,45);
         g.fillArc(20,40,280,280,90+counter,45);
         g.fillArc(20,40,280,280,180+counter,45);
         g.fillArc(20,40,280,280,270+counter,45);
      	
         g.drawOval(10,30,300,300);
      }
   
      public void suspend()
      {
         thread.suspend(); // Suspend fan
      }
   
      public void resume() 
      {
         thread.resume(); // Resume fan
      }
   }