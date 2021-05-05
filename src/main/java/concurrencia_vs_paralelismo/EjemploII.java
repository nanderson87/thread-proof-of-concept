package concurrencia_vs_paralelismo;
import static spark.Spark.*;

public class EjemploII {
  public static void main(String[] args) {
    get("/ping", (req, res) -> "pong");
  }
}
