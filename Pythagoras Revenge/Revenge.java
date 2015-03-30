import java.io.*;
import java.util.*;

// a*a 	= c*c - b*b
//		= (c-b)*(c+b)
// 
// Look for a factor a*a = x*y, b = (y-x)/2, such that a < (y-x)/2

public class Revenge
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int a = sc.nextInt();
			if (a==0) break;

			long a2 = (long) a*a;
			int count = 0;

			for (long x = ((long) ((Math.sqrt(2)-1)*a)); x > 0; x--)
			{
				if (a2 % x == 0 && (a2/x - x) % 2 == 0) count++;
			}

			System.out.println(count);
		}
	}
}