package BinarySearch;

public class PowerFunction {

	public static void main(String[] args) {
		
		System.out.println(new PowerFunction().pow1(71045970, 41535484,64735492));
	}

	public int pow1(long x, long n, long d) {
		if(x==0)
			return 0;
		
		if(n==0)
			return 1;
        
        Long res=pow(x, n,d);
       System.out.println(res);
       System.out.println(res%d);
        while(res<0){
            res=res+d;
        }
		return (int)((res)% d);

	}

	Long pow(Long x, Long n,Long d) {
		Long res = 0l;
		if (x == 1 || n == 1)
		{			System.out.println(x);
			return x;
		}
		if (n % 2 == 0) {
			res = (pow(x, n / 2,d))%d;
			System.out.println(res);
			return (res * res)%d;
		} else {
			res = (pow(x, n / 2,d))%d;
			System.out.println(res);
			return (((res * res)%d) * (x%d))%d;
		}
	}
}
