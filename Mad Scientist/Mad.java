import java.io.*;
import java.util.*;

public class Mad
{

	// 2 7 7 8 12 13
	// 2 5 0 1	4  1

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int k = sc.nextInt();
			if (k==0) break;

			int P[] = new int[k+1];
			P[0] = 0;
			for (int i = 1; i <= k; i++) P[i] = sc.nextInt();

			for (int i = k; i > 0; i--) P[i] = P[i]-P[i-1]

			for (int i = 1; i < k+1; i++)
			{
				for (int j = 0; j < P[i]; j++)
					System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new Mad().doit();
	}
}