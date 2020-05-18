import java.util.stream.*;
class _StreamOf{
	public static void main(String... s){
		Integer marks[] = {55,35,70,20,80};
		Stream.of(marks).forEach(System.out::println);

		Stream.of(9,99,999,9999,99999).forEach(System.out::println);
	}
}