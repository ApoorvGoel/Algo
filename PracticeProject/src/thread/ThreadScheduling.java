package thread;

public class ThreadScheduling {

	public static void main(String[] args) {
		
		
		
		int n=9;
		// TODO Auto-generated method stub
		int i=1;
		int j=n/3;
		
		
		A a1 = new A();
		Thread t1 = new Thread(a1); 
		A a2 = new A();
		Thread t2 = new Thread(a2);
		A a3 = new A();
		Thread t3 = new Thread(a3);
		
		
		
	}

}

class A implements Runnable{

	int i;
	
	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int j = 0; j < 3; j++) {
			i=i+3;
			System.out.print(i);	
		}
		System.out.println();
	}
	
}
