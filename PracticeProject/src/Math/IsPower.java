package Math;

public class IsPower {

	public static void main(String[] args) {
		
		System.out.println(new IsPower().isPower(1024));
	}
	public int isPower(int A) {
		
		for(int i=2;i<=Math.sqrt(A);i++)
		{
			if(divisible(A,i)==1)
				return 1;
		}
		return 0;
    }
	
	public int divisible(int A,int a){
		if(A==a)
			return 1;
		
		if(A%a==0)
			return divisible(A/a,a);
		
		return 0;
	}
}
