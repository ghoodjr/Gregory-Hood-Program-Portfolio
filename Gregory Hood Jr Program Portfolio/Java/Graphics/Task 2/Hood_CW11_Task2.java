	/*
		Description: 	Applet Changes Circle Size By Slider
		Programmer:  	Gregory Hood Jr
		Program Name:	Hood_CW11 Task2
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
   import javax.swing.JSlider;
   import javax.swing.SwingConstants;
   import javax.swing.event.ChangeListener;
   import javax.swing.event.ChangeEvent;
	
   public class Hood_CW11_Task2 extends JApplet implements ChangeListener
   {
      Random g2 = new Random();	//initiate random object for random numbers
      int diameter;					//int to hold diameter
      double diameter2;				//int to hold diameter 2
      double radius;					//int to hold radius
      double area;					//int to hold area
      double circumference;		//int to hold circumference
      Double n1,n2,n3,n4;			//doubles to hold text areavalues
   	
      private JSlider ds;			//create slider object
      JTextArea field;				// create text areas
      JTextArea field2;
      JTextArea field3;
      JTextArea field4;
   	
      public void start()
      {
         setLayout(null);
         setSize(250,320);
      
         ds = new JSlider(SwingConstants.VERTICAL,100,200,150); 	//initiate slider object
         ds.setMajorTickSpacing(5);
         ds.setPaintTicks(true);  	
         ds.setBounds(220,0,30,220);
         ds.addChangeListener(this);
      
         diameter = ds.getValue();
         numbers();   	
      	
         field = new JTextArea();	//initiate text areas
         field2 = new JTextArea();
         field3 = new JTextArea();
         field4 = new JTextArea();
      	
         JLabel l1 = new JLabel("Radius:");				//initiate labels
         JLabel l2 = new JLabel("Area:");
         JLabel l3 = new JLabel("Circumference:");
         JLabel l4 = new JLabel("Diameter:");
      	
         l1.setBounds(0,230,130,20);
         l2.setBounds(0,250,130,20);
         l3.setBounds(0,270,130,20);
         l4.setBounds(0,290,130,20);
      	
         field.setBounds(100,230,100,20);
         field2.setBounds(100,250,100,20);
         field3.setBounds(100,270,100,20);
         field4.setBounds(100,290,100,20);
      	
         field.setEditable(false);				//set text are to not editable
         field2.setEditable(false);
         field3.setEditable(false);
         field4.setEditable(false);
      	
         field.setText(n1.toString());
         field2.setText(n2.toString());
         field3.setText(n3.toString());
         field4.setText(n4.toString());
      
         add(field);								//add components to the applet
         add(field2);
         add(field3);
         add(field4);
         add(l1);
         add(l2);
         add(l3);
         add(l4);
         add(ds);
      }
   	
      public void numbers()		//method to calculate and assign numbers
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
   
      public void stateChanged(ChangeEvent e)		//slider method to detect change
      {
         diameter = ds.getValue();
         numbers();
         field.setText(n1.toString());
         field2.setText(n2.toString());
         field3.setText(n3.toString());
         field4.setText(n4.toString());
         repaint();
      } 	
   	
      public void paint(Graphics g)
      {
         super.paint(g);
      
         g.fillOval(10,10, diameter, diameter);
      }
   }
