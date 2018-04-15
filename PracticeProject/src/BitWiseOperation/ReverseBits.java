package BitWiseOperation;

public class ReverseBits {

	public static void main(String[] args) {
		long a = 4;
		long b = 0;
		/*
		 * System.out.println(a>>1); a>>=1; System.out.println(a);
		 * 
		 * b|=( a &1);
		 * 
		 * System.out.println(b); System.out.println( a &1);
		 */

		int i = 0;
		while (i != 32) {
			b <<= 1;
			b |= (a & 1);
			a >>= 1;
			i++;
		}
		System.out.println(b);

	}
}
