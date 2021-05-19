package other_tasks;

public class EjemploSleep {
  public static void main(String[] args) throws InterruptedException {

    Runnable r = () -> {
      String name = Thread.currentThread().getName();
      int contador = 0;
      while (!Thread.interrupted())
        System.out.println(name + " : " + contador++);
    };

    Thread thdA = new Thread(r);
    Thread thdB = new Thread(r);

    thdA.start();
    thdB.start();

    try
    {
      Thread.sleep(10000); //Sleep 10 segundos
    }
    catch (InterruptedException ie)
    {
      //Nunca se va a llamar para.
    }

    thdA.interrupt();
    thdB.interrupt();

    Thread.sleep(500);

    System.out.println("name:" + thdA.getName() + ": " + thdA.isAlive() + ", " + thdA.getState());
    System.out.println("name:" + thdB.getName() + ": " + thdB.isAlive() + ", " + thdB.getState());
  }
}
