import java.io.*;
import java.util.*;

public class Shuffles
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) nums[sc.nextInt()-1] = i;

		int count = 1;
		for (int i = 1; i < n; i++) if (nums[i] < nums[i-1]) count++;

		double solution = (Math.log(count)/Math.log(2));
		System.out.println((int)Math.ceil(solution));
	}

	public static void main(String args[])
	{
		new Shuffles().doit();
	}
}