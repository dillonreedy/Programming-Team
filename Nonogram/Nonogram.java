import java.io.*;
import java.util.*;

public class Nonogram
{
	// This method shall return a string of the requested column given the character board
   public String getCol(char board[][], int col, int n)
   {
      String result = "";
      for (int i = 0; i < n; i++)
      {
         result+=board[col][i];
      }
      return result;
   }

   public String getRow(char board[][], int row, int n)
   {
      String result = "";
      for (int i = 0; i < n; i++)
      {
         result+=board[i][row];
      }
      return result;
   }

   public String getScore(String str)
   {
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
      
      if (result.equals(""))
      {
         result = "0";
      }
      return result;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         sc.nextLine();
      
         char board[][] = new char[n][n];
         for (int i = 0; i < n; i++)
         {
            board[i] = sc.nextLine().toCharArray();
         }
      
         
         for (int i = 0; i < n; i++)
         {
            String col = getCol(board, i, n);
            System.out.println(getScore(col));
         }
      
         for (int i = 0; i < n; i++)
         {
            String row = getRow(board, i, n);
            System.out.println(getScore(row));
         }
      
      }
   }

   public static void main(String args[])
   {
      new Nonogram().doit();		
   }
}