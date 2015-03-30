// Problem1
import java.io.*;
import java.util.*;

public class Cut_Cake
{
   
   public class Point
   {
      double x, y;
      Point(double x, double y)
      {
         this.x = x;
         this.y = y;
      }
   }
   
   
   public class Line
   {
      Point P, Q;
      
      Line(Point P, Point Q)
      {
         this.P = P;
         this.Q = Q;
      }
   }
   
   
   
   public Point get_intersection_point(Point P, Point Q, Point R, Point S)
   {
      // | | P.x 1.0 | |  
      // | | Q.x 1.0 |
      // | -----------
      // | | R.x 1.0 |
      // | | 
      double d1 = crossProd((new Point(P.x, 1.0)), (new Point(Q.x, 1.0)));
      double d2 = crossProd((new Point(R.x, 1.0)), (new Point(S.x, 1.0)));
      double d3 = crossProd((new Point(P.y, 1.0)), (new Point(Q.y, 1.0)));
      double d4 = crossProd((new Point(R.y, 1.0)), (new Point(S.y, 1.0)));
      double d5 = crossProd(P,Q);
      double d6 = crossProd(R,S);
      
      Point P3 = new Point(d5, d1);
      Point Q3 = new Point(d6, d2);
      
      Point P4 = new Point(d1, d3);
      Point Q4 = new Point(d2, d4);
      
      Point P5 = new Point(d5, d3);
      Point Q5 = new Point(d6, d4);
      
      double Px_top = crossProd(P3, Q3);
      double Px_bot = crossProd(P4, Q4);;
      double Px = (Px_top / Px_bot);
      
      double Py_top = crossProd(P5, Q5);
      double Py = (Py_top / Px_bot);
      
      Point Pxy = new Point(Px, Py);
      
      return Pxy;
   }
   
   
   public double distance(Point P, Point Q)
   {
      return (Math.sqrt(Math.pow((P.x - Q.x),2) + Math.pow((P.y - Q.y),2)));
   }
   
   // The cross prod
   public double crossProd(Point P, Point Q)
   {
      return (P.x*Q.y - Q.x*P.y);
   }
   
   // Distance from a point S to a line |PQ|
   public double calculateDistFromLine(Point S, Point P, Point Q)
   {
      Point V = new Point((P.x - Q.x), (P.y - Q.y));
      Point PS = new Point((P.x - S.x), (P.y - S.y));
      
      return Math.abs(crossProd(PS, V)) / distance(P, Q);
   }
   
   
   public boolean insideCircle(Point centerPt, Point randomPt, double r)
   {
      return (distance(centerPt, randomPt) < r);
   }
   
   public boolean lineIntersectsCircle(Point centerPt, Point P, Point Q, double radius)
   {
      return (calculateDistFromLine(centerPt, P, Q) <= radius);
   }
   
   // Input will be of the form:
   // 
   // radius CenterPt n
   // L1
   // L2
   // ...
   // Ln
   
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         double radius = sc.nextDouble();
         Point centerPt = new Point(sc.nextDouble(), sc.nextDouble());
         int n = sc.nextInt();
         int c = 0; // The number of lines intersecting the circle.
         
         if (radius == 0.0 && centerPt.x == 0.0 && centerPt.y == 0.0 && n == 0) 
            break;
         
         Line lines[] = new Line[n];
         Arrays.fill(lines, null);
         
         for (int i = 0; i < n; i++)
         {
            Point P = new Point(sc.nextDouble(), sc.nextDouble());
            Point Q = new Point(sc.nextDouble(), sc.nextDouble());
            if (lineIntersectsCircle(centerPt, P, Q, radius))
            {
               lines[i] = new Line(P,Q);
               c++;
            }
         }
         
         int k = 0; // The number of intersection points inside the circle.
         
         for (int i = 0; i < n; i++)
         {
            for (int j = (i+1); j < n; j++)
            {
               if (lines[i] != null && lines[j] != null)
               {
                  Point intersectionPt = get_intersection_point(lines[i].P, lines[i].Q, lines[j].P, lines[j].Q);
                  if (insideCircle(centerPt, intersectionPt, radius)) k++;
               }
            }
         }
         System.out.println(c+k+1);
      }
      
   }

   public static void main(String args[])
   {
      new Cut_Cake().doit();
   }
}