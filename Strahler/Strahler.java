import java.io.*;
import java.util.*;



public class Strahler
{
	public class Node 
	{
		ArrayList<Integer> in;
		Node()
		{
			this.in = new ArrayList<Integer>();
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int dataSet = sc.nextInt(); // The data set number.
			int m = sc.nextInt(); // The number of nodes in the graph
			int p = sc.nextInt(); // The number of edges.

			Node r[] = new Node[m+1];
			for (int j = 0; j < m+1; j++) r[j] = new Node();

			for (int j = 0; j < p; j++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				r[b].in.add(a);
			}

			ArrayList<Integer> order = new ArrayList<Integer>();
			for (int j = 0; j < m+1; j++) order.add(0);
			
			for (int j = 0; j < m; j++) if (r[j].in.size() == 0) order.set(j, 1);

			while (order.get(m) == 0)
			{
				for (int j = 1; j<=m; j++) // Iterate through all the nodes, beginning at 1.
				{
					if (order.get(j) == 0 && r[j].in.size() > 0)
					{
						boolean seenZero = false;
						int max_order = 0; // Maximum order of upstream nodes.
						int num_max = 0; // Number of nodes with that order.

						for (int k = 0; k<r[j].in.size(); ++k)
						{
							int node = r[j].in.get(k);

							if (order.get(node) == 0) seenZero = true;

							if (order.get(node) == max_order) ++num_max;

							if (order.get(node) > max_order)
							{
								max_order = order.get(node);
								num_max = 1;
							}

						}

						if (!seenZero)
						{
							if (num_max>=2)
							{
								order.set(j, max_order+1);
							}
							else
							{
								order.set(j, max_order);
							}
						}
					}
				}
			}
			System.out.println(dataSet + " " + order.get(m));
		}

	}

	public static void main(String args[])
	{
		new Strahler().doit();
	}
}