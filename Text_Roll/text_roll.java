import java.io.*;
import java.util.*;

public class text_roll
{
   
   // Given a line, starting at the previous
   // fall thru pt, this will return the
   // length of the line if the input has 
   // no fall through point or it will return
   // the next closest fall through pt
   public int findFallThruPt(String line, int prevFallThruPt)
   {
      char chars[] = line.toCharArray();
      int i;
      
      if (line.length() < prevFallThruPt)
         return prevFallThruPt;
      
      for (i = prevFallThruPt; i < chars.length; i++)
      {
         if (chars[i] == ' ')
            break;
      }
      
      return i;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         int dist = 0;
         for (int i = 0; i < (n+1); i++)
         {  
            dist = findFallThruPt(sc.nextLine(), dist);
         }
         System.out.println((dist+1));
      }
      
   }

   public static void main(String args[])
   {
      new text_roll().doit();
   }
}