package synchronized_thread;

import static spark.Spark.get;

public class EjemploI {
  private static int counter = 1;

  public static void main(String[] args) {

    get("/id", (req, res) -> {
      System.out.println("entrando método id");
      final int id = getId();
      return id;
    });

    System.out.println("Listening on http://localhost:4567/");

  }

  //Thread-safe
  public static synchronized int getId() {
    final int id = counter;
    counter++;
    return id;
  }
}
