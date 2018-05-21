package greedy;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Seats {

	public static void main(String[] args) {
		System.out.println(new Seats().seats(".x.xxx.xxxxx.x..xx....x..xxx"));
	}

	public int seats(String A) {
		if (A == null || A.length() == 0)
			return 0;
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
		int xCounter = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x') {
				int count = 0;
				int key = i;
				do {
					count++;
					i++;
					xCounter++;
				} while (i < A.length() && A.charAt(i) == 'x');
				hm.put(key, count);
			}
		}

		int n = hm.size();
		if (n == 0 || n == 1)
			return 0;

		int mid = (xCounter % 2 == 0) ? xCounter / 2 : (xCounter / 2) + 1;
		Set<Entry<Integer, Integer>> set = hm.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		Entry<Integer, Integer> middleEntry = null;
		if (n == 2) {
			for (Entry<Integer, Integer> entry : set) {
				if (middleEntry == null || middleEntry.getValue() < entry.getValue()) {
					middleEntry = entry;
				}
			}
		} else
			while (it.hasNext() && mid > 0) {
				middleEntry = it.next();
				mid -= middleEntry.getValue();
			}
		int prev = middleEntry.getKey() - 1;
		int next = middleEntry.getKey() + middleEntry.getValue();

		it = set.iterator();
		int result = 0;
		while (it.hasNext()) {
			Entry<Integer, Integer> currentEntry = it.next();
			if (currentEntry != middleEntry) {
				if (currentEntry.getKey() < middleEntry.getKey()) {
					// result =result+prev-currentEntry.getKey();
					for (int i = 0; i < currentEntry.getValue(); i++) {
						result = (result % 10000003 + prev % 10000003 - currentEntry.getKey() % 10000003 - i % 10000003) % 10000003;
						prev--;
					}
				} else if (currentEntry.getKey() > middleEntry.getKey()) {
					// result =result+prev-currentEntry.getKey();
					for (int i = 0; i < currentEntry.getValue(); i++) {
						result = (result % 10000003 - next % 10000003 + currentEntry.getKey() % 10000003 + i % 10000003) % 10000003;
						next++;
					}
				}
			}
		}

		return result % 10000003;
	}
}
