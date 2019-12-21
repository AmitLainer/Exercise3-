package Ex3_Pack;
public class Main {

	public static void main(String[] args) 
	{
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
