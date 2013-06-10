   import java.awt.*;
 
   import javax.swing.ImageIcon;

   public class Enemy 
   {
     	//object for enemy image
      Image img;
   	
   	//dimensions for enemy
      int x, y;
   	
   	//variable for enemy death
      boolean isAlive = true;
      
   	//constructor for enemy creation
      public Enemy(int startX, int startY, String location)
      {
         x = startX;
         y = startY;
         ImageIcon l = new ImageIcon(location);
         img = l.getImage();
      }
      
   	//methods to return enemy dimensions
      public int getX()
      {
         return x;
      }
      public int getY()
      {
         return y;
      }
      public boolean Alive()
      {
         return isAlive;
      }
      public Image getImage()
      {
         return img;
      }
     
     	//method for enemy movement
      public void move(int dx, int left)
      {
         if(dx == 0 || dx == -1 || dx ==1)
         {         
            x = x + (1);
         }
      }
   	
      public void move2(int dx, int left)
      {
         if(dx == 0 || dx == -1 || dx ==1)
         {         
            x = x - (1);
         }
      }
   	
      //method for dimensions of enemy image
      public Rectangle getBounds()
      {
         return new Rectangle(x,y,100,97);
      }
   }
