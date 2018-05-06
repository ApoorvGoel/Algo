package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnTheStraightLine {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		/*a.add(1);
		a.add(1);
		a.add(1);*/
		//a.add(1);
		//a.add(1);
		ArrayList<Integer> b = new ArrayList<>();
		/*b.add(0);
		b.add(4);
		b.add(-1)*/;
		//b.add(1);
		//b.add(1);
		
		a.add(-14);
		b.add(2);
		a.add(7);
		b.add(10);
		a.add(10);
		b.add(-1);
		a.add(-11);
		b.add(8);
		a.add(20);
		b.add(20);
		a.add(-15);
		b.add(-20);
		a.add(14);
		b.add(-8);
		a.add(17);
		b.add(15);
		a.add(-18);
		b.add(5);
		a.add(14);
		b.add(2);
		a.add(-17);
		b.add(-1);
		a.add(9);
		b.add(8);
		a.add(3);
		b.add(17);
		a.add(9);
		b.add(-8);
		a.add(5);
		b.add(-10);
		a.add(3);
		b.add(-6);
		a.add(-10);
		b.add(-18);
		a.add(4);
		b.add(13);
		a.add(-14);
		b.add(8);
		a.add(17);
		b.add(12);
		a.add(11);
		b.add(7);
		a.add(-3);
		b.add(-15);
		a.add(-1);
		b.add(3);
		a.add(10);
		b.add(4);
		a.add(0);
		b.add(9);
		a.add(-10);
		b.add(-12);
		a.add(-10);
		b.add(-18);
		a.add(19);
		b.add(-19);
		a.add(15);
		b.add(-5);
		a.add(12);
		b.add(11);
		a.add(1);
		b.add(-6);
		a.add(8);
		b.add(18);
		a.add(7);
		b.add(2);
		a.add(9);
		b.add(8);
		a.add(-18);
		b.add(-1);
		a.add(19);
		b.add(12);
		a.add(5);
		b.add(-15);
		a.add(5);
		b.add(5);
		a.add(10);
		b.add(-18);
		a.add(-1);
		b.add(-17);
		a.add(-15);
		b.add(-6);
		a.add(-16);
		b.add(16);
		a.add(-18);
		b.add(-18);
		a.add(-10);
		b.add(19);
		a.add(4);
		b.add(7);
		a.add(-15);
		b.add(-17);
		a.add(12);
		b.add(-3);
		a.add(-18);
		b.add(13);
		a.add(-16);
		b.add(14);
		a.add(8);
		b.add(-15);
		a.add(10);
		b.add(1);
		a.add(12);
		b.add(3);
		a.add(1);
		b.add(-8);
		a.add(-8);
		b.add(-10);
		a.add(5);
		b.add(1);
		a.add(-17);
		b.add(-12);
		a.add(9);
		b.add(-7);
		a.add(12);
		b.add(-17);
		a.add(12);
		b.add(8);
		a.add(-9);
		b.add(11);
		a.add(-19);
		b.add(18);
		a.add(-19);
		b.add(-3);
		a.add(-3);
		b.add(-5);
		a.add(-16);
		b.add(4);
		a.add(16);
		b.add(-2);
		a.add(-7);
		b.add(16);
		a.add(-9);
		b.add(1);
		a.add(-4);
		b.add(15);
		a.add(9);
		b.add(-15);
		a.add(14);
		b.add(14);
		a.add(-3);
		b.add(5);
		a.add(-7);
		b.add(4);
		a.add(-8);
		b.add(2);
		a.add(5);
		b.add(4);
		a.add(13);
		b.add(-2);
		a.add(-17);
		b.add(-2);
		a.add(7);
		b.add(-17);
		a.add(3);
		b.add(6);
		a.add(-11);
		b.add(9);
		a.add(4);
		b.add(-14);
		a.add(4);
		b.add(-14);
		a.add(20);
		b.add(-15);
		a.add(-6);
		b.add(17);
		a.add(19);
		b.add(-19);
		a.add(-15);
		b.add(13);
		a.add(-12);
		b.add(-2);
		a.add(-4);
		b.add(-17);
		a.add(1);
		b.add(12);
		a.add(-20);
		b.add(-13);
		a.add(-16);
		b.add(0);
		a.add(2);
		b.add(3);
		a.add(-3);
		b.add(-4);
		a.add(-12);
		b.add(-18);
		a.add(-14);
		b.add(18);
		a.add(-2);
		b.add(3);
System.out.println(a);
System.out.println(b);
		System.out.println(new PointsOnTheStraightLine().maxPoints(a, b));
	}

	public int gcd(int x, int y) {
		int numerator;
		int denominator;
		int remainder;
		if (x > y) {
			numerator = x;
			denominator = y;
		} else {
			numerator = y;
			denominator = x;
		}
		remainder = numerator % denominator;
		while (remainder != 0) {
			numerator = denominator;
			denominator = remainder;
			remainder = numerator % denominator;
		}
		return denominator;
	}

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		int maxPoints = 0;
		int curMax = 0;
		HashMap<String, Integer> hm = new HashMap<>();
		int overLappingCounts = 0;
		int verticalPoints = 0;
		for (int i = 0; i < a.size(); i++) {
			overLappingCounts = 0;
			curMax = 0;
			verticalPoints = 0;
			for (int j = 0; j < a.size(); j++) {
				if ((a.get(i) == a.get(j)) && (b.get(i) == b.get(j))) {
					overLappingCounts++;
					continue;
				} else if ((a.get(i) == a.get(j))) {
					verticalPoints++;
				}
				{
					int dx = a.get(j) - a.get(i);
					int dy = b.get(j) - b.get(i);
					int gcd = 0;
					if (dx != 0 && dy != 0)
						gcd = gcd(dx, dy);
					if (gcd != 0) {
						dy /= gcd;
						dx /= gcd;
					}
					String key = dy + "/" + dx;
					/*		if(dy==0&&dx==0)
				    key="0/0";
			else	if(dy==0)
				    key="1/0";
			else	if(dx==0)
				    key="0/1";
				    System.out.println(key);*/
					int count = 0;
					if (hm.containsKey(key)) {
						int val = hm.get(key);
						val++;
						count = hm.put(key, val);
					} else
						hm.put(key, 1);
					count = count + 1;
					curMax = (curMax > count) ? curMax : count;
				}
				curMax = (curMax > verticalPoints) ? curMax : verticalPoints;
				System.out.println(i+".."+j);
			}
			System.out.println(hm);
			hm.clear();
			maxPoints = (maxPoints > (curMax + overLappingCounts + 1)) ? maxPoints : curMax + overLappingCounts + 1;
			System.out.println(maxPoints);
		}

		return maxPoints;
	}
}
