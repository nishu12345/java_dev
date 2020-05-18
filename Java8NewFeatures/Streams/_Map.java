import java.util.*;
import java.util.stream.*;

class _Map{
	public static void main(String... s){
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(5);
		marks.add(10);
		marks.add(15);
		marks.add(20);
		marks.add(25);
		marks.add(30);

		List<Integer> updatedMarks = marks.stream().map(mark -> mark+5).collect(Collectors.toList());
		System.out.println(updatedMarks);

		List<Integer> evenNumbers = updatedMarks.stream().map(mark -> 
			{
				if(mark%2 == 0)
					return mark;
				else
					return -1;
			}).collect(Collectors.toList());
		System.out.println(evenNumbers);
	}
}