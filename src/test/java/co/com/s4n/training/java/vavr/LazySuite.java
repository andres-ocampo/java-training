package co.com.s4n.training.java.vavr;

import io.vavr.Lazy;
import io.vavr.concurrent.Future;
import org.junit.Test;


import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LazySuite {

    private void sleep(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){
            System.out.println("Problemas durmiendo hilo");
        }
    }

    @Test
    public void testLazyFuture(){

        Lazy<Future<String>> f1 = Lazy.of(() -> {
            sleep(500);
            return Future.of(()->"");
        });
        Lazy<Future<String>> f2 = Lazy.of(() -> {
            sleep(800);
            return Future.of(()->"");
        });
        Lazy<Future<String>> f3 = Lazy.of(() -> {
            sleep(300);
            return Future.of(()->"");
        });
        final long inicio = System.nanoTime();
        Future<String> future = f1.get().flatMap(a -> f2.get()
                .flatMap(b -> f3.get()
                        .flatMap(c -> Future.of(() -> ""))));
        future.await();

        long fin = System.nanoTime();
        long elapsed = TimeUnit.MILLISECONDS.convert((fin - inicio),TimeUnit.NANOSECONDS);
        System.out.println("elapsed: "+elapsed);
        assertTrue(elapsed>1600);

        final long inicio2 = System.nanoTime();
        Future<String> future2 = f1.get().flatMap(a -> f2.get()
                .flatMap(b -> f3.get()
                        .flatMap(c -> Future.of(() -> ""))));
        long fin2 = System.nanoTime();
        long elapsed2 = TimeUnit.MILLISECONDS.convert((fin2 - inicio2),TimeUnit.NANOSECONDS);
        System.out.println("elapsed2: "+elapsed2);
        assertTrue(elapsed2<1600);
    }

    @Test
    public void testSupplier(){
        Supplier<String> s1 = ()->{
            sleep(500);
            return "";
        };
        final long inicio = System.nanoTime();
        s1.get();
        long fin = System.nanoTime();
        long elapsed = TimeUnit.MILLISECONDS.convert((fin - inicio),TimeUnit.NANOSECONDS);
        assertEquals(elapsed,500);
        System.out.println("Supplier elapsed: "+elapsed);
        final long inicio2 = System.nanoTime();
        s1.get();
        long fin2 = System.nanoTime();
        long elapsed2 = TimeUnit.MILLISECONDS.convert((fin2 - inicio2),TimeUnit.NANOSECONDS);
        assertEquals(elapsed2,500);
        System.out.println("Supplier 2 elapsed: "+elapsed2);

    }

    @Test
    public void testLazy(){
        Lazy<String> l1 = Lazy.of(()->{
            sleep(500);
            return "";
        });
        final long inicio = System.nanoTime();
        l1.get();
        long fin = System.nanoTime();
        long elapsed = TimeUnit.MILLISECONDS.convert((fin - inicio),TimeUnit.NANOSECONDS);
        assertEquals(elapsed,500);
        System.out.println("Lazy elapsed: "+elapsed);
        final long inicio2 = System.nanoTime();
        l1.get();
        long fin2 = System.nanoTime();
        long elapsed2 = TimeUnit.MILLISECONDS.convert((fin2 - inicio2),TimeUnit.NANOSECONDS);
        assertEquals(elapsed2,0);
        System.out.println("Lazy 2 elapsed: "+elapsed2);

    }


}
