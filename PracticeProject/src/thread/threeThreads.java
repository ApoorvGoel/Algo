package thread;

public class threeThreads {

	public static void main(String[] args) {
		Object lock = new Object();
		printNumber pN1 = new printNumber(lock, 0, 6);
		printNumber pN2 = new printNumber(lock, 1, 6);
		printNumber pN3 = new printNumber(lock, 2, 6);
		Thread t1 = new Thread(pN1);
		Thread t2 = new Thread(pN2);
		Thread t3 = new Thread(pN3);
		t1.start();
		t2.start();
		t3.start();
	}

}

class printNumber implements Runnable {
	Object lock;
	int turn;
	int maValue;
	static int counter = 0;
	static int turnDecider = 0;

	public printNumber(Object lock, int modulo, int maValue) {
		super();
		this.lock = lock;
		this.turn = modulo;
		this.maValue = maValue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				if (turnDecider == turn) {
					if (counter < maValue) {
						System.out.print(Thread.currentThread().getName() + " - " + counter +"  ");
					} else {
						turnDecider = (turnDecider+1)%3;
						return;
					}
					if (turnDecider == 2) {
						System.out.println();
						counter++;
					}
					turnDecider = (turnDecider+1)%3;
				}
			}
		}
	}

}
