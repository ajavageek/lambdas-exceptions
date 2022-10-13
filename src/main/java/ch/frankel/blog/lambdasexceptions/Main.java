package ch.frankel.blog.lambdasexceptions;

import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList")
                .map(it -> new ForNamer().apply(it))
                .forEach(System.out::println);
    }

    record ForNamer() implements Function<String, Class<?>> {

        @Override
        public Class<?> apply(String string) {
            try {
                return Class.forName(string);
            } catch (ClassNotFoundException e) {
                return null;
            }
        }
    }
}
