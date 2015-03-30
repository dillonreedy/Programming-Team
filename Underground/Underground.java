import java.io.*;
import java.util.*;
import java.awt.geom.*;
import java.text.*;

public class Underground
{
   public class Point implements Comparable<Point>
   {
      double x, y;
      Point(double x, double y)
      {
         this.x = x;
         this.y = y;
      }  
      
      public int compareTo(Point P)
      {
         if (this.x < P.x)
         {
            return -1;
         }
         else if (this.x > P.x)
         {
            return 1;
         }
         else
         {
            if (this.y < P.y)
            {
               return -1;
            }
            else if (this.y > P.y)
            {
               return 1;
            }
            else
            {
               return 0;
            }
         }
      }
      
      public double distance(Point Q_orig)
      {
         Point2D P = new Point2D.Double(this.x, this.y);
         Point2D Q = new Point2D.Double(Q_orig.x, Q_orig.y);
         
         return P.distance(Q);
      }
      
      public double getX()
      {
         return this.x;   
      }
      
      public double getY()
      {
         return this.y;
      }
      
      public String toString()
      {
         return "("+ this.x +","+ this.y +")";
      }
   }

   public boolean lineCuts(ArrayList<Line2D> lines, Line2D cut)
   {
      for (int k = 0; k < lines.size(); k++)
      {
         Line2D line = lines.get(k);
         if (line.intersectsLine(cut)) 
            return true;
      }
      return false;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
      
         Point pts[] = new Point[n];
         for (int i = 0; i < n; i++) pts[i] = new Point(sc.nextDouble(), sc.nextDouble());
      
         Arrays.sort(pts);
         
         double weights[][] = new double[n][n];
      
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
               weights[i][j] = pts[i].distance(pts[j]);
         
         // printoutPts(pts);
         // printoutBoard(weights, n, n);
         
         double sum = 0.0;
         double score[] = new double[n];
         boolean chosen[][] = new boolean[n][n];
         ArrayList<Line2D> lines = new ArrayList<Line2D>();
      
         for (int k = 1; k < n; k++)
         {
            int x = 0;
            int y = 0;
            double least = Double.MAX_VALUE;
            Line2D resultCut = null;
         
            for (int i = 0; i < n; i++)
            {
               for (int j = 0; j < n; j++)
               {
                  if (!chosen[i][j])
                  {
                     Point2D P = new Point2D.Double(pts[i].getX(), pts[i].getY());
                     Point2D Q = new Point2D.Double(pts[j].getX(), pts[j].getY());
                     Line2D cut = new Line2D.Double(P, Q);
                     if ((weights[i][j] < least) && (i!=j))
                     {
                        if (!lineCuts(lines, cut))
                        {
                           least = weights[i][j];
                           resultCut = cut;
                           x = i;
                           y = j;
                        }
                     }   
                  }
               }
            }
            
         
            sum+=least;   
            chosen = fillRow(chosen, n, x);
            chosen = fillCol(chosen, n, y);
            lines.add(resultCut);
         }
         System.out.println(formatString(sum));
      }
   }

   public String formatString(double num)
   {
      DecimalFormat myFormatter = new DecimalFormat("#####.00");
      return myFormatter.format(num);   
   }
   
   public void printoutBoard(double board[][], int r, int c)
   {
      for (int i = 0; i < r; i++)
      {
         for (int j = 0; j < c; j++)
         {
            System.out.print(formatString(board[i][j]) + " ");
         }
         System.out.println();
      }
   }
   
   public void printoutPts(Point pts[])
   {
      for (Point P : pts) System.out.println(P.toString());
   }
   
   public boolean[][] fillRow(boolean table[][], int c, int i)
   {
      for (int j = 0; j < c; j++)
      {
         table[i][j] = true;
      }
      return table;
   }
   
   public boolean[][] fillCol(boolean table[][], int r, int j)
   {
      for (int i = 0; i < r; i++)
      {
         table[i][j] = true;
      }
      return table;
   }
   

   public static void main(String args[])
   {
      new Underground().doit();
   }
}