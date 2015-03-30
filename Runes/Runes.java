import java.io.*;
import java.util.*;

public class Runes
{
	public int indexOfOp(String str)
	{
		int i = 0;
		while (str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '*') i++;
		return i;
	}

	public boolean startsWithZero(String str)
	{
		return str.startsWith("0") || str.startsWith("-0");
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine().trim();

		boolean digitWorks = true;
		for (int i = 0; i < 10; i++)
		{
			String possible = line.replaceAll("\\?", ""+i);
			// One of the numbers begin with a zero.
			// Detect 
			int equalIndex = line.indexOf("=");
			if (line.startsWith("-"))
			{
				int opIndex = indexOfOp(line.substring(1,line.length()))+1;
				String num1 = line.substring(0, opIndex);

				if (!startsWithZero(num1) || num1.equals("0"))
				{
					char op = line.charAt(opIndex);
					String num2 = line.substring(opIndex+1, line.indexOf("="));
					if (!startsWithZero(num2))
					{
						String num3 = line.substring(equalIndex, line.length());
						if (!startsWithZero(num3))
						{

						}
					}
				}
			}
			else
			{
				int opIndex = indexOfOp(line);
				String num1 = line.substring(0, indexOfOp(line));
				if (!num1.startsWith("0"))
				{
					char op = line.charAt(indexOfOp(line));
				}
			}
		}

		if (!digitWorks) System.out.println("-1");
	}

	public static void main(String args[])
	{
		new Runes().doit();
	}
}