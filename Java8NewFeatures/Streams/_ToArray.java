import java.util.*;
import java.util.stream.*;

class _ToArray{
	public static void main(String... s){
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(100);
		numbers.add(500);
		numbers.add(250);
		numbers.add(300);
		numbers.add(400);

		Integer numberArray[] = numbers.stream().toArray(Integer[]::new);
		for(Integer i1 : numberArray){
			System.out.println(i1);
		}

		
	}
}