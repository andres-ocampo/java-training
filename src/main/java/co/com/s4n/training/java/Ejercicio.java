package co.com.s4n.training.java;

import io.vavr.control.Option;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ejercicio {

    public static Option<String> fizz(Integer i){
        return i % 3 == 0 ? Option.of("Fizz") : Option.of("");
    }

    public static Option<String> buzz(Integer i, String s){
        return i % 5 == 0 ? Option.of(s+"Buzz") : Option.of(s);
    }

    public static Stream<Integer> streamNumbers(){
        return IntStream.range(1,101).boxed();
    }

    public static Option<String> estaVacio(String s, Integer i){
        return s.isEmpty() ? Option.of(i.toString()):Option.of(s);
    }
}
