import java.io.*;
import java.util.*;

public class rps
{
	//		P2
	//			R 	P 	S
	// P1 	R   0   s2  s1
	//		P   s1  0   s2
	//		S   s2  s1  0

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		String p1 = sc.next();
		String p2 = sc.next();

		while (!p1.equals("E") && !p2.equals("E"))
		{
			int n = p1.length();
			int score1 = 0;
			int score2 = 0;
			
			for (int i = 0; i < n; i++)
			{
				char c1 = p1.charAt(i);
				char c2 = p2.charAt(i);
				if (c1 == 'R')
				{
					if (c2 == 'P')
					{
						score2++;
					}
					else if (c2 == 'S')
					{
						score1++;
					}
				}
				else if (c1 == 'P')
				{
					if (c2 == 'R')
					{
						score1++;
					}
					else if (c2 == 'S')
					{
						score2++;
					}
				}
				else if (c1 == 'S')
				{
					if (c2 == 'R')
					{
						score2++;
					}
					else if (c2 == 'P')
					{
						score1++;
					}
				}
			}

			System.out.println("P1: " + score1);
			System.out.println("P2: " + score2);
			p1 = sc.next();
			p2 = sc.next();
		}
	}

	public static void main(String args[])
	{
		new rps().doit();
	}
}