import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class _ForEach{
	public static void main(String... s){
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(10);
		numbers.add(25);
		numbers.add(15);
		numbers.add(20);
		numbers.stream().forEach(System.out::println);
		
		Consumer<Integer> squareConsumer = i -> System.out.println("Square of " + i + " is: " + (i*i));
		numbers.stream().forEach(squareConsumer);
	}
}