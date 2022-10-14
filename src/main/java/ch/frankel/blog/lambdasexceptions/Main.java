package ch.frankel.blog.lambdasexceptions;

import org.apache.commons.lang3.function.Failable;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList");
        Failable.stream(stream)
                .map(Class::forName)
                .forEach(System.out::println);
    }
}
