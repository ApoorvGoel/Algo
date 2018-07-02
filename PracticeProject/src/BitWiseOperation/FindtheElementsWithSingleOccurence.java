package BitWiseOperation;

public class FindtheElementsWithSingleOccurence {

	private static final int INT_SIZE = 32;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int getSingle(int arr[]) {
		int result = 0;
		int x, sum;

		// Iterate through every bit
		for (int i = 0; i < INT_SIZE; i++) {
			// Find sum of set bits at ith position in all
			// array elements
			sum = 0;
			x = (1 << i);
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & x) != 0)
					sum++;
			}
			// The bits with sum not multiple of 3, are the
			// bits of element with single occurrence.
			if ((sum % 3) != 0)
				result |= x;
		}
		return result;
	}
}
