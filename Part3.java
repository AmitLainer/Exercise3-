package Ex3_Pack;
import java.lang.Math;
class Part3 extends Thread 
{
	private int[] arr;
	private int from , to;
	static int sum = 0;
	
	public Part3(int[] arr , int from , int to) {
		this.arr = arr;
		this.from = from;
		this.to = to;
	}
	
	public int[] getArr() {
		return arr;
	}
	public static int getSum() {
		return sum;
	}
	public static synchronized void updateSum(int value)
	{
		sum += value;
	}
	public void run()
	{
			int sum = 0;
			for(int i = from ; i <= to ; i++)
			{
					sum += arr[i];
			}
			System.out.println(Thread.currentThread().getId());
			Part3.updateSum(sum);
	}
	public static int summary(int[] arr) 
	{
		Part3[] threads = new Part3[4];
		int from,to;
		for(int i = 0 ; i < 4 ; i++)
		{
			from = i*arr.length/4;
			to = Math.min(from + arr.length/4 - 1  , arr.length - 1);
			threads[i] = new Part3(arr , from , to);
			threads[i].start();
		}
		try 
		{
			for(int i = 0 ; i < 4 ; i++)
			{
				threads[i].join();
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return Part3.getSum();
	}
}
