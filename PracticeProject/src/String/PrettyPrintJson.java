package String;

import java.util.ArrayList;

public class PrettyPrintJson {

	public static void main(String[] args) {
		String test="{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}";
		System.out.println(test);
		String test1="{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
		System.out.println(prettyJSON(test1));
		String test2="{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
		System.out.println(prettyJSON(test2));
	}

	public static ArrayList<String> prettyJSON(String A) {
		String token = "\t";
		StringBuilder sb = new StringBuilder();
		ArrayList<String> res = new ArrayList<>();
		
		for (int i = 0; i < A.length(); i++) {
			StringBuilder sr = new StringBuilder();
			if (A.charAt(i) == '{' || A.charAt(i) == '[') {
				sb.append(token);
				sr.append(A.charAt(i));
				res.add(sr.toString());
				continue;
			}
			else if (A.charAt(i) == '}' || A.charAt(i) == ']') {
				if(sb.length()>0)
				sb.delete(sb.length()-1, sb.length());
				sr.append(A.charAt(i));
				res.add(sr.toString());
				continue;
			}
			sr.append(sb);
			while(i<A.length()&&A.charAt(i)!=','&&!(A.charAt(i) == '}' || A.charAt(i) == ']') && !(A.charAt(i) == '}' || A.charAt(i) == ']')){
				sr.append(A.charAt(i));
				i++;
			}
			if(i<A.length()&&A.charAt(i)==',')
				sr.append(A.charAt(i));
			
			res.add(sr.toString());

			if (i<A.length()&&(A.charAt(i) == '}' || A.charAt(i) == ']')) {
				sr = new StringBuilder();
				sb.delete(sb.length()-1, sb.length());
				sr.append(A.charAt(i));
				res.add(sr.toString());
			}
			
			if(i<A.length()&&(A.charAt(i) == '}' || A.charAt(i) == ']')){
				i--;
			}
		}

		return res;
	}
}
