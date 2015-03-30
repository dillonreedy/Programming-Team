import java.io.*;
import java.util.*;

public class NonogramTest
{
   public void doit()
   {
      String str = "X.X.X";
      
      String result = "";
      while (str.indexOf('.') != -1)
      {
         int indexOfDot = str.indexOf('.');
         if (indexOfDot != 0)
         {
            result+=indexOfDot+" ";
         }
         // "X..X"
         // indexOfDot = 1
         str = str.substring(indexOfDot+1,str.length());
      }
      
      if (str.length() != 0)
      {
         result+=(str.length());
      }
      
      System.out.println(result);
   }

   public static void main(String args[])
   {
      new NonogramTest().doit();
   }
}