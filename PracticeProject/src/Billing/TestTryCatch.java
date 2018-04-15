package Billing;

public class TestTryCatch {

	public static void main(String[] args) {
		System.out.println(abc());

	}

	static int abc() {
		try {
			return 0;
		} catch (Exception ex) {
			return 1;
		} finally {
			return 2;
		}
	}
}
