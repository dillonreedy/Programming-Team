import java.io.*;
import java.util.*;

public class Pisano
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (;;)
		{
			int p = sc.nextInt();
			int m = sc.nextInt();

			if (m!=2)
			{
				int nSeq = 2;
				int f1 = 1;
				int f2 = 1;
				for (;; nSeq+=2)
				{
					f1 = (f1+f2)%m;
					f2 = (f2+f1)%m;
					if (f1 == 1 && f2 == 1) break;
				}

				System.out.println(p + " " + nSeq);
			}
			else
			{
				System.out.println(p + " 3");
			}
			if (n==p) break;
		}
	}

	public static void main(String args[])
	{
		new Pisano().doit();
	}
}