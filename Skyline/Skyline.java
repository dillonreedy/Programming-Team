import java.io.*;
import java.util.*;

// No buildings such that:
// 1 <= i < j
// 1 <= j < k
// 1 <= k <= N
//

public class Skyline
{
	public int factorial(int n)
	{
		if (n==0 || n==1)
		{
			return 1;
		}
		else
		{
			return n*factorial(n-1);
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			int heights[i] = new int[n];
			for (int i = 0; i < n; i++) heights[i] = i+1;
			
			// If there is one tri-pair of three numbers ascending, then we can reduce the 
			// result by one.
		}
	}

	public static void main(String args[])
	{
		new Skyline().doit();
	}
}