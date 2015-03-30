import java.io.*;
import java.util.*;

public class DigitSolitaire
{
	public int convertChar(char c)
	{
		char nums[] = "0123456789".toCharArray();
		for (int i = 0; i < nums.length(); i++)
		{
			if (c == nums[i]) return i;
		}
		System.err.println("The character input is not a digit!!!");
		return -1;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			if (n <= 9) System.out.println(n);
			else
			{
			while (n > 9)
			{
				char chars[] = ("" + n).toCharArray();
				int m = chars.length();
				int nums[] = new int[n];
				for (int i = 0; i < m; i++)
				{
					nums[i] = convertChar(chars[i]);
				}

				int prod = nums[0];
				for (int i = 1; i < m; i++)
				{
					prod*=nums[i];
				}
				System.our.print(n);
			}
			
			}	
		}
	}

	public static void main(String args[])
	{
		new DigitSolitaire().doit();
	}
}