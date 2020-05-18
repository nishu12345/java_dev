import java.util.*;
import java.util.stream.*;

class _Filter{

	public static void main(String... s){
		List<Integer> number = new ArrayList<Integer>();
		number.add(5);
		number.add(10);
		number.add(15);
		number.add(20);
		number.add(25);	
		number.add(30);
		
		List<Integer> evenNumberList = number.stream().filter(i -> i%2==0).collect(Collectors.toList());
		System.out.println(evenNumberList);

		List<Integer> oddNumberList = number.stream().filter(i -> i%2 != 0).collect(Collectors.toList());
		System.out.println(oddNumberList);

		
	}
}
