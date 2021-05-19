package problems;

//check-then-act
public class EjemploRaceCondition {
  private static int variableA = 5;
  private static int variableB = 10;

  public static void main(String[] args) {

    Runnable r1 = () -> {
      System.out.println("variableA :" + variableA);
      System.out.println("variableB :" + variableB);

      if(variableA == 5 ) {
        System.out.println("El resultado deberia ser: 5");
        System.out.println("resultado final:" + (variableB / variableA));
      }
    };

    Runnable r2 = () -> variableB = 5;


    Thread th1 = new Thread(r1, "Th-1");
    Thread th2 = new Thread(r2, "Th-2");

    th1.start();
    th2.start();
  }
}
