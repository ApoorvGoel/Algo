package practice;

public class checkTryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello");
		try{
			throw new NullPointerException();
		}finally{
			System.out.println("Printed");
		}

	}

}
