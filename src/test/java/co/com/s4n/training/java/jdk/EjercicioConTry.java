package co.com.s4n.training.java.jdk;

import io.vavr.control.Try;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjercicioConTry {

    public static Try<String> fizz(Integer i){
        return i % 3 == 0 ? Try.of(()->"Fizz") : Try.of(()->"");
    }

    public static Try<String> fizzFailure(Integer i){
        return i % 3 == 0 ? Try.failure(new Exception("Error")) : Try.of(()->"");
    }

    public static Try<String> buzz(Integer i, String s){
        return i % 5 == 0 ? Try.of(()->s+"Buzz") : Try.of(()->s);
    }

    public static Stream<Integer> streamNumbers(){
        return IntStream.range(1,101).boxed();
    }

    public static Try<String> estaVacio(String s, Integer i){
        return s.isEmpty() ? Try.of(()->i.toString()):Try.of(()->s);
    }
}
