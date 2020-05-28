package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE));

        //imperative approach
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("//Declarative variable");

        Predicate<Person> femalePredicate = person -> person.gender.equals(FEMALE);

        Consumer<Person> femaleConsumer = person -> System.out.println(person);
        people.stream().
                filter(femalePredicate)
                .forEach(femaleConsumer);

        List<Person> males = people.stream().filter(person -> person.gender.equals(MALE)).collect(Collectors.toList());
        males.forEach(System.out::println);
    }


    static class Person {
        private final String name;
        private final Gender gender;


        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
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
