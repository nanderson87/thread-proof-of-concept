# thread-proof-of-concept

Los estados de ejecución de un Thread

NEW: Un thread que todavía no ha comenzado.
RUNNABLE: A thread executing in the JVM is in this state.
BLOCKED: A thread that is blocked waiting for a monitor lock is in this state. (I’ll discuss monitor locks in Chapter 2.)
WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
TERMINATED: A thread that has exited is in this state.

Thread lets an application determine a thread’s current state by providing the Thread.State getState() method, which is demonstrated here:

Thread t = new Thread(r);
System.out.println(t.getState()); // Output: NEW


## parallelism & concurrency

parallelism is “a condition that arises when at least two threads are executing simultaneously.”
In contrast, concurrency is “a condition that exists when at least two threads are making progress. [It is a] more generalized form of parallelism that can include time-slicing as a form of virtual parallelism.”
http://docs.oracle.com/cd/E19455-01/806-5257/6je9h032b/index.html

## Daemon Status

Java lets you classify threads as daemon threads or nondaemon threads   
A daemon thread is a thread that acts as a helper to a nondaemon thread and dies automatically when the application’s last nondaemon thread dies so that the application can terminate.

Thread t = new Thread(r);
System.out.println(t.isDaemon()); 

By default, the threads associated with Thread objects are nondaemon threads.

Thread t = new Thread(r);
t.setDaemon(true);  

An application will not terminate when the nondaemon default main thread terminates until all background nondaemon threads terminate. 
If the background threads are daemon threads, the application will terminate as soon as the default main thread terminates.


## Starting a Thread  

Calling start() results in the runtime creating the underlying thread and scheduling it for subsequent execution in which 
the runnable’s run() method is invoked. (start() doesn’t wait for these tasks to be completed before it returns.) 
When execution leaves run(), the thread is destroyed and the Thread object on which start() was called is no longer viable, 
which is why calling start() results in IllegalThreadStateException.

Thread t = new Thread(r);
t.start();