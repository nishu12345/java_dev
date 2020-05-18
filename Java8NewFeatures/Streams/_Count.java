import java.util.*;
import java.util.stream.*;

class _Count{

	public static void main(String... s){
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(75);
		marks.add(45);
		marks.add(10);
		marks.add(83);
		marks.add(25);
		long failedCount = marks.stream().filter(m -> m<35).count();
	System.out.println(failedCount);
	}

	
}