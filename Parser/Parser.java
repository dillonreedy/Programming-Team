
import java.io.*;
import java.util.*;

public class Parser
{
	public static String eqt;
	public static ArrayList<OperatorInput> opList = new ArrayList<OperatorInput>();

	public static void main(String args[])
	{
		input();
		Collections.reverse(opList);
		System.out.println(parseEquation(eqt).toString());
	}

	private static void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of operators: ");
		int num = sc.nextInt()+1;

		while (--num>0)
		{
			System.out.print("Operator:Associativity ");
			String in = sc.next();
			opList.add(new OperatorInput(in.charAt(0)+"", in.substring(2).equals("right")));
		}
		System.out.print("Equation: ");
		eqt = new Scanner(System.in).nextLine().trim().replace(" ","");
	}

	public static class OperatorInput
	{
		public OperatorInput(String op, boolean right)
		{
			this.op = op;
			this.right = right;
		}
		public String op;
		public boolean right;
	}

	public static class Operator implements OperatorInterface
	{
		public Operator(String value)
		{
			this.value = value;
		}
		String value;
		ArrayList<OperatorInterface> operatorArrayList = new ArrayList<OperatorInterface>();
		public void addTerm(OperatorInterface oi)
		{
			operatorArrayList.add(oi);
		} 

		public String toString()
		{
			return "("+operatorArrayList.get(0).toString()+value+operatorArrayList.get(1).toString()+")";
		}
	}

	public static class Number implements OperatorInterface
	{
		int value;
		public Number(int value)
		{
			this.value = value;
		}
		public String toString()
		{
			return value + "";
		}
	}

	public static interface OperatorInterface
	{
		public String toString();
	}

	public static OperatorInterface parseEquation(String input)
	{
		for (OperatorInput operatorInput : opList)
		{
			boolean hasParen = false;
			if (operatorInput.right) // right leaning
			{
				for (int index = input.length()-1; index > 0; index--)
				{
					String eqtIndex = "" + input.charAt(index);
					if (eqtIndex.equals(")"))
					{
						hasParen = true;
						index = skipRightParen(input, index); // skips paren and sets index to its proper "skipped" value
						continue;
					}
					if (eqtIndex)
				}
			}
		}
	}
}