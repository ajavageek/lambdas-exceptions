package ch.frankel.blog.lambdasexceptions;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList")
                .map(it -> Class.forName(it))
                .forEach(System.out::println);
    }
}
