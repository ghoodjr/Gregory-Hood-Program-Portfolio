 	/*
		Description: 	Fan Animation With Timer Class, SLider For Speed, Buttons and Audio Clips and Flashing TEXT
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_TakeHomeFinal_Task3
		Course Name:	COSC 420
		Date:				May 10, 2013
	*/
	
   import java.awt.*;
   import javax.swing.*;
   import java.applet.AudioClip;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import javax.swing.event.ChangeListener;
   import javax.swing.event.ChangeEvent;
   import java.util.Hashtable;

   public class Hood_TakeHomeFinal_FanAnimation_Timer_Class extends JApplet implements ChangeListener
   {
      Fan fan = new Fan();	//initiate object to start timer
      Fan2 fan2 = new Fan2();	//initiate object to start timer
   
      JPanel p1 = new JPanel();	//initiate panel
      JPanel p2 = new JPanel();	//initiate panel
   
      //create resume, suspend and reverse buttons
      JButton b1 = new JButton("Start");
      JButton b2 = new JButton("Stop");
      JButton b3 = new JButton("Reverse");
   	
      private JSlider ds;			//create slider object
   	
      AudioClip s1, s2, cs;	//audioclips for sound
   	
      int clip = 0;	//int to hold audio index
   
   	//inititate object for button actions
      ButtonHandler bh = new ButtonHandler();
   	
      public void init() 	//init method for applet
      {
         fan2.setPreferredSize(new Dimension(100,20));
      	
         s1 = getAudioClip(getDocumentBase(), "hilltop_jj.mid");
         s2 = getAudioClip(getDocumentBase(), "skychase_jw.mid");
      	
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
         add(fan, BorderLayout.CENTER);
         add(fan2, BorderLayout.NORTH);
         add(p1, BorderLayout.SOUTH);
         add(p2, BorderLayout.WEST);
      }
   	
      public void stateChanged(ChangeEvent e)		//slider method to detect change and change fan speed
      {
         fan.speed = ds.getValue();
         fan2.speed = ds.getValue();
      } 	
   	
      private	class ButtonHandler implements ActionListener
      {
         public void actionPerformed(ActionEvent event)	//method for when button is clicked
         {
            if ("Start".equals(event.getActionCommand()))
            {
               fan2.counter4 = 1;
               fan.resume();
            	
               if (clip == 0)
               {
      				clip = 1;            
						cs = s1;
                  cs.play();
               }
            	else if (clip == 1)
               {
                  cs.stop();
                  cs = s1;
                  cs.play();
               }
            }
            else if("Stop".equals(event.getActionCommand()))
            {
               fan2.counter4 = 0;
               fan.suspend();	
               cs.stop();
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
            	
     		      if (clip == 0)
               {
      				clip = 1;            
						cs = s2;
                  cs.play();
               }   
					else if (clip == 1)
               {
                  cs.stop();
                  cs = s2;
                  cs.play();
               }
            }
         }
      }
   }
   
   class Fan extends JPanel implements ActionListener 
   {
      private int delay = 5;
   
   // Create a timer with delay 5 ms
      protected Timer timer = new Timer(delay, this);	//initiate timer object
   
   	//counter to move arcs
      int counter = 0;
      int counter3 = 0;
   	
      int speed = 500;	//speed of fan
   	
      boolean show = true;
      String label = "Hood_Fan ON"; //create string to hold text
   
   
      public Fan() //default constructor
      {
         timer.start();
      }
   
   /** Handle the action event */
      public void actionPerformed(ActionEvent e) 
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
         			
         timer.setDelay(speed);   
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
         g.fillArc(20,20,280,280,counter,45);
         g.fillArc(20,20,280,280,90+counter,45);
         g.fillArc(20,20,280,280,180+counter,45);
         g.fillArc(20,20,280,280,270+counter,45);
      	
         g.drawOval(10,10,300,300);
      }
   
      public void suspend()
      {
         timer.stop(); // Suspend fan
      }
   
      public void resume() 
      {
         timer.start(); // Resume fan
      }
   
      public void setDelay(int delay) 
      {
         this.delay = delay;
         timer.setDelay(delay);
      }
   }
	
   class Fan2 extends JPanel implements ActionListener 
   {
      private int delay = 5;
   
   // Create a timer with delay 5 ms
      protected Timer timer = new Timer(delay, this);	//initiate timer object
   
   	//counter to move arcs
      int counter4 = 0;
   	
      int speed = 500;	//speed of fan
   	
      boolean show = true;
      String label = "Hood_Fan ON"; //create string to hold text
   
   
      public Fan2() //default constructor
      {
         timer.start();
      }
   
   /** Handle the action event */
      public void actionPerformed(ActionEvent e) 
      {
         repaint();  // repaints a component by scheduling
         			
         timer.setDelay(speed);   
      }
   	
      public void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
      	
         g.setColor(Color.BLUE);	//set string to blue
      	
         if (counter4 == 1)
         {
            if (show)
            {
               g.setFont(new Font("Times New Roman", Font.BOLD, 30));	//set font for label
               g.drawString(label, 140,20);
            }
         
            show = !show;
         }
      }
   
      public void suspend()
      {
         timer.stop(); // Suspend label
      }
   
      public void resume() 
      {
         timer.start(); // Resume label
      }
   
      public void setDelay(int delay) 
      {
         this.delay = delay;
         timer.setDelay(delay);
      }
   }