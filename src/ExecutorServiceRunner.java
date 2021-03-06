import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread {
	
	private int number;

	public Task(int number) {
		this.number = number;
	}
	
	//Signature
	public void run() {
		System.out.println("\nTask " + number + " Started");
		
		for(int i=number*100; i<=number*100 + 99; i++)
			System.out.print(i + " ");
		
		Thread.yield();
		
		System.out.println("\nTask " + number + " Done");		
	}
}

public class ExecutorServiceRunner {

	public static void main(String[] args) {

//		ExecutorService executorService = Executors.newSingleThreadExecutor(); //settin a one thread
		ExecutorService executorService = Executors.newFixedThreadPool(5); //setting a pool of 5 threads
		
		executorService.execute(new Task(1));
		executorService.execute(new Task(2));
		executorService.execute(new Task(3));
		executorService.execute(new Task(4));
		executorService.execute(new Task(5));
		executorService.execute(new Task(6));
		executorService.execute(new Task(7));
//		executorService.execute(new Thread(new Task2()));

		// Task3
		
		/*System.out.println("\nTask3 Kicked Off");
		for (int i = 301; i <= 399; i++)
			System.out.print(i + " ");

		System.out.println("\nTask3 Done");

		System.out.println("\nMain Done");
*/
		executorService.shutdown();

	}

}
