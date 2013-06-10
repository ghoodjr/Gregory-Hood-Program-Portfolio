	/*
		Description: 	Applet Takes Numbers And Sorts Them
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_CW10
		Course Name:	COSC 420
		Date:				March 26, 2013
	*/  
   import javax.swing.JApplet;
   import javax.swing.SwingUtilities;
   import java.awt.Graphics;
   import javax.swing.JLabel;
   import javax.swing.JButton;
   import javax.swing.JTextField;
   import java.awt.event.KeyListener;
   import java.awt.event.KeyEvent;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import java.awt.Font;
   import java.awt.FlowLayout;
   import java.awt.Dimension;

   public class Hood_CW10  extends JApplet implements ActionListener, KeyListener
   {
      JLabel l2,l3;														//create label to insert in applet
      JTextField t1;														//create text field
      JButton b1,b2;														//create buttons
      Font f1 = new Font("Ecofont Vera Sans",Font.BOLD,30);	//initiate new font for text
      
   	//create integers for labels
      Integer number;	
      Integer number2;
      
      int number3 = 0;					//create int for number input
      int[] number4 = new int[5];	//initiate array to hold number input
      int hold; 							//create int to hold specific array number
   
      public void start()	//default constructor
      {
         setSize(200,170);					//set size of applet
         setLayout(new FlowLayout());	//set applet layout
      	
         t1 = new JTextField();;								//initiate text field
         t1.setFont(f1);										//set text font
         t1.setPreferredSize(new Dimension(180,50));	//set textfield size
         t1.addKeyListener(this);
      	
         b1 = new JButton("Sort");							//initiate increase button
         b1.setPreferredSize(new Dimension(80,30));	//set button size
         b1.setActionCommand("Increase");
         b1.addActionListener(this);
      	
         b2 = new JButton("Display");						//initiate decrease button
         b2.setPreferredSize(new Dimension(80,30));	//set button size
         b2.setActionCommand("Decrease");
         b2.addActionListener(this);
      	
         l2 = new JLabel();									//initiate label
         l2.setPreferredSize(new Dimension(150,20));	//set label size
         l2.setText("Enter After Each Number");
      	
      	//add components to frame
         add(t1);	
         add(b1);
         add(b2);
         add(l2); 	
      }
      
      public void actionPerformed(ActionEvent event)	//method for when button is clicked
      {
         if ("Increase".equals(event.getActionCommand()))
         {
            order();	//call order method
         }
         
         else if("Decrease".equals(event.getActionCommand()))
         {
            repaint();	//call paint method
         }
      }
   	
      public void keyPressed(KeyEvent event)	//method to check key pressed
      {
         if(number3 < 5)
         {
            if(event.getKeyCode()== KeyEvent.VK_ENTER)	//if key pressed is ENTER
            {
               number = Integer.parseInt(t1.getText());
               number2 = event.getKeyCode();
               l2.setText("Number Entered: " + number.toString());
               t1.setText("");
               number4[number3] = number;
               number3++;
            }
         }
         else
         {
            l2.setText("No More Numbers");
         }
      }
   	
      public void keyReleased(KeyEvent event)
      {
      }
   	
      public void keyTyped(KeyEvent event)
      {
      }
      
      public void order()	//method to put numbers entered in order
      {
         for(int i = 0; i < number4.length; i++)
         {
            for(int j = 1; j < (number4.length-i); j++)
            {
               if(number4[j-1] > number4[j])
               {
                  hold = number4[j-1];
                  number4[j-1]=number4[j];
                  number4[j]=hold;         
               }
            }
         
         }
      }
   	
      public void paint(Graphics g)	//paint method
      {
         super.paint(g);
			
         g.drawString("Order: "+String.valueOf(number4[0])+","+String.valueOf(number4[1])+","
            +String.valueOf(number4[2])+","+String.valueOf(number4[3])+","+String.valueOf(number4[4]),20,135);	//draw numbers in order
      		
         g.drawString("Smallest: " + number4[0],20,150);	//draw smallest number
         g.drawString("Largest: " + number4[4],20,165);	//draw largest number
      	
      }
   }