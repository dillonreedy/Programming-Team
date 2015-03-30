import java.io.*;
import java.util.*;

public class Pizza
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int menuNum = 1;
		for (;;)
		{
			int n = sc.nextInt(); // The number of options
			if (n==0) break;

			int minDiameter = 0;
			double minPricePerInch = Double.MAX_VALUE;
			for (int i = 0; i < n; i++)
			{
				double d = sc.nextDouble();
				double area = (Math.pow((d/2.0),2)*Math.PI);
				double price = sc.nextDouble();
				double currentPricePerInch = (price/area);

				if (currentPricePerInch < minPricePerInch)
				{
					minDiameter = ((int) d);
					minPricePerInch = currentPricePerInch;
				}
			}	

			System.out.println("Menu " + menuNum + ": " + minDiameter);
			menuNum++;
		}
	}

	public static void main(String args[])
	{
		new Pizza().doit();
	}
}