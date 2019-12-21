package Ex3_Pack;
import java.lang.Math;
class Part2 extends Thread 
{
	private int[] arr;
	private int from , to;
	static int max = 0;
	
	public Part2(int[] arr , int from , int to) {
		this.arr = arr;
		this.from = from;
		this.to = to;
	}
	
	public int[] getArr() {
		return arr;
	}
	public static int getMax() {
		return max;
	}
	public static synchronized void updateMax(int value)
	{
		if(max < value)
		{
			max = value;
		}
	}
	public void run()
	{
			int max = Integer.MIN_VALUE;
			for(int i = from ; i <= to ; i++)
			{
					if(max < arr[i])
					{
						max = arr[i];
					}
			}
			System.out.println(Thread.currentThread().getId());
			Part2.updateMax(max);
	}
	public static int findMax(int[] arr) 
	{
		Part2[] threads = new Part2[4];
		int from,to;
		for(int i = 0 ; i < 4 ; i++)
		{
			from = i*arr.length/4;
			to = Math.min(from + arr.length/4 - 1  , arr.length - 1);
			threads[i] = new Part2(arr , from , to);
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
		
		return Part2.getMax();
	}
}
