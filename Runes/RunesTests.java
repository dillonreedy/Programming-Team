import java.io.*;
import java.util.*;

public class RunesTests
{
	public boolean isLeadingZeros(String num)
	{
		return ((num.startsWith("0") && (!num.equals("0"))) || num.startsWith("-0"));
	}

	public boolean isValidExpression(String line)
	{
		int indexOfEquals = line.indexOf("=");
		String rightSide = line.substring(indexOfEquals+1, line.length());
		line = line.substring(0, indexOfEquals);

		if (line.contains("*"))
		{
			int indexOfOp = line.indexOf("*");
			String leftNum = line.substring(0,indexOfOp);
			String rightNum = line.substring(indexOfOp+1, line.length());	
				
			if (isLeadingZeros(leftNum) || isLeadingZeros(rightNum) || isLeadingZeros(rightSide)) return false;

			long firstNum = Long.parseLong(leftNum, 10);
			long secondNum = Long.parseLong(rightNum, 10);
			long thirdNum = Long.parseLong(rightSide, 10);

			return ((firstNum*secondNum)==thirdNum);
		}
		else if (line.contains("+"))
		{
			int indexOfOp = line.indexOf("+");
			String leftNum = line.substring(0,indexOfOp);
			String rightNum = line.substring(indexOfOp+1, line.length());	
				
			if (isLeadingZeros(leftNum) || isLeadingZeros(rightNum) || isLeadingZeros(rightSide)) return false;

			long firstNum = Long.parseLong(leftNum, 10);
			long secondNum = Long.parseLong(rightNum, 10);
			long thirdNum = Long.parseLong(rightSide, 10);

			return ((firstNum+secondNum)==thirdNum);
		}
		else
		{
			if (line.startsWith("-"))
			{

				int indexOfOp = line.indexOf("-",1);
				String leftNum = line.substring(0,indexOfOp);
				String rightNum = line.substring(indexOfOp+1, line.length());

				if (isLeadingZeros(leftNum) || isLeadingZeros(rightNum) || isLeadingZeros(rightSide)) return false;

				long firstNum = Long.parseLong(leftNum, 10);
				long secondNum = Long.parseLong(rightNum, 10);
				long thirdNum = Long.parseLong(rightSide, 10);

				return ((firstNum-secondNum)==thirdNum);
			}
			else
			{

				int indexOfOp = line.indexOf("-");
				String leftNum = line.substring(0,indexOfOp);
				String rightNum = line.substring(indexOfOp+1, line.length());
			
				if (isLeadingZeros(leftNum) || isLeadingZeros(rightNum) || isLeadingZeros(rightSide)) return false;

				long firstNum = Long.parseLong(leftNum, 10);
				long secondNum = Long.parseLong(rightNum, 10);
				long thirdNum = Long.parseLong(rightSide, 10);

				return ((firstNum-secondNum)==thirdNum);
			}
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		boolean digitExists = false;
		for (int i = 0; i < 10; i++)
		{
			if (!line.contains(""+i))
			{
				String possible = line.replaceAll("\\?", ""+i);
				if (isValidExpression(possible))
				{
					System.out.println(i);
					digitExists = true;
					break;
				}
			}
		}

		if (!digitExists) System.out.println("-1");
	}

	public static void main(String args[])
	{
		new RunesTests().doit();
	}
}