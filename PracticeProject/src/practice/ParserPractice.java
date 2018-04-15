package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParserPractice {
public static void main(String[] args) {
	String date ="2016/04/20 03:00:00";
	SimpleDateFormat sdfdate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	try {
		System.out.println(sdf1.format(sdfdate.parse(date)));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
