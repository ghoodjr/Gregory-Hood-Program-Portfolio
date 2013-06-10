/*
		Description: 	(Run As Applet) Bouncing Flashing Ball Animations using Timer class, Scroll Bar For Ball Speed, Click Applet For More Balls Of Different Color and Plays Music;
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_TakeHomeFinal_Task5(Plus Bonus)
		Course Name:	COSC 420
		Date:				May 10, 2013
*/
	
   import java.awt.*;
   import java.awt.event.*;
   import java.applet.*;
   import javax.swing.*;
   import java.awt.BorderLayout;
   import java.util.*;
   import java.util.List;
   import java.awt.event.MouseAdapter;
   import java.awt.event.MouseEvent;
   import javax.swing.Timer;
   import java.applet.AudioClip;

   public class Hood_TakeHomeFinal_Bouncing_Balls_Timer_Class extends JApplet implements ActionListener
   {
      AudioClip s1;	//audioclip for sound
      private JButton jbtSuspend = new JButton("Suspend");
      private JButton jbtResume = new JButton("Resume");
      BallControl ballControl = new BallControl();
   	
      public void init() 
      {
         //play audio
			s1 = getAudioClip(getDocumentBase(), "hilltop_jj.mid");
         s1.play();
      	
      // Register listeners
         jbtSuspend.addActionListener(this);
         jbtResume.addActionListener(this);
      
      // Group buttons in a panel
         JPanel panel = new JPanel();
         panel.add(jbtSuspend);
         panel.add(jbtResume);
      	
         add(ballControl);
         add(panel, BorderLayout.SOUTH);
         setSize(400, 320);
      }
   	
      public void actionPerformed(ActionEvent e) {
         if (e.getSource() == jbtSuspend)
         {
            ballControl.sus();
            s1.stop();
         }
         
         else if (e.getSource() == jbtResume)
         {
            ballControl.res();
            s1.play();
         }
      }
      public static void main(String[] args) 
      {
        Hood_TakeHomeFinal_Bouncing_Balls_Timer_Class applet = new Hood_TakeHomeFinal_Bouncing_Balls_Timer_Class();
      }
   }

   class BallControl extends JPanel
   implements AdjustmentListener 
   {
      private Ball ball = new Ball();
      
      private JScrollBar jsbDelay = new JScrollBar();
   
      public BallControl() 
      {
      	// Add ball and buttons to the panel
         ball.setBorder(BorderFactory.createEtchedBorder());
         jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
         ball.setDelay(jsbDelay.getMaximum());
         setLayout(new BorderLayout());
         add(jsbDelay, BorderLayout.NORTH);
         add(ball, BorderLayout.CENTER);
         jsbDelay.addAdjustmentListener(this);
      }
   	
      public void sus()
      {
         ball.suspend();
      }
   	
      public void res()
      {
         ball.resume();
      }
   
      public void adjustmentValueChanged(AdjustmentEvent e) 
      {
         ball.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
   }

   class Ball extends JPanel implements ActionListener 
   {
      private int delay = 1000;
   
   // Create a timer with delay 1000 ms
      protected Timer timer = new Timer(delay, this);
   
      List<realBall> bolls = new ArrayList<realBall>();	//object list to hold balls
   	
      boolean show = true;
   
      public Ball() 
      {
         timer.start();
      	
         addBoll();	//initial ball
      	
      	// declare a MouseListener for extra balls
         addMouseListener(
            
               new MouseAdapter() // anonymous inner class
               {  
               // handle mouse press event
                  public void mousePressed( MouseEvent event )
                  { 
                     addBoll();
                  } // end method mousePressed
               
               // handle mouse release event
                  public void mouseReleased( MouseEvent event )
                  { 
                  
                  } // end method mouseReleased
               } // end anonymous inner class
            );
      }
   
   /** Handle the action event */
      public void actionPerformed(ActionEvent e) 
      {      
         for(realBall boll : bolls) 
         {
            boll.move(getWidth(),getHeight());
         }
      	
         repaint();
      }
   
      public void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
         
         if (show)
         {
            for(realBall boll : bolls) 
            {
               boll.draw(g);
            }
         }
      	
         show = !show;
      }
   
      public void addBoll() //method to add ball when mouse pressed
      {
         bolls.add(new realBall());
      }
    
      public void suspend()
      {
         timer.stop(); // Suspend timer
      }
   
      public void resume() {
         timer.start(); // Resume timer
      }
   
      public void setDelay(int delay) 
      {
         this.delay = delay;
         timer.setDelay(delay);
      }
   }
	
   class realBall
   {
      private int radius = 15; // Ball radius
      private int x = radius; private int y = radius; // Current ball position
      private int dx = 5; // Increment on ball's x-coordinate
      private int dy = 5; // Increment on ball's y-coordinate
   	
      Random rand = new Random();	//random generator for colors
      int c1 = rand.nextInt(255);
      int c2 = rand.nextInt(255);
      int c3 = rand.nextInt(255);
   	
      public void move(int w, int h)
      {
         if (x < radius) dx = Math.abs(dx);
         if (x > w - radius) dx = -Math.abs(dx);
         if (y < radius) dy = Math.abs(dy);
         if (y > h - radius) dy = -Math.abs(dy);
         y += dy;
         x += dx;
      }
      public void draw(Graphics g)
      {
         g.setColor(new Color(c1,c2,c3));
         g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
      }
   }