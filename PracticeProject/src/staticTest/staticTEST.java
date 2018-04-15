package staticTest;

public class staticTEST {

	public static void main(String[] args) {

		B b = new B();
		b.a();
	}

}
@FunctionalInterface
interface A{
	static void a(){
		System.out.println("A");
	}
	
	
	void aa();
}
class B implements A{
	
	void a(){
		System.out.println("B");
	}

	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}
}