import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(3); //Executors.newFixedThreadPool(1);
		
		List<CallableTask>  tasks = List.of(new CallableTask("Djavani Gomes"), 
				new CallableTask("Diego Gomes"), 
				new CallableTask("Sonia Gomes"));
		
		List<Future<String>> results = executorService.invokeAll(tasks);
		
		for(Future<String>  result: results) {
			System.out.println(result.get());
		}
		
		executorService.shutdown();
	}

}
