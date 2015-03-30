// Given a sequence of N numbers A[1], A[2], .. , A[N]
// Find the length of the longest non-decreasing sequence
import java.io.*;
import java.util.*;

public class Sequence
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         Pattern pattern;
         Matcher matcher;
         
         pattern = Pattern.compile(<REGEX>);
         matcher = pattern.matcher(<INPUT>);
         boolean found;
         
         while (matcher.find())
         {
            System.out.println("Found the text \"" + matcher.group() +  "\" starting at index " + matcher.start() +
      " and ending at index " + matcher.end() + ".");
         found = true;
  
         }
      }
   }
   
   public static void main(String args[])
   {
      new Sequence().doit();
   }
}