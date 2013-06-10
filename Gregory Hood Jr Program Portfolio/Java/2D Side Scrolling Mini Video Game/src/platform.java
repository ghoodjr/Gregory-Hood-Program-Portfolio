   import java.awt.*;
 
   import java.awt.*;
 
   import javax.swing.ImageIcon;

   public class platform 
   {
     	//object for platform image
      Image img;
   	
   	//dimensions for platform
      int x, y;
   	
   	//variable for platform death
      boolean isAlive = true;
      
   	//constructor for platform creation
      public platform(int startX, int startY, String location)
      {
         x = startX;
         y = startY;
         ImageIcon l = new ImageIcon(location);
         img = l.getImage();
      }
      
   	//methods to return platform dimensions
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
     
     	//method for platform movement
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
   	
      //method for dimensions of platform image
      public Rectangle getBounds()
      {
         return new Rectangle(x,y,479,190);
      }
   }
