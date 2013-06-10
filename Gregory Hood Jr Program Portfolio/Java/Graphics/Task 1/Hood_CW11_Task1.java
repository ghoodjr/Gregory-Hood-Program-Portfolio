	/*
		Description: 	Applet Changes Circle Size By Random Number
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_CW11 Task1
		Course Name:	COSC 420
		Date:				April 2, 2013
	*/
  
   import java.awt.Graphics;
   import java.awt.Dimension;
   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import javax.swing.JTextArea;
   import java.util.Random;
   import javax.swing.JApplet;
	
   public class Hood_CW11_Task1 extends JApplet
   {
      Random g2 = new Random();	//initiate random object for random numbers
      int diameter;					//int to hold diameter
      double diameter2;				//int to hold diameter 2
      double radius;					//int to hold radius
      double area;					//int to hold area
      double circumference;		//int to hold circumference
      Double n1,n2,n3,n4;			//doubles to hold text areavalues
   	
      public void start()					//start method for applet
      {
         setLayout(null);
         diameter = g2.nextInt(100);
         setSize(200,220);
      
         numbers();   						//call numbers app
      	
         JTextArea field = new JTextArea();		//initiate text fields
         JTextArea field2 = new JTextArea();
         JTextArea field3 = new JTextArea();
         JTextArea field4 = new JTextArea();
      	
         JLabel l1 = new JLabel("Radius:");		//initiate labels
         JLabel l2 = new JLabel("Area:");
         JLabel l3 = new JLabel("Circumference:");
         JLabel l4 = new JLabel("Diameter:");
      	
         l1.setBounds(0,130,130,20);
         l2.setBounds(0,150,130,20);
         l3.setBounds(0,170,130,20);
         l4.setBounds(0,190,130,20);
      	
         field.setBounds(100,130,100,20);
         field2.setBounds(100,150,100,20);
         field3.setBounds(100,170,100,20);
         field4.setBounds(100,190,100,20);
      	
         field.setEditable(false);				//set all text fields to not editable
         field2.setEditable(false);
         field3.setEditable(false);
         field4.setEditable(false);
      	
         field.setText(n1.toString());
         field2.setText(n2.toString());
         field3.setText(n3.toString());
         field4.setText(n4.toString());
      
         add(field);								//add components to frame
         add(field2);
         add(field3);
         add(field4);
         add(l1);
         add(l2);
         add(l3);
         add(l4);
      }
   	
      public void numbers()				//method to calculate and assign numbers
      {
         radius = diameter/2;
         area = Math.PI*Math.pow(radius,2);
         circumference = 2*Math.PI*radius;
         diameter2 = 2*radius;
      	
         n1 = radius;
         n2 = area;
         n3 = circumference;
         n4 = diameter2;
      } 	
   	
      public void paint(Graphics g)
      {
         super.paint(g);
      
         g.fillOval(10,10, diameter, diameter);
      }
   }
