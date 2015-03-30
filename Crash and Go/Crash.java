import java.io.*;
import java.util.*;
import java.text.*;

public class Crash
{
	public class Circle
	{
		double x, y, r;
		Circle() {}

		Circle(double x, double y, double r)
		{
			this.x = x;
			this.y = y;
			this.r = r;
		}

		public double distSq(Circle c)
		{
			return Math.pow((this.x-c.x),2) + Math.pow((this.y-c.y),2);
		}

		public String toString()
		{
			DecimalFormat formatter = new DecimalFormat("######.##");
			return "("+formatter.format(this.x)+", "+formatter.format(this.y)+", "+formatter.format(this.r)+")";
		}
	}

	public Circle calculateCircle(ArrayList<Circle> neighbors)
	{
		Circle newCircle = new Circle();
		for (Circle c : neighbors)
		{
			newCircle.x += c.x;
			newCircle.y += c.y;
			newCircle.r += c.r*c.r;
		}
		newCircle.x /= neighbors.size();
		newCircle.y /= neighbors.size();
		newCircle.r = Math.sqrt(newCircle.r);
		return newCircle;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		
		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			ArrayList<Circle> circles = new ArrayList<Circle>();
			ArrayList<Circle> input = new ArrayList<Circle>();
			for (int i = 0; i < n; i++) input.add(new Circle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));

			for (int i = 0; i < input.size(); i++)
			{
				Circle circle1 = input.get(i);
								
				for (;;)
				{
					ArrayList<Circle> neigbors = new ArrayList<Circle>();
					for (int j = 0; j < circles.size(); j++)
					{
						Circle circle2 = circles.get(j);
						double maxR = Math.max(circle1.r, circle2.r);

						if (maxR*maxR >= circle1.distSq(circle2))
						{
							neigbors.add(circle2);
							circles.remove(j);
							j=j-1;
						}
					}

					if (neigbors.size() != 0)
					{
						neigbors.add(circle1);
						circle1 = calculateCircle(neigbors);
					}
					else break;
				}
				circles.add(circle1);
			}

			System.out.println(circles.size());
		}
	}

	public static void main(String args[]) throws Exception
	{
		new Crash().doit();
	}
}