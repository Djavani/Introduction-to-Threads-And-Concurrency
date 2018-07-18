import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(3); // Executors.newFixedThreadPool(1);

		List<CallableTask> tasks = List.of(new CallableTask("Djavani Gomes"), new CallableTask("Diego Gomes"),
				new CallableTask("Sonia Gomes"));

		String result = executorService.invokeAny(tasks);

		System.out.println(result);

		executorService.shutdown();
	}

}
