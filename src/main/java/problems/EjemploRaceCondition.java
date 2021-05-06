package problems;

public class EjemploRaceCondition {
  private static int variableA = 5;
  private static int variableB = 10;

  public static void main(String[] args) {

    Runnable r1 = () -> {
      System.out.println("variableA :" + variableA);
      System.out.println("variableB :" + variableB);
      System.out.println("El resultado deberia ser: " + (variableB / variableA) );
      System.out.println("resultado:" + (variableB / variableA));
    };

    Runnable r2 = () -> variableB = 5;


    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();
  }
}
