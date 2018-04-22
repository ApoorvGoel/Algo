package InterviewBit;

public class sqrta {
int number;
	public static void main(String[] args) {
		System.out.println(new sqrta().sqrt(10));
	}
	
	public int sqrt(int a) {
		return (int)getSqrt(a,1,a);
	}
	
	public long getSqrt(long a,long i, long j){

		long mid =(j+i)/2;
		if(mid*mid==a)
			return mid;
		else
			if((((mid+1)*(mid+1))>a )&&(((mid)*(mid))<a))
					return mid;
		else
		if(mid*mid<a)
				return getSqrt(a,mid,2*mid);
		else
			return getSqrt(a,i,mid);
	}
	
}
