import java.io.*;
import java.util.*;

public class Multiply
{
	public int numZeros(long num)
	{
		char digits[] = (num+"").toCharArray();
		int count = 0;
		for (int i = 0; i < digits.length; i++) if (digits[i] == '0') count++;

		return count;
	}

	public void repeatChar(int n, char c)
	{
		char chars[] = new char[n];
		Arrays.fill(chars, c);
		System.out.print(new String(chars));
	}

	public int charToInt(char c)
	{
		char nums[] = "123456789".toCharArray();
		for (int i = 0; i < nums.length; i++) if (c==nums[i]) return i+1;
		
		System.err.println("The given character is not a number!!!");
		return -1;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int probNum = 1;
		for (;;)
		{
			long num1 = sc.nextLong();
			long num2 = sc.nextLong();
			if (num1==0L && num2==0L) break;

			System.out.println("Problem " + probNum);
			probNum++;
			int numProdDigits = ((num1*num2)+"").length();
			int numNum1Digits = ((num1+"").length());
			int numNum2Digits = ((num2+"").length());
			repeatChar(numProdDigits-numNum1Digits, ' ');
			System.out.println(num1);
			repeatChar(numProdDigits-numNum2Digits, ' ');
			System.out.println(num2);

			if (numNum2Digits-numZeros(num2) > 1)
			{
				repeatChar(numProdDigits, '-');
				System.out.println();

				char digits[] = (num2+"").toCharArray();
				int numPrintedOut = 0;
				String appendedZeros = "";
				for (int i = digits.length-1; i >= 0; i--)
				{
					if (digits[i] != '0')
					{
						int digit = charToInt(digits[i]);
						long lineProd = num1*((long)digit);
						int numLineProdDigits = ((lineProd+"")).length();
						repeatChar(numProdDigits-numLineProdDigits-numPrintedOut, ' ');
						System.out.println((lineProd+"") + appendedZeros);
						appendedZeros = "";
					}
					else
					{
						appendedZeros+="0";
					}
					numPrintedOut++;
				}
			}

			repeatChar(numProdDigits, '-');
			System.out.println();
			System.out.println((num1*num2));
		}

	}

	public static void main(String args[])
	{
		new Multiply().doit();
	}
}