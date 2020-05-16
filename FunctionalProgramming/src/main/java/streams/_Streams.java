package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;

public class _Streams {

    public static void main(String[] args) {


        List<Person> people = List.of(new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE));

        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);

        people.stream().map(person -> person.name).mapToInt(name -> name.length()).forEach(System.out::println);

        people.stream().mapToInt(person -> person.name.length()).forEach(System.out::println);

        people.stream().map(person -> person.gender.equals(FEMALE)).forEach(person -> System.out.println(person));

    }

    static class Person {
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
