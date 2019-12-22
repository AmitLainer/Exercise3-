package Ex3_Pack;
public class Part1 extends Thread {
	private int counter;
	public Part1()
	{
		counter = 0;
	}
	public synchronized int getCounter(){return counter;}
	public void run(){
		while(true)
		{
			counter++;
		}
	}
}
