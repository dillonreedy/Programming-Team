import java.io.*;
import java.util.*;

public class PaintMe
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
     
      for (;;)
      {
         int n = sc.nextInt();
      // The plan is to paint the four walls and the ceiling of the main room.
         if (n==0) 
            break;
      
         int w = sc.nextInt();
         int l = sc.nextInt();
         int h = sc.nextInt();
         double area = sc.nextDouble();
         int m = sc.nextInt();
      
         int totalRoomArea = n*((2*l*h)+(2*w*h)+(w*l));
      
         int sum = 0;
         for (int i = 0; i < m; i++) sum+=(sc.nextInt()*sc.nextInt());
         sum*=n;
      
         System.out.println(((int) Math.ceil(((double) (totalRoomArea - sum))/area)));
      }
   }

   public static void main(String args[])
   {
      new PaintMe().doit();
   }
}