package Math;

import Spiral.MainEntry;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverse(-1234567891));
	}
	
	 public static int reverse(int A) {
	        int reverse=0;
	        String srev =""+A;
	        StringBuilder s = new StringBuilder();
	        if(A>0){
	        for(int i=srev.length()-1;i>=0;i--){
	        	s.append(srev.charAt(i));
	        }}else{
	            s.append('-');
	        for(int i=srev.length()-1;i>0;i--){
	        	s.append(srev.charAt(i));
	        }
	        
	        }
	        try{
	        reverse=Integer.parseInt(s.toString());
	        }catch(Exception ex){
	        	return 0;
	        }
	        return reverse;
	    }
}
