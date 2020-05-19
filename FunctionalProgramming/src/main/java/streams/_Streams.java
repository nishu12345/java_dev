package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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


        people.stream().map(person -> person.gender.equals(FEMALE)).forEach(System.out::println);

        System.out.println("Length of name for females");
        people.stream().filter(person -> person.gender.equals(FEMALE)).mapToInt(person -> person.name.length()).forEach(System.out::println);


        boolean b = people.stream().anyMatch(person -> person.gender.equals(FEMALE));
        System.out.println("Does the list contain any person with gender as female ? " + b);

        b = people.stream().allMatch(person -> person.gender.equals(FEMALE));
        System.out.println("Does the list contain all the person with gender as female ? " + b);

        b = people.stream().noneMatch(person -> person.gender.equals("Hello"));
        System.out.println("No gender in the list have gender as Hello ? " + b);

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
