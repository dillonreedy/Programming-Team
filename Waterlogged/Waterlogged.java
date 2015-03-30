import java.io.*;
import java.util.*;
import java.awt.geom.*;
import java.text.*;

public class Waterlogged
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

   public class Quad implements Comparable<Quad>
   {
      double area, perimeter;
      Quad(double area, double perimeter)
      {
         DecimalFormat formatter = new DecimalFormat("#######.###");
         String areaNum = formatter.format(area);
         this.area = Double.parseDouble(areaNum);

         String perimNum = formatter.format(perimeter);
         this.perimeter = Double.parseDouble(perimNum);
      }

      public int compareTo(Quad q)
      {
         if (this.area > q.area)
         {
            return -1;
         }
         else if (this.area == q.area)
         {
            if (this.perimeter > q.perimeter)
            {
               return -1;
            }
            else if (this.perimeter == q.perimeter)
            {
               return 0;
            }
            else // if (this.perimeter < q.perimeter)
            {
               return 1;
            }
         }
         else // if (this.area < q.area)
         {
            return 1;
         }
      }
   }


   public double calculateTriangleArea(Point2D center, Point2D P, Point2D Q)
   {
      Line2D base = new Line2D.Double(P, Q);
      return (0.5 * base.ptLineDist(center) * P.distance(Q));
   }

   public double calculateTrianglePerimeter(Point2D center, Point2D P, Point2D Q)
   {
      return (center.distance(P) + center.distance(Q) + P.distance(Q));
   }

   public boolean isZero(double val)
   {
      return val == 0.0;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);

      for (;;)
      {
         ArrayList<Point2D> pts = new ArrayList<Point2D>();
         for (int i = 0; i < 4; i++) pts.add(new Point2D.Double(sc.nextDouble(), sc.nextDouble()));

         if (isZero(pts.get(0).getX()) && isZero(pts.get(0).getY()) && isZero(pts.get(1).getX()) && isZero(pts.get(1).getY())) break;
         
         Point2D center = intersection(new Line2D.Double(pts.get(0), pts.get(2)), new Line2D.Double(pts.get(1), pts.get(3)));

         pts.add(pts.get(0));

         Quad quads[] = new Quad[4];
         for (int i = 0; i < 4; i++) quads[i] = new Quad(calculateTriangleArea(center, pts.get(i), pts.get(i+1)), calculateTrianglePerimeter(center, pts.get(i), pts.get(i+1)));

         Arrays.sort(quads);

         for (Quad q : quads) System.out.printf("%.3f %.3f ", q.area, q.perimeter);

         System.out.println();
      }
   }

   public static void main(String args[])
   {
      new Waterlogged().doit();
   }
}