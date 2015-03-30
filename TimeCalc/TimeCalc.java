import java.io.*;
import java.util.*;

public class TimeCalc
{
	// f(i) = f(i-1)%12+1


	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++)
		{
			int sh = sc.nextInt(); // The hour at which the contest starts
			int sm = sc.nextInt(); // The minute at which the contest starts
			int dh = sc.nextInt(); // The duration of the contest in hours
			int dm = sc.nextInt(); // The duration of the contest in minutes

			int resultH[] = new int[dh+((sm+dm)/60)+1];
			resultH[0] = sh;
			for (int j = 1; j < resultH.length; j++)
			{
				resultH[j] = (resultH[j-1]%12)+1;
			}

			int resultM[] = new int[resultH.length];
			resultM[0] = -1*sm;
			for (int j = 1; j < resultM.length; j++)
			{
				resultM[j] = resultM[j-1]+60;
			}


			System.out.println("------+---------");
			System.out.println(" time | elapsed ");
			System.out.println("------+---------");

			for (int j = 0; j < resultH.length; j++)
			{
				if (resultH[j] < 10)
				{
					if (resultM[j] == 0)
					{
						System.out.println(" " + resultH[j] + ":XX | XX");
					}
					else
					{
						if (j==0)
						{
							System.out.println(" " + resultH[j] + ":XX | XX - " + Math.abs(resultM[j]));
						}
						else
						{
							System.out.println(" " + resultH[j] + ":XX | XX + " + resultM[j]);
						}
					}
				}
				else
				{
				
					if (resultM[j] == 0)
					{
						System.out.println(resultH[j] + ":XX | XX");
					}
					else
					{
						if (j==0)
						{
							System.out.println(resultH[j] + ":XX | XX - " + Math.abs(resultM[j]));
						}
						else
						{
							System.out.println(resultH[j] + ":XX | XX + " + resultM[j]);
						}
					}
				}
			}
		}
	}

	public static void main(String args[])
	{
		new TimeCalc().doit();
	}
}