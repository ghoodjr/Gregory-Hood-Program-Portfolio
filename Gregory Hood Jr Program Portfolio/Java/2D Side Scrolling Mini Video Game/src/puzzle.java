   import java.awt.*;
 
   import java.awt.*;
 
   import javax.swing.ImageIcon;

   public class puzzle 
   {
     	//object for puzzle piece image
      Image img;
   	
   	//dimensions for puzzle piece
      int x, y;
   	
   	//variable for platform death
      boolean isAlive = true;
      
   	//constructor for puzzle piece creation
      public puzzle(int startX, int startY, String location)
      {
         x = startX;
         y = startY;
         ImageIcon l = new ImageIcon(location);
         img = l.getImage();
      }
      
   	//methods to return puzzle piece dimensions
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
     
     	//method for puzzle piece movement
      public void move(int dx, int left)
      {
         if (dx == 1 && !((left + dx )< 150))
            x = x - (dx*2);
      }
   	
      public void move2(int dx, int left)
      {
         if(dx == 0 || dx == -1 || dx ==1)
         {         
            x = x - (1);
         }
      }
   	
      //method for dimensions of puzzle piece image
      public Rectangle getBounds()
      {
         return new Rectangle(x,y,50,50);
      }
   }
