package thread;

public class FizzBuzzUsingWaitNotify {

	public static void main(String[] args) {
		Object lock = new Object();
		
		FizzBuzz fizzbuzz = new FizzBuzz(lock, true, true, 20);
		FizzBuzz fizz = new FizzBuzz(lock, true, false, 20);

		FizzBuzz buzz = new FizzBuzz(lock, false, true, 20);
		FizzBuzz print = new FizzBuzz(lock, false, false, 20);

		Thread t1 = new Thread(fizz);
		Thread t2 = new Thread(fizzbuzz);
		Thread t3 = new Thread(buzz);
		Thread t4 = new Thread(print);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}



class FizzBuzz implements Runnable {
	Object lock;
	Boolean fizz,buzz;
	int max;
 static	int curr=1;
	
	public FizzBuzz(Object lock, Boolean fizz, Boolean buzz, int max) {
		super();
		this.lock = lock;
		this.fizz = fizz;
		this.buzz = buzz;
		this.max = max;
	}

	@Override
	public void run() {
		
		while(true){
			
			synchronized(lock){
				
				if(curr>max)
					return;
				if(curr%3==0 && curr%5==0){
					if(fizz && buzz){
						curr++;
						System.out.println(" fizz Buzz");
					}
				}
				if(curr%3==0){
					if(fizz && !buzz){
						curr++;
						System.out.println(" fizz");
					}
				}
				
				if(curr%5==0){
					if(!fizz && buzz){
						curr++;
						System.out.println("Buzz");
					}
				}
				if(!(curr%3==0 || curr%5==0)&&!fizz && !buzz){
					System.out.println(curr);
					curr++;
				}
			}
			
		}
	}

}

