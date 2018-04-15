package Billing;

import org.apache.commons.lang.StringUtils;

public class StringManup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String balResponse="mainAccount#694|DA1#0#99991231T12:00:00+0000,DA2#0#99991231T12:00:00+0000,DA4#0#99991231T12:00:00+0000,DA5#0#99991231T12:00:00+0000,DA6#0#99991231T12:00:00+0000,DA7#0#99991231T12:00:00+0000,DA8#0#99991231T12:00:00+0000,DA9#0#99991231T12:00:00+0000,DA10#0#99991231T12:00:00+0000,DA30#1#20190810T12:00:00+0000";
		String balResponse1="1,0,100";
		
		String sub_type=parseBalanceResponse(balResponse,0);
		if("1".equalsIgnoreCase(sub_type)){
			String balance=parseBalanceResponse(balResponse,2);
			System.out.println(balance);
		}else if("2".equalsIgnoreCase(sub_type)){

		}else if(StringUtils.contains(sub_type, "#") && StringUtils.contains(sub_type, "|") ){
			System.out.println(parseBalanceStringForUcip(sub_type));
		}
	}
	
	public static String parseBalanceStringForUcip(String sub_type){
		String hashArr[]=StringUtils.split(sub_type, "#");
		String pipeArr[]=StringUtils.split(hashArr[1],"|");
		return pipeArr[0];
	}
	
	public static String parseBalanceResponse(String balResponse,int index){
		try{
		if(!StringUtils.isEmpty(balResponse)){
			String res[]=balResponse.split(",");
			 return res[index];
		}
		else
			return "-1";
		}catch(Exception e){
			return "-1";
		}
	}

}
