
public class DeamonThread {

//A daemon thread in Java is one that doesn't prevent the JVM from exiting. Specifically the JVM will exit when 
//only daemon threads remain. You create one by calling the setDaemon() method on Thread.
//Daemon threads are terminated by the JVM when there are no longer any user threads running, including the main thread of execution.
//A “daemon” thread is one that is supposed to provide a general service in the background as long as the program is running, but is not part of the essence of the program.

	static int mainThreadPriority;
	static boolean secondThreadIsDeamon;

	public static void main(String[] args) throws InterruptedException {

		Thread mainThread = Thread.currentThread(); // obtaining current thread, the only way to control main Thread
		mainThread.setName("MAIN THREAD"); // setting its name

		SecondThread secTread = new SecondThread(); // new inner class thread
		secTread.start();// starting the thread
		secondThreadIsDeamon = secTread.isDaemon();

		try {
			mainThreadPriority = mainThread.getPriority(); // Every thread has a priority. Threads with higher priority
															// are executed in preference to threads with lower priority
			Thread.sleep(4500); // expressed in milliseconds

		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
			e.getStackTrace();
			e.getMessage();
		}

		if (secondThreadIsDeamon) {
			System.out.println(
					secTread.getName() + "Thread is deamon, Daemon threads don't prevent the program from ending, "
							+ "for this reason if the main Thread ended, our deamon thread will end as well. "
							+ "Deamons are non significant for your application Threads, so they can "
							+ "run in the bacground and end once non deamon threads have finished");
			System.out.println(Thread.currentThread().getName() + " ending. Main thread priority is:"
					+ Thread.currentThread().getPriority());
		} else
			System.out.println(secTread.getName() + "Thread is deamon, so even though THE MAIN THREAD IS DONE "
					+ "IT WILL KEEP ON GOING preventing the program from stopping. Click red rectangle to terminate");

	}

	static class SecondThread extends Thread {

		public SecondThread() {

			this.setDaemon(false);// <----------------------------------------- change the value and see what
									// happens!
		}

		public void run() {
			int count = 0;
			int PriorityOfthisThread = this.getPriority();
			boolean deamonStateOfthisthreadIs = this.isDaemon();

			this.setName("SecondThread");
			String secondThreadName = this.getName();
			System.out
					.println("I am the" + secondThreadName + " Thread from a class SecondThread that extends Thread.");
			System.out.println("my priotiy is:" + PriorityOfthisThread);
			System.out.println("my deamon status is: " + deamonStateOfthisthreadIs);
			System.out.println("and I am running in a loop");
			while (true) {

				System.out.println("this is run# " + count++);
				if (count == 15 || count == 25) {
					System.out.println("Click red rectangle to terminate");
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// handle exception here
				}
			}
		}
	}
}