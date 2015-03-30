import java.io.*;
import java.util.*;

public class Gnomes
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Gnomes:");
		for (int i = 0; i < n; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (((a < b) && (b < c))
			|| ((a > b) && (b > c))) System.out.println("Ordered");
			else System.out.println("Unordered");
		}
	}

	public static void main(String args[])
	{
		new Gnomes().doit();
	}
}