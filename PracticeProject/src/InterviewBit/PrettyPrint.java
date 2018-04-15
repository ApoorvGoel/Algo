package InterviewBit;

import java.util.ArrayList;

import Spiral.MainEntry;

public class PrettyPrint {

	
	public static void main(String[] args) {
		System.out.println(prettyPrint(4));
	}
	
	
	public static ArrayList<Integer> addOuter(ArrayList<Integer> Index,int A){
		
		for (int i =0 ;i<2*A-1;i++) {
			Index.add(A);
		}
		return Index;
	}
	public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		ArrayList<ArrayList<Integer>> outputList =new ArrayList<ArrayList<Integer>>();
		
		for (int i =1 ;i<=A;i++) {
			
			ArrayList<Integer> Index1=new ArrayList<Integer>();

			for(int j=1;j<=i-1;j++){
				Index1.add(A-j+1);
			}
			addOuter(Index1,A-i+1);
			for(int j=i-1;j>=1;j--){
				Index1.add(A-j+1);
			}
			outputList.add(Index1);
		}
		for (int i =A-2 ;i>=0;i--) {
			outputList.add(outputList.get(i));
		}
		
		return outputList;
	}

}
