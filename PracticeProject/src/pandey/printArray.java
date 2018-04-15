package pandey;

public class printArray {

	public static void main(String[] args) {

		Object[] arr = new Object[3];
		arr[0]=new Integer(1);
		arr[1]=new Integer(2);
		Object[] arr1 = new Object[3];
		Object[] arr2 = new Object[3];
		arr1[0]=new Integer(11);
		arr1[1]=new Integer(12);
		arr1[2]=arr2;
		arr[2]=arr1;
		arr2[0]=new Integer(21);
		arr2[1]=new Integer(22);
		arr2[2]=new Integer(23);

		printArray(arr);
		
	}

	static void printArray(Object[] arr){

		for (Object ob : arr) {
			if(ob instanceof Integer){
				System.out.println(ob);
			}else{
				printArray1(ob);
			}
			
		}
	}
	
	static void printArray1(Object arr){
		
		for (Object ob : (Object[])arr) {
			if(ob instanceof Integer){
				System.out.println(ob);
			}else{
				printArray1(ob);
			}
			
		}
	}
}
