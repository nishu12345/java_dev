import java.util.*;

class _Min_Max{
	public static void main(String... s){
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(0);
		numbers.add(5);
		numbers.add(20);
		numbers.add(15);

		//min() gives the element at first position.

		//Here provided Comparator object with ascending sorting order.
		Integer minAscNumber = numbers.stream().min((i1,i2) -> (i1 > i2) ? 1 : (i1 < i2) ? -1 : 0).get(); 
		System.out.println("Min Ascending Number " + minAscNumber);

		//Here provided Comparable object with descending sorting order.
		Integer minDescNumber = numbers.stream().min((i1,i2) -> i2.compareTo(i1)).get();
		System.out.println("Min Descending Number " + minDescNumber);

		//max() gives the element at last position.

		//Here provided Comparable object with ascending sorting order.
		Integer maxAscNumber = numbers.stream().max((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println("Max Ascending Number " + maxAscNumber);

		//Here provided Comparator object with descending sorting order.
		Integer maxDescNumber = numbers.stream().max((i1,i2) -> (i1>i2)? -1 : (i1<i2) ? 1 : 0).get();
		System.out.println("Max Descending Number " + maxDescNumber);
	}
}