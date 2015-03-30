import java.io.*;
import java.util.*;

public class HillTest
{
	public String removeDuplicates(String num)
	{
		String result = "" + num.charAt(0);
		
		for (int i = 1; i < num.length(); i++)
		{
			if (num.charAt(i-1) != num.charAt(i)) result = result + num.charAt(i);
		}

		return result;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++)
		{
			System.out.println(removeDuplicates(sc.nextLine()));
		}


		long most = Long.MIN_VALUE;
		for (long i = 1000000000000000000L; i >= 0L; i--)
		{
			String result = removeDuplicates(i+"");
			long res = Long.parseLong(result, 10);
			most = Math.max(res, most);
			
			if (i%100000L == 0L) System.out.println(most);

		}
	}

	public static void main(String args[])
	{
		new HillTest().doit();
	}
}