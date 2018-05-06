package String;

public class CountAndSay {

	public static void main(String[] args) {
		
		int a=0;
		System.out.println(a);
		a=4;
		System.out.println(a);
		System.out.println(countAndSay(a));
	}
	
	public static String countAndSay(int A) {
		String result="1";
		for(int i=2;i<=A;i++){
			result=count(result);
		}
		
		return result;
	}
	
	public static String count(String a){
		if(a.equals("1"))
			return "11";
		
		StringBuilder res = new StringBuilder();
		
		int counter=0;
		for(int i=1;i<a.length();i++){
			counter=1;
			while(i<a.length() &&(a.charAt(i-1)==a.charAt(i))){
				i++;
				counter++;
			}
			res.append(counter).append(a.charAt(i-1)-48);
		}
		
		if(a.charAt(a.length()-1)!=a.charAt(a.length()-2)){
			res.append(1).append(a.charAt(a.length()-1)-48);
		}
		
		return res.toString();
	}
}
