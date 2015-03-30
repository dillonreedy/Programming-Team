import java.io.*;
import java.util.*;

public class Hill
{
	// The numbers never decrease 

	public boolean doesDecrease(String num)
	{
		for (int i = 1; i < num.length(); i++)
		{
			if (num.charAt(i-1) > num.charAt(i)) return true;
		}
		return false;
	}

	public String removeAdjacentDuplicates(String orig)
	{
		String result = "" + orig.charAt(0);
		for (int i = 1; i < orig.length(); i++)
			if (orig.charAt(i-1) != orig.charAt(i))
				result+=orig.charAt(i);
		return result;
	}

	public boolean isHill(String num)
	{
		num = removeAdjacentDuplicates(num);

		if (num.length() <= 2) return true;

		if (num.charAt(0) < num.charAt(1))
		{
			if (doesDecrease(num))
			{
				// must increase then decrease
				int indexDec = 0;
				for (int i = 1; i < num.length(); i++)
				{
					if (num.charAt(i-1) > num.charAt(i))
					{
						indexDec = i;
						break;
					}
				}

				for (int i = 1; i < indexDec; i++)
					if (num.charAt(i-1) > num.charAt(i)) return false;

				for (int i = indexDec; i < num.length(); i++)
					if (num.charAt(i-1) < num.charAt(i)) return false;

				return true;
			}
			else
			{
				// The numbers must continually increase to the end here
				for (int i = 1; i < num.length(); i++)
					if (num.charAt(i-1) > num.charAt(i)) return false;

				return true;
			}
		}
		else // The numbers must continually decrease from here 
		{
			for (int i = 1; i < num.length(); i++)
				if (num.charAt(i-1) < num.charAt(i)) return false;

			return true;
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		if (!isHill(n+"")) System.out.println("-1");
		else
		{
			long count = 0L;
			for (long i = 1L; i <= n; i++)
			{
				if (isHill(i+"")) count++;
				
			}
			System.out.println(count);
		}
	}

	public static void main(String args[])
	{
		new Hill().doit();
	}
}