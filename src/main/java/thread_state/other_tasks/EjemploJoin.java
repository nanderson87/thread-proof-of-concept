package thread_state.other_tasks;

import java.util.stream.IntStream;

public class EjemploJoin {
  private static int result100;
  private static int result50;

  public static void main(String[] args) {

    Runnable r100 = () -> result100 = sum(100);
    Runnable r50 = () -> result50 = sum(50);

    Thread t1 = new Thread(r100);
    Thread t2 = new Thread(r50);

    t1.start();
    t2.start();


    try {
      t1.join();
      t2.join();
    } catch (InterruptedException ie) {
      //Nunca se va a estar llamando una interrupción.
    }

    final int resultFinal = result50 + result100;

    System.out.println("result: " + resultFinal);
  }

  public static int sum(int digits) {
    return IntStream.rangeClosed(0, digits).sum();
  }

}
