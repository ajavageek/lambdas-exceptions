package ch.frankel.blog.lambdasexceptions;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList")
                .map(it -> {
                    try {
                        return Class.forName(it);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);
    }
}
