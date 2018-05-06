package GarbageCollection;

public class TestGc {
	TestGc next;
	
	//Here we can see that unreferenced node are automatically garbage collected by java
	public static void main(String[] args) {
		TestGc tc = new TestGc();
		TestGc tc1 = new TestGc();
		TestGc tc2 = new TestGc();
		TestGc tc3 = new TestGc();
		tc.next=tc1;
		tc1.next=tc2;
		tc2.next=tc3;
		tc=tc2;
		tc1=tc;
		System.gc();
	}
	 @Override
	    protected void finalize() throws Throwable 
	    { 
	        System.out.println("Finalize method called"); 
	    }
}
