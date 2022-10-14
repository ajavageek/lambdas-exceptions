package ch.frankel.blog.lambdasexceptions;

import io.vavr.CheckedFunction1;
import io.vavr.collection.Stream;
import io.vavr.control.Either;
import io.vavr.control.Try;


public class Main {

    public static void main(String[] args) {
        var result = Stream.of("java.lang.String", "ch.frankel.blog.Dummy", "java.util.ArrayList")
                .map(CheckedFunction1.liftTry(Class::forName))
                .map(Try::toEither)
                .partition(Either::isLeft)
                .map1(left -> left.map(Either::getLeft))
                .map2(right -> right.map(Either::get));

        result._1().forEach(it -> System.out.println("not found: " + it.getMessage()));
        result._2().forEach(it -> System.out.println("class: " + it.getName()));
    }
}
