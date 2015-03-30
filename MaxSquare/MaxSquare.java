import java.io.*;
import java.util.*;


public class MaxSquare
{
   public int getMax(int board[][], int r, int c)
   {
      int most = Integer.MIN_VALUE;
      for (int i = 0; i < r; i++)
         for (int j = 0; j < c; j++)
            most = Math.max(most, board[i][j]);
      return most;
   }
   

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int r = sc.nextInt(); // The number of rows
         int c = sc.nextInt(); // The number of columns
         if (r==0) 
            break;
      
         int M[][] = new int[r][c]; // Let the given binary matrix be M[r][c]
         int S[][] = new int[r][c];
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               M[i][j] = sc.nextInt();
               // Here we are copying the first row and the leftmost column
               // into our score board.
               if ((i==0) || (j==0))
                  S[i][j] = M[i][j];
            }
         }
      
         int dx[] = {0, -1, -1};
         int dy[] = {-1, 0, -1};
         
         // For the next two for loops we go through every row and column
         // that is not within the first row or column.
         for (int i = 1; i < r; i++)
         {
            for (int j = 1; j < c; j++)
            {
               // If our board has a one at this location
               // then we set our scoreboard equal to the
               // minimum score surrounding our position (to
               // the left and top) and add one.
               if (M[i][j] == 1)
               {
                  int least = Integer.MAX_VALUE;
                  for (int k = 0; k < 3; k++)
                  {
                     int x = i+dx[k];
                     int y = j+dy[k];
                     if ((0<=x && x<r)
                     && (0<=y && y<c))
                     {
                        least = Math.min(least, S[x][y]);
                     }
                  }
                  S[i][j] = least+1;
               }
               else
               {
                  S[i][j] = 0;
               }
            }
         }
         System.out.println(getMax(S, r, c));
      }
   }
   
   public static void main(String args[])
   {
      new MaxSquare().doit();
   }
}