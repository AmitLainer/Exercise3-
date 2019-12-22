package Ex3_Pack;
import java.lang.Math;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		Part1 runner1 = new Part1(),runner2 = new Part1(),runner3 = new Part1();
		runner1.start();
		runner2.start();
		runner3.start();
		while(true)
		{
			if(string.isEmpty())
			{
				break;
			}
			string = scan.nextLine();
		}
		System.out.println((Math.max(runner1.getCounter(),Math.max(runner1.getCounter(),runner2.getCounter()))));
		int[] arr = new int[4000];
		for(int i = 0 ; i < 4000; i++)
		{
			arr[i] = i;
		}
		int max = Part2.findMax(arr);
		System.out.println(max);
		int sum = Part3.summary(arr);
		System.out.println("sum is " + sum);
	}

}
