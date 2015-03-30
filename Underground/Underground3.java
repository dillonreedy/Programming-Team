import java.io.*;
import java.util.*;

public class Underground3
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			int x[] = new int[n];
			int y[] = new int[n];
			double cost[] = new double[n];
			boolean beenHere[] = new boolean[n];

			for (int i = 0; i < n; i++)
			{
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}


			Arrays.fill(cost, Double.MAX_VALUE);
			cost[0] = 0.0;
			double total = 0.0;

			for (int i = 0; i < cost.length; i++)
			{
				double least = Double.MAX_VALUE;
				int v = -1;
				for (int j = 0; j < cost.length; j++)
					if (!beenHere[j] && cost[j]<least)
					{
						v = j;
						least = cost[j];
					}

				beenHere[v] = true;
				total+=least;

				for (int j = 0; j < cost.length; j++)
				{
					double d = Math.hypot(x[v]-x[j], y[v]-y[j]);
					cost[j] = Math.min(cost[j], d);
				}
			}
			System.out.printf("%.2f", total);
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new Underground3().doit();
	}
}