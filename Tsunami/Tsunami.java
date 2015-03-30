import java.io.*;
import java.util.*;
import java.awt.geom.*;

// |
// |      x
// | 
// | x         x
// |____________

public class Tsunami
{
	public class Pair implements Comparable<Pair>
	{
		int x, y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public double dist(Pair p)
		{
			return Math.hypot(this.x - p.x, this.y - p.y);
		}

		public int compareTo(Pair p)
		{
			if (this.y < p.y)
			{
				return 1;
			}
			else if (this.y == p.y)
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			Pair pts[] = new Pair[n];
			for (int i = 0; i < n; i++) pts[i] = new Pair(sc.nextInt(), sc.nextInt());

			Arrays.sort(pts);

			boolean visited[] = new boolean[n];
			double cost[] = new double[n];
			Arrays.fill(cost, Double.MAX_VALUE);
			cost[0] = 0.0;
			double total = 0.0;

			for (int i = 0; i < n; i++)
			{
				double least = Double.MAX_VALUE;
				int v = -1;
				for (int j = 0; j < n; j++)
				{
					if (!visited[j] && cost[j]<least)
					{
						v = j;
						least = cost[j];
					}
				}

				visited[v] = true;
				total+=least;

				for (int j = 0; j < n; j++)
				{
					double d = pts[v].dist(pts[j]);
					cost[j] = Math.min(cost[j], d);
				}
			}
			System.out.printf("%.2f",total);
			System.out.println();

		}
	}

	public static void main(String args[])
	{
		new Tsunami().doit();
	}
}