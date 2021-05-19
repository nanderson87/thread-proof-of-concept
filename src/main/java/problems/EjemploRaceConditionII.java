package problems;

import static spark.Spark.*;

//read-modify-write - Spark
public class EjemploRaceConditionII {
  private static int counter = 1;

  public static void main(String[] args) {

    get("/id", (req, res) -> {
      final int id = getId();
      return id;
    });

    System.out.println("Listening on http://localhost:4567/");

  }

  //Thread-unsafe
  public static int getId() {
    final int id = counter;
    counter++;
    return id;
  }
}
