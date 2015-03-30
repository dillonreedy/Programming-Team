// Given n nodes, and t edges of an undirected graph
// find how many 3 node cycles there are within the graph.
import java.io.*;
import java.util.*;

public class GoogleProblem
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		boolean edgeTo[][] = new boolean[n][n];
		for (int i = 0; i < t; i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			edgeTo[u][v] = true;
			edgeTo[v][u] = true;
		}

		// 0 1 1
		// 1 0 1
		// 1 1 0

		// 0--1
		// |\/|
		// |/\| 
		// 2--3

		// 0-1-2
		// 0-1-3
		// 0-2-3
		// 1-2-3

		// 0--1
		// | /
		// |/
		// 2  3

		// 0-1-2
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = i+1; j < n; j++)
			{
				if (edgeTo[i][j])
				{
					for (int k = j+1; k < n; k++) if ((edgeTo[i][k]) && edgeTo[j][k]) count++;
					
					edgeTo[i][j] = false;
					edgeTo[j][i] = false;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String args[])
	{
		new GoogleProblem().doit();
	}
}