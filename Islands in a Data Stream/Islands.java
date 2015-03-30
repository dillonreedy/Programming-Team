import java.io.*;
import java.util.*;

public class Islands
{
	// 1 0 0

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		// An island in the sequence 
		int p = sc.nextInt();
		for (int i = 0; i < p; i++)
		{
			int probNum = sc.nextInt();
			int nums[] = new int[15];
			for (int j = 0; j < 15; j++) nums[j] = sc.nextInt();

			int count = 0;
			int prev = nums[0];
			for (int j = 1; j < 15; j++)
			{
				int cur = nums[j];
				if (cur > prev) count++;

				prev = cur;
			}

			System.out.println((i+1) + " " + count);
		}
	}

	public static void main(String args[])
	{
		new Islands().doit();
	}
}