package String;

public class StringReverse {

	public static void main(String[] args) {
		String a="the sky is blue";
		StringBuilder result= reverse(a);
		System.out.println(result);
		int startIndex=0;
		StringBuilder returnString= new StringBuilder();;
		for(int i=0;i<result.length();i++){
			if(result.charAt(i)==' '){
				System.out.println("if"+i);
				System.out.println(reverse(result.substring(startIndex, i)));
				System.out.println(result);
				returnString.append(reverse(result.substring(startIndex, i)));
				returnString.append(' ');
				startIndex=i+1;
			}
			while((result.charAt(i)==' ')&&i<result.length()){
				System.out.println("while"+i);
				i++;
			}
		}
		returnString.append(reverse(result.substring(startIndex, result.length())));
		System.out.println(returnString);
		
	}
	
	public static StringBuilder reverse(String a){
		StringBuilder result= new StringBuilder();
		for (int i = a.length()-1; i >= 0; i--) {
			result.append(a.charAt(i));
		}
		return result;
	}
}
