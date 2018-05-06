package Math;

public class CountTrailZeroes {

	public static void main(String[] args) {
		
		System.out.println(new CountTrailZeroes().trailingZeroes(525));
	}
	public  int trailingZeroes(int A) {
		
		if(A/5==0)
			return 0;
		else {
			int a=A/5;
			int b=trailingZeroes(A/5);
			return a+b;
		}
    }
	
	
}
