import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Knight
{
   public class Pair
   {
      int i, j;
      Pair(int i, int j)
      {
         this.i = i;
         this.j = j;
      }

      public String toString()
      {
         return "(" + i + "," + j +")";
      }
   }

   public Pair getPositionOf(char searchChar, char board[][], int r, int c)
   {
      for (int i = 0; i < r; i++)
         for (int j = 0; j < c; j++)
            if (searchChar == board[i][j])
               return new Pair(i,j);
      
      System.err.println("The character does not exist on the board!!!");
      return null;
   }

   public int getScore(int r, int c, char board[][])
   {
      int score[][] = new int[r][c];
      boolean beenHere[][] = new boolean[r][c];
      
      for (int i = 0; i < r; i++) Arrays.fill(score[i], Integer.MAX_VALUE);
      
      Pair p = getPositionOf('X', board, r, c);
      score[p.i][p.j] = 0;
      beenHere[p.i][p.j] = true;
      ArrayList<Pair> q = new ArrayList<Pair>();
      q.add(p);
      
      int dx[] = { 1, -1,  2, -2,  2, -2, -1,  1};
      int dy[] = { 2,  2,  1,  1, -1, -1, -2, -2};
      
      while (!q.isEmpty())
      {
         Pair currentLoc = q.remove(0);
         
         for (int k = 0; k < 8; k++)
         {
            int x = currentLoc.i + dx[k];
            int y = currentLoc.j + dy[k];
         
            if ((0<=x && x<r)
            &&  (0<=y && y<c))
            {
               if (board[x][y] != '#')
               {
                  score[x][y] = Math.min(score[currentLoc.i][currentLoc.j]+1, score[x][y]);
                  if (board[x][y] == 'K') 
                     return score[x][y];
                  if (!beenHere[x][y])
                  {
                     q.add(new Pair(x,y));
                     beenHere[x][y] = true;
                  }
               }
            }
         }
      }
   
      return -1;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      char board[][] = new char[n][m];
      sc.nextLine();
      for (int i = 0; i < n; i++) board[i] = sc.nextLine().toCharArray();
   
      System.out.println(getScore(n, m, board));
   }

   public void printoutBoard(int board[][], int r, int c)
   {
      for (int i = 0; i < r; i++)
      {
         for (int j = 0; j < c; j++)
         {
            if (board[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
            else System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static void main(String args[])
   {
      new Knight().doit();
   }
}