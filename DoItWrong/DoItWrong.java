import java.io.*;
import java.util.*;

public class DoItWrong
{
	public class Wrong implements Comparable<Wrong>
	{
		long a, m;
		Wrong(long a, long m)
		{
			this.a = a;
			this.m = m;
		}

		public String toString()
		{
			return ("" + this.a + "/" + this.m);
		}

		public int compareTo(Wrong w)
		{
			double thisA = ((double) this.a);
			double thisM = ((double) this.m);
			double wA = ((double) w.a);
			double wM = ((double) w.m);

			if ((thisA/thisM) < (wA/wM))
			{
				return -1;
			}
			else if ((thisA/thisM) > (wA/wM))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}


	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			long b = sc.nextLong();
			long n = sc.nextLong();
			if (n==0L && b==0L) break;

			ArrayList<Wrong> q = new ArrayList<Wrong>();
			for (long m = 1; m <= (2L*n); m+=1L)
			{
				if (m!=n)
				{
					if (((b*m)*(2L*n-m))%(n*n) == 0L)
					{
						long a = ((b*m)*(2L*n-m))/(n*n);
						q.add(new Wrong(a, m));
					}
				}
			}

			Wrong wrongs[] = new Wrong[q.size()];
			for (int i = 0; i < q.size(); i++) wrongs[i] = q.get(i);

			Arrays.sort(wrongs);

			for (Wrong w : wrongs)
			{
				System.out.print(w.toString() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new DoItWrong().doit();
	}
}