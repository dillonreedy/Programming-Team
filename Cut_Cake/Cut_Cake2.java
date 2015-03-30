import java.io.*;
import java.util.*;
import java.awt.geom.*;
import java.lang.Object.*;
   
public class Cut_Cake2
{
   // This method calculates the cross product of the following matrix:
   // | P.getX() P.getY() |
   // | Q.getX() P.getY() |

   public double crossProd(Point2D P, Point2D Q)
   {
      return (P.getX()*Q.getY() - Q.getX()*P.getY());
   }

   // This method calculates the intersection point (if any)
   // of two lines (or line segments). This method cannot accomadate
   // parallel lines.
   public Point2D intersection(Line2D line1, Line2D line2)
   {
      Point2D P = line1.getP1();
      Point2D Q = line1.getP2();
      Point2D R = line2.getP1();
      Point2D S = line2.getP2();
      
      // d1 through d4 are actually crossproducts with y coordinates equal to one.
      double d1 = P.getX() - Q.getX();
      double d2 = R.getX() - S.getX();
      double d3 = P.getY() - Q.getY();
      double d4 = R.getY() - S.getY();
      double d5 = crossProd(P,Q);
      double d6 = crossProd(R,S);
      
      Point2D P3 = new Point2D.Double(d5, d1);
      Point2D Q3 = new Point2D.Double(d6, d2);
      
      Point2D P4 = new Point2D.Double(d1, d3);
      Point2D Q4 = new Point2D.Double(d2, d4);
      
      Point2D P5 = new Point2D.Double(d5, d3);
      Point2D Q5 = new Point2D.Double(d6, d4);
      
      double Px_top = crossProd(P3, Q3);
      double Px_bot = crossProd(P4, Q4);;
      double Px = (Px_top / Px_bot);
      
      double Py_top = crossProd(P5, Q5);
      double Py = (Py_top / Px_bot);
      
      return new Point2D.Double(Px, Py);  
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         double r = sc.nextDouble();
         Point2D centerPt = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
         int n = sc.nextInt();
         ArrayList<Line2D> lines = new ArrayList<Line2D>();
         
         if (n==0) 
            break;
      
         for (int i = 0; i < n; i++)
         {
            Line2D line = new Line2D.Double(new Point2D.Double(sc.nextDouble(), sc.nextDouble()), new Point2D.Double(sc.nextDouble(), sc.nextDouble()));
            if (line.ptLineDist(centerPt) <= r) lines.add(line);
         }
      
         int k = 0; // The number of intersection points inside the circle
      
         for (int i = 0; i < lines.size(); i++)
         {
            Line2D line_i = lines.get(i);
            for (int j = (i+1); j < lines.size(); j++)
            {
               Line2D line_j = lines.get(j);
               Point2D intersectionPt = intersection(line_i, line_j);
               if (centerPt.distance(intersectionPt) < r) k++;
            }
         }
         System.out.println(lines.size()+k+1);
      }
   }

   public static void main(String args[])
   {
      new Cut_Cake2().doit();
   }
}