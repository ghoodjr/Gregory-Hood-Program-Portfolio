   import java.awt.*;
   import java.awt.event.*;
   import java.util.ArrayList;
 
   import javax.swing.*;
   public class Board2 extends JPanel implements ActionListener, Runnable  
	{
      Character2 p; 			//variable for character
      public Image img; 	//variable for background
      Timer time; 			//variable for timer
      static int v = 172;  //variable board dimensions
      
		Thread animator;
		
      int score = 0; //variab;e to hold score
   	
		//variables for enemies
      Enemy en;
      Enemy en2;
      Enemy en3;
      Enemy en4;
      Enemy en5;
      Enemy en6;
      Enemy en7;
      Enemy en8;
      Enemy en9;
      Enemy en10;
      Enemy en11;
      Enemy en12;
		
		//variables for platforms
      platform p1;
      platform p3;
      platform p4;
      platform p5;
		
      puzzle p2;//variable for puzzle piece
   
   	boolean a = false;
      boolean done2 = false;
     
      static Font font = new Font("SanSerif", Font.BOLD, 24);	//font for score and ammo
      
		//default constructor
      public Board2() 
		{
      	p = new Character2();	//create new character object
         addKeyListener(new AL()); //to read keyboard input
			
         setFocusable(true);
			
         ImageIcon i = new ImageIcon("Background 1.jpg");	//background image
         
			img = i.getImage();
         time = new Timer(5, this);
         time.start();
      	
			//enemy objects  
      	en = new Enemy(600, 220, "ghost.png");
         en2 = new Enemy(1000, 220, "ghost.png");
         en3 = new Enemy(1400, 220, "ghost.png");
         en4 = new Enemy(600, 220, "ghost.png");
         en5 = new Enemy(1000, 220, "ghost.png");
         en6 = new Enemy(1400, 220, "ghost.png");
         en7 = new Enemy(600, 220, "ghost.png");
         en8 = new Enemy(1000, 220, "ghost.png");
         en9 = new Enemy(1400, 220, "ghost.png");
         en10 = new Enemy(600, 220, "ghost.png");
         en11 = new Enemy(1000, 220, "ghost.png");
         en12 = new Enemy(1400, 220, "ghost.png");
			
			//platform objects
         p1 = new platform(800, 195, "platform.png");
         p3 = new platform(2100, 220, "platform.png");
         p4 = new platform(3400, 195, "platform.png");
         p5 = new platform(4700, 195, "platform.png");
			
         p2 = new puzzle(5500, 195, "puzzle.png");	//puzzle object
       }
   	
		//method to check actions from keyboard
      public void actionPerformed(ActionEvent e) 
		{
         checkCollisions();	//call checkCollisions method
         checkCollisions2();	//call checkCollisions2 method
			
         System.out.println(p.x);	//print steps of character
			
         ArrayList bullets = Character2.getBullets();	//ammo for character
         for (int w = 0; w < bullets.size(); w++)
         {
            Bullet m = (Bullet) bullets.get(w);
            if (m.getVisible() == true)
               m.move();
            else
               bullets.remove(w);
         }
             
         p.move();	//method to move character
             
      		 
			//if statements to calculate when enemies should move
         if (p.x > 0)       
            en.move2(p.getdx(), p.getLeft());
         if (p.x> 200)
            en2.move2(p.getdx(), p.getLeft());
         if (p.x> 400)
         	en3.move2(p.getdx(), p.getLeft());
         if (p.x> 600)
            en4.move2(p.getdx(), p.getLeft());
         if (p.x> 800)
            en5.move2(p.getdx(), p.getLeft());
         if (p.x> 1000)
            en6.move2(p.getdx(), p.getLeft());
         if (p.x> 1200)
            en7.move2(p.getdx(), p.getLeft());
         if (p.x> 1400)
            en8.move2(p.getdx(), p.getLeft());
         if (p.x> 1600)
            en9.move2(p.getdx(), p.getLeft());
         if (p.x> 1800)
            en10.move2(p.getdx(), p.getLeft());
         if (p.x> 2000)
            en11.move2(p.getdx(), p.getLeft());
         if (p.x> 2200)
            en12.move2(p.getdx(), p.getLeft());
         if (p.x> 0)
            p1.move(p.getdx(), p.getLeft());
         if (p.x> 0)
            p3.move(p.getdx(), p.getLeft());
         if (p.x> 0)
            p4.move(p.getdx(), p.getLeft());
         if (p.x> 0)
            p5.move(p.getdx(), p.getLeft());
         if (p.x> 0)
            p2.move(p.getdx(), p.getLeft());
      		  
      	repaint();
      }
   	
   	
      boolean answer = false;	//variable for puzzle piece detection
		
		//method to check if puzzle piece detection
      public boolean checkCollisions2()
      {
         //dimensions of objects
			Rectangle r4 = p.getBounds();
         Rectangle r6 = p2.getBounds();
      	
         if(r4.intersects(r6))
         {
            p2.isAlive = false;
            while(answer == false)
            {
               answer = true;
            }
         }
      	return answer;
      }
   	
      boolean h = false;			//jump height variable
      boolean done = false;		//ground variable
   	
		//method to check if enemie is destroyed and platform is reached
      public void checkCollisions()
      {
         Rectangle r1 = en.getBounds();
         Rectangle r2 = en2.getBounds();
         Rectangle r3 = en3.getBounds();
         Rectangle r8 = en4.getBounds();
         Rectangle r9 = en5.getBounds();
         Rectangle r10 = en6.getBounds();
         Rectangle r11 = en7.getBounds();
         Rectangle r12 = en8.getBounds();
         Rectangle r13 = en9.getBounds();
         Rectangle r14 = en10.getBounds();
         Rectangle r15 = en11.getBounds();
         Rectangle r16 = en12.getBounds();
         Rectangle r4 = p.getBounds();
         Rectangle r5 = p1.getBounds();
         Rectangle r6 = p3.getBounds();
         Rectangle r7 = p4.getBounds();
         Rectangle r17 = p5.getBounds();
			
         ArrayList bullets = Character2.getBullets();
      
         if (r4.intersects(r5) || r4.intersects(r7) || r4.intersects(r17))
         {
            v = 50;
         }
         else if(r4.intersects(r6))
         {
            v = 75; 
         }
         else
         {
            v = 172;
         
         }
      
			//for loop checks ammo
         for ( int i = 0; i <bullets.size(); i++)
         {
            Bullet m = (Bullet) bullets.get(i);
            Rectangle m1 = m.getBounds();
         
         	//if statements to detect if enemies are destroyed
            if (r1.intersects(m1) && en.Alive())
            {
            	en.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r2.intersects(m1) && en2.Alive())
            {
               en2.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            
            else if (r3.intersects(m1) && en3.Alive())
            {
            			
               en3.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r8.intersects(m1) && en4.Alive())
            {
            			
               en4.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r9.intersects(m1) && en5.Alive())
            {
            			
               en5.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r10.intersects(m1) && en6.Alive())
            {
            			
               en6.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r11.intersects(m1) && en7.Alive())
            {
            			
               en7.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r12.intersects(m1) && en8.Alive())
            {
            			
               en8.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r13.intersects(m1) && en9.Alive())
            {
            			
               en9.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r14.intersects(m1) && en10.Alive())
            {
            			
               en10.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r15.intersects(m1) && en11.Alive())
            {
            			
               en11.isAlive = false;
               m.visible = false;
               score = score+5;
            }
            else if (r16.intersects(m1) && en12.Alive())
            {
            			
               en12.isAlive = false;
               m.visible = false;
               score = score+5;
            }
         }
         Rectangle d = p.getBounds();
      }
		
		//method to make images visible
      public void paint(Graphics g) 
		{
         if (p.dy == 1 && done2 == false) {
            done2 = true;
            animator = new Thread(this);
            animator.start();
         }
      
         super.paint(g);
         Graphics2D g2d = (Graphics2D) g;
         Graphics2D g3d = (Graphics2D) g;
      
         if ((p.getX() - 590) % 2400 == 0)
            p.nx = 0;
         if ((p.getX() - 1790) % 2400 == 0)
            p.nx2 = 0;
      
         g2d.drawImage(img, 685 - p.getnX2(), 0, null);
         if (p.getX() > 590) {
            g2d.drawImage(img, 685 - p.getnX(), 0, null);
         }
         g2d.drawImage(p.getImage(), p.left, v, null);
      
         if (p.getdx() == -1) {
            g2d.drawImage(img, 685 - p.getnX2(), 0, null);
            g2d.drawImage(p.getImage(), p.left, v, null);
         }
             
         ArrayList bullets = Character2.getBullets();
         for (int w = 0; w < bullets.size(); w++)
         {
            Bullet m = (Bullet) bullets.get(w);
            g2d.drawImage(m.getImage(),m.getX(), m.getY(), null);
         }
         g2d.setFont(font);
         g2d.setColor(Color.BLUE);
         g2d.drawString("Ammo left: " + p.ammo, 500, 20);
         g3d.setFont(font);
         g3d.setColor(Color.RED);
         g3d.drawString("Score: " + score, 20, 20);
         if (p.x > 0)
            if (en.Alive() == true)
               g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
         if (p.x > 200)
            if (en2.Alive() == true)
               g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
         if (p.x > 400)
            if (en3.Alive() == true)
               g2d.drawImage(en3.getImage(), en3.getX(), en3.getY(), null);
         if (p.x > 600)
            if (en4.Alive() == true)
               g2d.drawImage(en4.getImage(), en4.getX(), en4.getY(), null);
         if (p.x > 800)
            if (en5.Alive() == true)
               g2d.drawImage(en5.getImage(), en5.getX(), en5.getY(), null);
         if (p.x > 1000)
            if (en6.Alive() == true)
               g2d.drawImage(en6.getImage(), en6.getX(), en6.getY(), null);
         if (p.x > 1200)
            if (en7.Alive() == true)
               g2d.drawImage(en7.getImage(), en7.getX(), en7.getY(), null);
         if (p.x > 1400)
            if (en8.Alive() == true)
               g2d.drawImage(en8.getImage(), en8.getX(), en8.getY(), null);
         if (p.x > 1600)
            if (en9.Alive() == true)
               g2d.drawImage(en9.getImage(), en9.getX(), en9.getY(), null);
         if (p.x > 1800)
            if (en10.Alive() == true)
               g2d.drawImage(en10.getImage(), en10.getX(), en10.getY(), null);
         if (p.x > 2000)
            if (en11.Alive() == true)
               g2d.drawImage(en11.getImage(), en11.getX(), en11.getY(), null);
         if (p.x > 2200)
            if (en12.Alive() == true)
               g2d.drawImage(en12.getImage(), en12.getX(), en12.getY(), null);
         if (p.x > 100)
            if (p1.Alive() == true)
               g2d.drawImage(p1.getImage(), p1.getX(), p1.getY(), null);  
         if (p.x > 200)
            if (p3.Alive() == true)
               g2d.drawImage(p3.getImage(), p3.getX(), p3.getY(), null);
         if (p.x > 200)
            if (p4.Alive() == true)
               g2d.drawImage(p4.getImage(), p4.getX(), p4.getY(), null); 
         if (p.x > 0)
            if (p2.Alive() == true)
               g2d.drawImage(p2.getImage(), p2.getX(), p2.getY(), null); 
         if (p.x > 0)
            if (p5.Alive() == true)
               g2d.drawImage(p5.getImage(), p5.getX(), p5.getY(), null); 
      }
		
  		//method to detect keyboard input 
      private class AL extends KeyAdapter 
		{
         public void keyReleased(KeyEvent e) 
			{
            p.keyReleased(e);
         }
      
         public void keyPressed(KeyEvent e) 
			{
            p.keyPressed(e);
         }
      }
   
      //method for character gravity
      public void cycle() 
		{
      
         if (h == false)	//h is height
            v--;
              
         if (v == 50)	//after character reaches certain height, height decreases
            h = true;
      		  
         if (h == true && v <= 172) 
			{
            v++;
            if (v == 172) {
               done = true;
            }
         }
      }
   	
		//method to run gravity
      public void run() {
      
         long beforeTime, timeDiff, sleep;
      
         beforeTime = System.currentTimeMillis();
      
         while (done == false) {
         
            cycle();
         
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 10 - timeDiff;
         
            if (sleep < 0)
               sleep = 2;
            try {
               Thread.sleep(sleep);
            } 
               catch (InterruptedException e) {
               }
         
            beforeTime = System.currentTimeMillis();
         }
         done = false;
         h = false;
         done2 = false;
      }
   
   }
