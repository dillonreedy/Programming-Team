import java.util.*;
import java.io.*;

public class newRunes
{
	public boolean startsWithZero(String str)
	{
		return ((str.startsWith("0")) || (str.startsWith("-0")));
	}

	public boolean isValidExpression(String str)
	{
		int equalIndex = str.indexOf("=");
		String leftSide = str.substring(equalIndex, str.length());
		str = str.substring(equalIndex, str.length());

		if (startsWithZero(leftSide)) return false;

		if (str.contains("*"))
		{
			int multiplicationIndex = str.indexOf("*");
			String leftNum = str.substring(0,multiplicationIndex-1);
			String rightNum = str.substring(multiplicationIndex+1, str.length());
			if (startsWithZero(leftNum) || startsWithZero(rightNum)) return false;

			long a = Long.parseLong(leftNum);
			long b = Long.parseLong(rightNum);
			long c = Long.parseLong(leftSide);
			return ((a*b)==c);
		}
		else if (str.contains("+"))
		{
			int additionIndex = str.indexOf("+");
			String leftNum = str.substring(0,additionIndex-1);
			String rightNum = str.substring(additionIndex+1,str.length());
			if (startsWithZero(leftNum) || startsWithZero(rightNum)) return false;

			long a = Long.parseLong(leftNum);
			long b = Long.parseLong(rightNum);
			long c = Long.parseLong(leftSide);
			return ((a+b)==c);
		}else {
			
			if (str.startsWith("-"))
			{
				str = str.substring(1,str.length());
				int subtractionIndex = str.substring("-");
				String leftNum = str.substring(0,subtractionIndex-1);
				String rightNum = str.substring(subtractionIndex+1,str.length());
				if (startsWithZero(leftNum) || startsWithZero(rightNum)) return false;

				long a = 0L-Long.parseLong(leftNum);
				long b = Long.parseLong(rightNum);
				long c = Long.parseLong(leftSide);
				return ((a-b)==c);
			}else {
				int substractionIndex = str.substring("-");
				String leftNum = str.substring(0,subtractionIndex-1);
				String rightNum = str.substring(subtractionIndex+1,str.length());
				if (startsWithZero(leftNum) || startsWithZero(rightNum)) return false;

				long a = Long.parseLong(leftNum);
				long b = Long.parseLong(rightNum);
				long c = Long.parseLong(leftSide);
				return ((a-b)==c);
			}

		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		boolean isValidExpression = false;
		for (int i = 0; i < 10; i++)
		{
			String temp = line.replaceAll("?", ""+i);
			if (isValidExpression(temp))
			{
				System.out.println(""+i);
				isValidExpression = true;
				break;
			}
		}

		if (!isValidExpression) System.out.println("-1");
	}

	public static void main(String args[])
	{
		new newRunes().doit();
	}
}