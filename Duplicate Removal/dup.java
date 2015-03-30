import java.io.*;
import java.util.*;

public class dup
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n!=0)
		{
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
			{
				if (al.size() != 0)
				{
					int given = sc.nextInt();
					if (al.get(al.size()-1) != given) al.add(given);
				}
				else
				{
					al.add(sc.nextInt());
				}
			}

			for (int i = 0; i < al.size(); i++) System.out.print(al.get(i) + " ");

			System.out.println("$");
			n=sc.nextInt();
		}
	}

	public static void main(String args[])
	{
		new dup().doit();
	}
}