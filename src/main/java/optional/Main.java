package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.isEmpty());
        System.out.println(hello.isPresent());

        String world = hello
                .map(String::toUpperCase)
                .orElse("world");
        System.out.println(world);

        world = hello.map(String::toUpperCase).orElseGet(() -> {
            //extra computation
            return "World";
        });
        System.out.println(world);

        world = hello.map(String::toUpperCase).orElseThrow(IllegalStateException::new);
        System.out.println(world);

        Optional<String> optional = hello.map(String::toUpperCase).or(() -> Optional.of("Hello"));


        hello.ifPresent(System.out::println);

        hello.ifPresentOrElse(System.out::println, IllegalStateException::new);


        Person person = new Person("Alex", "alex@email.com");
        person.getEmail()
                .ifPresentOrElse(System.out::println
                        , () -> System.out.println("No Email"));
    }
}

