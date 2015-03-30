import java.io.*;
import java.util.*;
import java.math.*;

public class Egyptian
{
	public static long MAX = 1000000;

	// m = 3
	// n = 4
	// denom = (n+m-1)/m => (4+3-1)/3 => 8/3 => 2
	// m*denom-n => 3*2-4 => 2
	// n*denom => 4*2 => 8
	// c = gcd(8,2) => 2
	//

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			long m = sc.nextLong();
			long n = sc.nextLong();
			if (m==0) break;

			String sep = "";
			while (m > 0)
			{
				long c;
				long denom = (n+m-1)/m;

				for (;;)
				{
					BigInteger aBig = new BigInteger(""+(m*denom-n));
					BigInteger bBig = new BigInteger(""+(n*denom));
					c = aBig.gcd(bBig).longValue();
					if (n*denom/c < MAX) break;
					denom++;
				}

				System.out.print(sep + denom);
				sep = " ";
				m = (m*denom - n)/c;
				n = n*denom/c;
			}
			System.out.println();

		}
	}

	public static void main(String args[])
	{
		new Egyptian().doit();
	}
}