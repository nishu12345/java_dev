import java.util.*;
import java.util.stream.*;

class _Sorted{
	public static void main(String... s){
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(75);
		marks.add(14);
		marks.add(37);
		marks.add(80);
		marks.add(54);

		List<Integer> sortedMarks = marks.stream().filter(m -> m>35).sorted().collect(Collectors.toList());
		System.out.println("Ascending" + sortedMarks);

		//Comparator for descending sort -> (obj1,obj2) -> (obj1 < obj2) ? 1 : (obj1 > obj2) ? -1 : 0
		List<Integer> descSorted = marks.stream().sorted((i1,i2) -> (i1<i2) ? 1 : (i1 > i2) ? -1 : 0).collect(Collectors.toList());
		System.out.println("Descending" + descSorted);

		//When we don't provide comparator to sorted() method, internally it uses Comparable interface's compareTo method
		List<Integer> ascSorted = marks.stream().sorted((i1,i2) -> i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println("Natural sorting using comparable's compareTo() " + ascSorted);

		//We can sort in descending order using compareTo by negating the value.
		List<Integer> descSortComparable = marks.stream().sorted((i1,i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println("Descending sorting using Comparable's compareTo() " + descSortComparable);

		//We can sort in descending order using compareTo by interchanging arguments.
		List<Integer> descSortComparable2 = marks.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println("Descending sort using Comparable's compareTo()  by intechanging argument " + descSortComparable2);


		List<String> names = new ArrayList<String>();
		names.add("Sunny Leone");
		names.add("Prabhas");
		names.add("Anushka Shetty");
		names.add("Kajal Agarwal");
		names.add("Malika Sherawat");

		//Sorted based on ascending alphabetical order.
		List<String> ascAlphabetically = names.stream().sorted().collect(Collectors.toList());
		System.out.println("Ascending Alphabetical Sorting " + ascAlphabetically);


		//Sorted ascending order based on length and if length are equal sort ascending based on alphabetical order.
		List<String> ascLengthWise = names.stream().sorted((i1,i2) -> (i1.length() > i2.length()) ? 1 : (i1.length() < i2.length()) ? -1 :
		i1.compareTo(i2)).collect(Collectors.toList()); 
		System.out.println("Ascending based on length, if length are equal ascending based on alphabetical order " + ascLengthWise);
	
	}

}