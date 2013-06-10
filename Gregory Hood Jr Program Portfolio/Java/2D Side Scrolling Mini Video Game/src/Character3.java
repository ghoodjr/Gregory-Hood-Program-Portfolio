   import java.awt.*;
   import java.awt.event.KeyEvent;
   import java.util.ArrayList;
 
   import javax.swing.ImageIcon;
   public class Character3 {
   	
   	//variables for character position
      int x, dx, y,nx,nx2,left, dy;
   	
   	//objects for character image
      Image still,jump,reverse;
    
    	//ammo for character
      int ammo = 20;
    
      ImageIcon s = new ImageIcon("character2.png");
      ImageIcon j= new ImageIcon("character2.png");
      ImageIcon l = new ImageIcon("character3.png");
    
      static ArrayList bullets;
    
    	//default constructor
      public Character3() {
         x = 75;
         left = 150;
         nx = 0;
         nx2= 685;
         y = 172;
         still = s.getImage();
         bullets = new ArrayList();
      
      }
   
   	//dimensions for character image
      public Rectangle getBounds()
      {
         return new Rectangle(left, y,67,154 ) ;
      }
   	
   	//method to return bullets
      public static ArrayList getBullets()
      {
         return bullets;
      }
   	
    	//method for character to shoot
      public void fire()
      {
         if (ammo > 0)
         {
            ammo--;
             
            Bullet z = new Bullet((left + 10), (Board3.v + 109/2));
            bullets.add(z);
         }}
   	
   	//method to control character movement
      public void move() 
      {
         if (dx != -1)
         {
            if (left + dx <= 150)
            {
               left+=dx;
            }
                    
            else
            {
               x = x + dx;
            
               nx2= nx2+dx;
               nx = nx + dx;
            }
         }
         else
         {
            if (left+dx >0)
               left = left + dx;
         }
      }
   	
   	//methods to return dimennsions
      public int getX() {
         return x;
      }
    
      public int getLeft(){
         return left;
      }
   
      public int getnX() {
         return nx;
      }
    
      public int getnX2() {
         return nx2;
      }
   
      public int getdx() {
         return dx;
      }
    
      public Image getImage() {
         return still;
      }
   	
   	//method to track keys presed
      public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
         if (key == KeyEvent.VK_LEFT)
         {               dx = -1;
            still = l.getImage();           }
            
         if (key == KeyEvent.VK_RIGHT)
         {dx = 1;
            still = s.getImage();  
         }
            
         if (key == KeyEvent.VK_SPACE)
         {
            fire();
         }
            
         if (key == KeyEvent.VK_UP)
         {dy = 1;
            still = j.getImage();
         }  
      		
      }
   	
   	//method to track keys released
      public void keyReleased(KeyEvent e) 
      {
         int key = e.getKeyCode();
      
         if (key == KeyEvent.VK_LEFT)
            dx = 0;
      
         if (key == KeyEvent.VK_RIGHT)
            dx = 0;
            
         if (key == KeyEvent.VK_UP)
         {dy = 0;
            still = s.getImage();}
      		 
      }
   }
