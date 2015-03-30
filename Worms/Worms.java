import java.io.*;
import java.util.*;

// [0] = A->BC
// [1] = B->AC
// [2] = C->AB
// ABAC
// [1] ABB
// [2] CB
// [2] ABAC => 
public class Worms
{
	public class GrowthRule
	{
		String firstCell;
		String resultCell;
		GrowthRule(String firstCell, String resultCell)
		{
			this.firstCell = firstCell;
			this.resultCell = resultCell;
		}

		public String toString()
		{
			return (this.firstCell + "->" + this.resultCell);
		}
	}

	public int recurse(int maxDepth, GrowthRule gRules[], String currentStruct)
	{
		if (maxDepth == 0) return -1;
		if (currentStruct.length()==1) return 0;

		maxDepth--;
		int least = -1;
		for (GrowthRule g : gRules)
		{
			if (currentStruct.contains(g.resultCell))
			{
				int index = currentStruct.indexOf(g.resultCell);
				String possible = currentStruct.substring(0, index) + g.firstCell + currentStruct.substring(index+2, currentStruct.length());
				int result = recurse(maxDepth, gRules, possible);
				if (result != -1) least = Math.min(result+1, least);
			}
		}
		return least;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt(); // The number of growth rules.
			if (n==0) break;

			GrowthRule gRules[] = new GrowthRule[n];
			sc.nextLine();
			for (int i = 0; i < n; i++)
			{
				String line = sc.nextLine();
				gRules[i] = new GrowthRule(line.substring(0,1), line.substring(1,line.length()));
				System.out.println(gRules[i].toString());
			}

			String currentStruct = sc.nextLine();
			System.out.println(recurse(50, gRules, currentStruct));
		}
	}

	public static void main(String args[])
	{
		new Worms().doit();
	}
}