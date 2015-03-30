import java.io.*;
import java.util.*;

public class Heart
{
	// 8 10
	// [0] = 4 1 3
	// [1] = 4 1 3
	// [2] = 3 3 4 5 7
	// [3] = 2 4 0 1 4 6
	// [4] = 3 4 3 2 5 7
	// [5] = 3 3 2 4 7
	// [6] = 4 1 3
	// [7] = 3 3 2 4 5


	// 100-----200
	//  |       |
	//  |       |
	//  |       |
	// 500----1000

	// Troops in a city can be used to defend that city, as well as any of its neighbors.


	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt(); // 3 <= N <= 1000, the number of cities
			int k = sc.nextInt(); // The number of troops required to defend a city.
			if (n==0) break;

			int troopsInCity[] = new int[n];
			boolean edgeTo[][] = new boolean[n][n];

			for (int u = 0; u < n; u++)
			{
				troopsInCity[u] = sc.nextInt();
				int m = sc.nextInt(); // The number of highways going out of this city.
				for (int j = 0; j < m; j++)
				{
					int v = sc.nextInt();
					edgeTo[u][v] = true;
				}
			}



			boolean isDefensible[] = new boolean[n];
			Arrays.fill(isDefensible, true);
			for (int i = 0; i < n; i++) // For every city
			{
				int sum = troopsInCity[i];
				for (int j = 0; j < n; j++) // We get a sum of the number of troops we can place within this city
					if (edgeTo[i][j])
						sum+=troopsInCity[j];

				if ((sum<k) && (isDefensible[i])) // If the number of troops 
				{
					// Then the city is indefensible, thus erase all edges to this city
					for (int j = 0; j < n; j++)
					{
						edgeTo[i][j] = false;
						edgeTo[j][i] = false;
					}
					isDefensible[i] = false;
					i=-1; // We have to recalculate all other cities now that 
						  // this cities troops have been lost, and account for 
						  // the increment
				}
			}

			int troopSum = 0;
			int cityCount = 0;
			for (int i = 0; i < n; i++)
				if (isDefensible[i])
				{
					troopSum+=troopsInCity[i];
					cityCount++;
				}

			System.out.println(cityCount + " " + troopSum);
		}
	}

	public static void main(String args[])
	{
		new Heart().doit();
	}
}