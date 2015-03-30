import java.io.*;
import java.util.*;

public class Grimm
{
	boolean isPrime[] = new boolean[100001];

	public int findNextPrime(ArrayList<Integer> q, long start, long findPrimeOf)
	{
		long n = ((long)Math.sqrt(findPrimeOf));
		for (long i = start; i < n; i++)
		{
			if (isPrime[((int) i)] && (findPrimeOf % i == 0L) && (!q.contains(((int) i)))) return ((int) i);
		}

		System.err.println("We couldn't find a number!");
		return -1;
	}

	public void doit()
	{
		Arrays.fill(isPrime, true);
		for (int i = 2; i < isPrime.length; i++)
		{
			if ((isPrime[i]) && (i*i<isPrime.length))
			{
				for (int j = i*i; j < isPrime.length; j+=i) isPrime[j] = false;
			}
		}
		System.out.println("This has executed");
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			long lo = sc.nextLong();
			long hi = sc.nextLong();
			if (lo == 0L && hi == 0L) break;

			ArrayList<Integer> nums = new ArrayList<Integer>();

			for (long i = lo; i < hi+1L; i++)
			{
				int result = findNextPrime(nums, 2L, i);
				nums.add(result);
			}

			System.out.println(nums.toString());
		}
	}

	public static void main(String args[])
	{
		new Grimm().doit();
	}
}