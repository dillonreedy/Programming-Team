import java.io.*;
import java.util.*;

public class Arabia
{
	public int calculateScore(int nums[])
	{
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			for (int j = i+1; j < nums.length; j++)
				sum+=nums[i]*nums[j];

		return sum;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt(); // The number of depots.
			int m = sc.nextInt(); // The number of attacks that we can make.
			if (n==0) break;

			int depotScore[] = new int[n];
			for (int i = 0; i < n; i++) depotScore[i] = sc.nextInt();

			int best[] = new int[n-1];
			Arrays.fill(best, Integer.MAX_VALUE);

			for (int i = 0; i < n-1; i++)
			{
				
			}

		}
	}

	public static void main(String args[])
	{
		new Arabia().doit();
	}
}