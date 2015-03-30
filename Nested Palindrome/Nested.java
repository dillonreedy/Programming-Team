import java.util.*;
import java.io.*;

public class Nested
{
	public String rev(String str)
	{
		String result = "";
		for (int i = str.length()-1; i>=0; i--) result+=str.charAt(i);

		return result;
	}

	public boolean isPalin(String orig)
	{
		return orig.equals(rev(orig));
	}

	public boolean isNestedPalin(String num)
	{
		if (num.length()==1) return true;
		if (num.length()==2) return false;

		if (!isPalin(num)) return false;

		String a = "";
		if (num.length()%2 == 0) a = num.substring(0, num.length()/2);
		else a = num.substring(0, num.length()/2-1);

		if (!isNestedPalin(a)) return false;

		for (int i = 0; i < 10; i++)
		{
			String tester = "" + i + "" + i;
			if (num.contains(tester)) return false;
		}

		return true;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		long k = sc.nextLong();
		while (k!=0L)
		{
		sc.nextLine();
		String num = sc.nextLine();
		ArrayList<String> q = new ArrayList<String>();
		q.add(num);
		boolean isFound = false;
		while (!q.isEmpty())
		{
			String current = q.remove(0);
			int indexQ = current.indexOf("?");
			String left = current.substring(0, indexQ);
			String right = current.substring(indexQ+1, current.length());

			System.out.println("left: " + left + " right:" + right);

			for (int i = 0; i < 10; i++)
			{
				String possible = left + "" + i + "" + right;
				if (!possible.contains("?"))
				{
					if ((!possible.startsWith("0")) && (isNestedPalin(possible)))
					{
						k--;
						if (k==0L)
						{
							System.out.println(possible);
							isFound = true;
							break;
						}
					}
				}
				else q.add(possible);
			}
		}

		if (!isFound) System.out.println("-1");
		
		k=sc.nextLong();
		}
	}

	public static void main(String args[])
	{
		new Nested().doit();
	}
}