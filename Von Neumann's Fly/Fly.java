import java.io.*;
import java.util.*;
import java.text.*;

public class Fly
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		for (;;)
		{
			int n = sc.nextInt();
			double d = sc.nextDouble(); // The initial distance between the bicycles 9<D && D<1001
			double a = sc.nextDouble(); // Cyclist's A speed in miles per hour 0<A && A<31
			double b = sc.nextDouble(); // Cyclist's B speed in miles per hour 0<B && B<31
			double f = sc.nextDouble(); // The fly's speed in miles per hour A<=B && B<F && F<51

			double time = (d/(a+b));
			double totalDist = time*f;
			DecimalFormat formatter = new DecimalFormat("######.00");
			String result = formatter.format(totalDist);
			System.out.println(n + " " + result);

			if (n==p) break;		
		}
	}

	public static void main(String args[])
	{
		new Fly().doit();
	}
}