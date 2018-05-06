package thread;

public class ThreeThreads2 {

	public static void main(String[] args) {
		printNumber2 pn2 = new printNumber2();
		zeroPrinter zp = new zeroPrinter(pn2);
		onePrinter op = new onePrinter(pn2);
		twoPrinter tp = new twoPrinter(pn2);
		Thread t1 = new Thread(zp);
		t1.start();
		Thread t2 = new Thread(op);
		t2.start();
		Thread t3 = new Thread(tp);
		t3.start();
	}

}

class printNumber2 {
	static int turnDecider;

	void printZero() {
		synchronized (this) {
			while (turnDecider != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName()+" - "+0+" ");
			turnDecider = (turnDecider + 1) % 3;
			//System.out.println(turnDecider);
			notifyAll();
		}
	}

	void printOne() {
		synchronized (this) {
			while (turnDecider != 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName()+" - "+1+" ");
			turnDecider = (turnDecider + 1) % 3;
			//System.out.println(turnDecider);
			notifyAll();
		}
	}

	void printTwo() {
		synchronized (this) {
			while (turnDecider != 2) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName()+" - "+2+" ");
			System.out.println();
			turnDecider = (turnDecider + 1) % 3;
			//System.out.println(turnDecider);
			notifyAll();
		}
	}

}

class zeroPrinter implements Runnable {
	printNumber2 pn;

	public zeroPrinter(printNumber2 pn) {
		super();
		this.pn = pn;
	}

	@Override
	public void run() {
		for(int i=0;i<=10;i++){
			pn.printZero();
		}
	}

}

class onePrinter implements Runnable {
	printNumber2 pn;

	public onePrinter(printNumber2 pn) {
		super();
		this.pn = pn;
	}

	@Override
	public void run() {
		for(int i=0;i<=10;i++){
			pn.printOne();
		}
	}

}

class twoPrinter implements Runnable {
	printNumber2 pn;

	public twoPrinter(printNumber2 pn) {
		super();
		this.pn = pn;
	}

	@Override
	public void run() {
		for(int i=0;i<=10;i++){
			pn.printTwo();
		}
	}

}
