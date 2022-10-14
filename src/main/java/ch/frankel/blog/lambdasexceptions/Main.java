package ch.frankel.blog.lambdasexceptions;

import io.vavr.CheckedFunction1;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

public class Main {

    public static void main(String[] args) {
        Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList")
                .map(CheckedFunction1.liftTry(Class::forName))
                .map(Try::toEither)
                .forEach(e -> {
                    if (e.isLeft()) {
                        System.out.println("not found:" + e.getLeft().getMessage());
                    } else {
                        System.out.println("class:" + e.get().getName());
                    }
                });
    }
}
