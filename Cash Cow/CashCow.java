import java.io.*;
import java.util.*;

public class CashCow
{
   public static final int R = 12;
   public static final int C = 10;

   public class Pair
   {
      int i, j;
      Pair(int i, int j)
      {
         this.i = i;
         this.j = j;
      }
   }

   public char[][] removeFromBoard(int i, int j, char table[][])
   {  
      if (table[i][j] == ' ') 
         return table;
    
      int dx[] = {1, 0, 0, -1};
      int dy[] = {0, -1, 1, 0};
      char searchChar = table[i][j];
      ArrayList<Pair> q = new ArrayList<Pair>();
      q.add(new Pair(i, j));
      int count = 1;
      ArrayList<Pair> results = new ArrayList<Pair>();
      results.add(new Pair(i, j));
      boolean beenHere[][] = new boolean[R][C];
      beenHere[i][j] = true;
      
      while (!q.isEmpty())
      {
         Pair currentLoc = q.remove(0);
         for (int k = 0; k < 4; k++)
         {
            int x = currentLoc.i+dx[k];
            int y = currentLoc.j+dy[k];
         
            if ((0<=x && x<R)
            && (0<=y && y<C))
            {
               if ((table[x][y] == searchChar) && (!beenHere[x][y]))
               {
                  q.add(new Pair(x, y));
                  results.add(new Pair(x, y));
                  beenHere[x][y] = true;
                  count++;
               }
            }
         }
      }

      if (count > 2)
      {
         for (int k = 0; k < results.size(); k++) table[results.get(k).i][results.get(k).j] = ' ';
      }
      
      return table;
   }
   
   public char[][] makeColFall(int j, char board[][])
   {
      String col = "";
      for (int i = 0; i < R; i++) col+=board[i][j]; // Make a string of column j, with the leftmost character being the topmost character.   
      
      col = col.replaceAll("\\s+",""); // Remove all the white space thus moving the characters down the column
      
      for (int i = 0; i < (R-col.length()); i++) board[i][j] = ' '; // Add back in the whitespace, onto the top of the column.
      
      // recopy back into the table.
      int count = 0;
      for (int i = (R-col.length()); i < R; i++)
      {
         board[i][j] = col.charAt(count);
         count++; 
      }
      return board;
   }

   // 
   // ' '

   public char[][] shiftLeft(char board[][])
   {


      for (int j1 = C-1; j1 >= 0; j1--)
      {
         if (board[R-1][j1] == ' ') // If the bottomost row, at column j has an empty character
         {                          // then the entire column is empty, therefore this column must
                                    // therefore this column must be shifted to the rightmost col position.
            // Copy the last column into a column, then make it blank
            char copy[] = new char[R];
            for (int i = 0; i < R; i++)
            {
               copy[i] = board[i][C-1]; 
               board[i][C-1] = ' ';
            }

            // Starting at the second to rightmost column
            // 1.) Copy all the elements in from the copy column into the board
            // 2.) 
            for (int j2 = C-2; j2 >= j1; j2--)
            {
               for (int i = 0; i < R; i++)
               {
                  char temp = board[i][j2];
                  board[i][j2] = copy[i];
                  copy[i] = temp;
               }
            }
         }
      }
   
      return board;
   }

   public char[][] updateBoard(char board[][], int user_i, int user_j)
   {
      //printoutBoard(board);
      board = removeFromBoard(user_i, user_j, board);
      //printoutBoard(board);
      for (int j = 0; j < C; j++) board = makeColFall(j, board);   
      //printoutBoard(board);
      board = shiftLeft(board);
      //printoutBoard(board);
      return board;
   }

   public void doit()
   {
      // Scanner sc = new Scanner(new File("cashCowInput.txt"));
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int t = sc.nextInt();
         if (t==0) 
            break;
         sc.nextLine();
      
         char board[][] = new char[R][C];
         for (int i = 0; i < R; i++)
            board[i] = sc.nextLine().trim().toCharArray();
      
         for (int i = 0; i < t; i++)
         {   
            int user_j = "abcdefghij".indexOf(sc.next());
            int user_i = 12-sc.nextInt();
            
            board = updateBoard(board, user_i, user_j);
            //printoutBoard(board);
            //System.out.println();
         }
         
         int count = 0;
         for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
               if (board[i][j] != ' ') count++;
               
         System.out.println(count);
      }
   }
   
   public void printoutBoard(char board[][])
   {
      for (int i = 0; i < R; i++)
      {
         for (int j = 0; j < C; j++)
         {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();
          
   }
   
   public static void main(String args[])
   {
      new CashCow().doit();
   }
}