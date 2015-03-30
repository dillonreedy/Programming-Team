import java.io.*;
import java.util.*;

public class Marble
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
		
		if (n==1)
		{
			System.out.println("0 0");
		}
		else if (n==2)
		{
			System.out.println((nums[0]+nums[1]) + " " + Math.min(nums[0], nums[1]));
		}
		else
		{
			long sum = 0;
			for (int i = 0; i < n; i++) sum+=nums[i];
			
			int move[] = new int[n];
			int stay[] = new int[n];	
			
			int moves = nums[0]+nums[n-1];
			nums[1] += nums[0];
			nums[n-2]+=nums[n-1];
			for (int i = 1; i < (n-1); i++)
			{
				move[i] = nums[i] + Math.min(move[i-1], stay[i-1]);
				stay[i] = move[i-1];
			}
			moves+=Math.min(move[n-2], stay[n-2]);
				System.out.println((2*sum) + " " + moves);
		}
	}

	public static void main(String args[])
	{
		new Marble().doit();
	}
}