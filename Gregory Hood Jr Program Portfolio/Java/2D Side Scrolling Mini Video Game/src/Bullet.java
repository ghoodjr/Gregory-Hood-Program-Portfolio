   import java.awt.*;
 
   import javax.swing.ImageIcon;

   public class Bullet 
   {
     	//variables for platform dimensions
      int x,y;
   	
   	//variable for platform image
      Image img;
   	
   	//boolean  for visibility
      boolean visible;
     
     	//constructor
      public Bullet(int startX, int startY)
      {
         x = startX;
         y = startY;
         ImageIcon newBullet = new ImageIcon("ball.png");
         img = newBullet.getImage();
         visible = true;
      }
   	
   	//method to get dimensions of bullet image
      public Rectangle getBounds()
      {
         return new Rectangle(x, y, 44,24 );
      }
     	
   	//method return dimensions
      public int getX()
      {
         return x;
      }
      public int getY()
      {
         return y;
      }
      public boolean getVisible()
      {
         return visible;
      }
      public Image getImage()
      {
         return img;
      }
     
     	//method to move bullets
      public void move()
      {
         x = x + 2;
         if ( x > 1000)
            visible = false;
      }
   }
