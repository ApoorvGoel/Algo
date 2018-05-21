package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class RotatedArrayCheckError {

	public static void main(String[] args) {
	ArrayList<Integer> A = new ArrayList<>();
		A.add(9);
		A.add( 10);
		A.add( 12);
		A.add( 13);
		A.add( 24);
		A.add( 26);
		A.add( 27);
		A.add( 28);
		A.add( 29);
		A.add( 43);
		A.add( 48);
		A.add( 51);
		A.add( 54);
		A.add( 56);
		A.add( 57);
		A.add( 59);
		A.add( 62);
		A.add( 66);
		A.add( 70);
		A.add( 71);
		A.add( 72);
		A.add( 74);
		A.add( 75);
		A.add( 77);
		A.add( 78);
		A.add( 81);
		A.add( 83);
		A.add( 85);
		A.add( 87);
		A.add( 88);
		A.add( 89);
		A.add( 90);
		A.add( 91);
		A.add( 92);
		A.add( 93);
		A.add( 97);
		A.add( 98);
		A.add( 99);
		A.add( 101);
		A.add( 102);
		A.add( 104);
		A.add( 105);
		A.add( 107);
		A.add( 112);
		A.add( 113);
		A.add( 115);
		A.add( 123);
		A.add( 126);
		A.add( 127);
		A.add( 132);
		A.add( 133);
		A.add( 134);
		A.add( 135);
		A.add( 136);
		A.add( 143);
		A.add( 144);
		A.add( 148);
		A.add( 150);
		A.add( 151);
		A.add( 152);
		A.add( 154);
		A.add( 159);
		A.add( 160);
		A.add( 161);
		A.add( 163);
		A.add( 167);
		A.add( 169);
		A.add( 170);
		A.add( 174);
		A.add( 176);
		A.add( 177);
		A.add( 179);
		A.add( 180);
		A.add( 181);
		A.add( 183);
		A.add( 185);
		A.add( 186);
		A.add( 187);
		A.add( 188);
		A.add( 193);
		A.add( 194);
		A.add( 196);
		A.add( 197);
		A.add( 198);
		A.add( 199);
		A.add( 200);
		A.add( 203);
		A.add( 1);
		A.add( 6);
		A.add( 7);
		A.add( 8 );
		
		System.out.println(new RotatedArrayCheckError().search(A,38));

	}
	public int search(final List<Integer> a, int b) {
	    int n=a.size();
	    int high=a.size()-1;
	    int low=0,mid=0,d=0;
	     while(low<=high){
	     mid=low+(high-low)/2;
	     if(a.get(low)<a.get(high)) {d=low;break;}
	     else if(a.get(mid)<a.get(mid+1)&&a.get(mid)<a.get(mid-1)) {d=mid;break;}
	     else if(a.get(mid)>a.get(mid+1)){
	    	 d=mid+1;break;
	     }else if(a.get(mid)<a.get(mid-1)){
	    	 d=mid+1;break;
	     }
	     else if(a.get(low)<a.get(mid)) low=mid+1;
	     else if(a.get(high)>a.get(mid)) high=mid-1;
	        
	    }
	  //  System.out.print(d);
	    high=a.size()-1;
	    low=0;
	    while(low<=high){
	      mid=low+(high-low)/2;
	      if(a.get((mid+d)%n)==b) return ((mid+d)%n);
	      else if(a.get((mid+d)%n)<b) low=mid+1;
	      else high=mid-1;
	    }
	    return -1;
	}
}
