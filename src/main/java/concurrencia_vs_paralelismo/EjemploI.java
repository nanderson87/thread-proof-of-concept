package concurrencia_vs_paralelismo;

import java.util.stream.IntStream;

public class EjemploI {
  public static void main(String[] args) {

    Runnable tarea = (() ->
      IntStream.rangeClosed(1, 500).forEach(System.out::println)
    );

    Thread thread1 = new Thread(tarea);
    Thread thread2 = new Thread(tarea);

    thread1.start();
    thread2.start();
  }
}
