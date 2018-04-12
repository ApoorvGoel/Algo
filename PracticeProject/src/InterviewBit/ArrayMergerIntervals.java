package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * 
 * 

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

 Example 2:

 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Make sure the returned intervals are also sorted.

 */

/*
 * 
 * Hint
 * 

 This problem has a lot of corner cases which need to be handled correctly.

 Let us first talk about the approach.
 Given all the intervals, you need to figure out the sequence of intervals which intersect with the given newInterval.

 Lets see how we check if interval 1 (a,b) intersects with interval 2 (c,d):

 Overlap case :

 a---------------------b                      OR       a------b
 c-------------------d                c------------------d

 Non overlap case :

 a--------------------b   c------------------d

 Note that if max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.

 Once we figure out the intervals ( interval[i] to interval[j] ) which overlap with newInterval, note that we can replace all the overlapping intervals with one interval which would be

 (min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)).

 Do make sure you cover the other corner cases.
 */

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + "," + end;
	}
}

public class ArrayMergerIntervals {
	Boolean Compare(Interval int1, Interval int2) {
		if (int1.start < int2.end && int1.end > int2.start) {
			return true;
		}
		return false;
	}

	Integer getLesserValue(Integer int1, Integer int2) {
		if (int1 < int2) {
			return int1;
		}
		return int2;
	}

	Integer getGreaterValue(Integer int1, Integer int2) {
		if (int1 > int2) {
			return int1;
		}
		return int2;
	}

	public ArrayList<Interval> insert_old(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> resultIntervalList = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval currInterval = intervals.get(i);
			if (Compare(currInterval, newInterval)) {
				Interval dummyInterval = new Interval();
				dummyInterval.start = getLesserValue(currInterval.start, newInterval.start);
				int flag = 0;
				while (i < intervals.size() && Compare(intervals.get(i), newInterval)) {
					i++;
					flag = 1;
				}
				if (i < intervals.size() && flag == 0)
					currInterval = intervals.get(i);
				else {
					currInterval = intervals.get(--i);
				}
				dummyInterval.end = getGreaterValue(currInterval.end, newInterval.end);
				resultIntervalList.add(dummyInterval);
			} else {
				resultIntervalList.add(currInterval);
			}
		}
		return resultIntervalList;
	}

	public static void main(String[] args) {
		ArrayMergerIntervals aa = new ArrayMergerIntervals();
		ArrayList<Interval> IntervalList = new ArrayList<Interval>();
		IntervalList.add(new Interval(1, 3));
		IntervalList.add(new Interval(6, 9));
		System.out.println(aa.insert(IntervalList, new Interval(2, 5)));

		ArrayList<Interval> IntervalList1 = new ArrayList<Interval>();
		IntervalList1.add(new Interval(1, 2));
		IntervalList1.add(new Interval(3, 5));
		IntervalList1.add(new Interval(1, 3));
		IntervalList1.add(new Interval(6, 7));
		IntervalList1.add(new Interval(8, 10));
		IntervalList1.add(new Interval(12, 16));
		System.out.println(aa.insert(IntervalList1, new Interval(4, 9)));

		ArrayList<Interval> IntervalList2 = new ArrayList<Interval>();
		IntervalList2.add(new Interval(1, 2));
		IntervalList2.add(new Interval(3, 6));
		System.out.println("1"+aa.insert(IntervalList2, new Interval(10, 8)));

		ArrayList<Interval> IntervalList3 = new ArrayList<Interval>();
		IntervalList3.add(new Interval(1, 2));
		IntervalList3.add(new Interval(8, 10));
		System.out.println("2"+aa.insert(IntervalList3, new Interval(3, 6)));

		ArrayList<Interval> IntervalList4 = new ArrayList<Interval>();
		IntervalList4.add(new Interval(3, 5));
		IntervalList4.add(new Interval(8, 10));
		System.out.println(aa.insert(IntervalList4, new Interval(1, 12)));

		ArrayList<Interval> IntervalList5 = new ArrayList<Interval>();
		IntervalList5.add(new Interval(3, 5));
		IntervalList5.add(new Interval(8, 10));
		System.out.println(aa.insert(IntervalList5, new Interval(3, 10)));

		ArrayList<Interval> IntervalList6 = new ArrayList<Interval>();
		IntervalList6.add(new Interval(31935139, 38366404));
		IntervalList6.add(new Interval(54099301, 76986474));
		IntervalList6.add(new Interval(87248431, 94675146));

		System.out.println(aa.insert(IntervalList6, new Interval(43262807, 68844111)));

	}

	public boolean isOverlapping(ArrayList<Interval> intervals, Interval newInterval) {
		if (intervals.get(intervals.size() - 1).end < newInterval.start || newInterval.end < intervals.get(0).start)
			return false;
		return true;
	}

	public Interval arangeNewInterval(Interval newInterval) {
		if (newInterval.start <= newInterval.end)
			return newInterval;
		int dummy = newInterval.start;
		newInterval.start = newInterval.end;
		newInterval.end = dummy;
		return newInterval;
	}

	public ArrayList<Interval> handleNonOverlapping(ArrayList<Interval> intervals, Interval newInterval) {
		if (intervals.get(intervals.size() - 1).end < newInterval.start) {
			intervals.add(newInterval);
			return intervals;
		} else if (newInterval.end < intervals.get(0).start) {
			ArrayList<Interval> responseIntervals = new ArrayList<Interval>();
			responseIntervals.add(newInterval);
			responseIntervals.addAll(intervals);
			return responseIntervals;
		}
		return intervals;
	}

	class startParamComaparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start == o2.start)
				return 0;
			if (o1.start > o2.start)
				return 1;
			return -1;
		}

	}

	public boolean isOverLapInterval(Interval a, Interval b) {

		if ((a.start == b.start) || (a.start < b.start && a.end > b.end) || (a.start > b.start && a.end < b.end && a.end > b.start)||(a.start<b.start && a.end>b.start))
			return true;
		else
			return false;
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		newInterval = arangeNewInterval(newInterval);
		if(intervals.size()==0 || intervals==null){
			intervals.add(newInterval);
			return intervals;
		}
		
		
		if (isOverlapping(intervals, newInterval)) {
			intervals.add(newInterval);
			Collections.sort(intervals, new startParamComaparator());

			LinkedList<Interval> intervalStack = new LinkedList<Interval>();

			intervalStack.push(intervals.get(0));

			for (int i = 1; i < intervals.size(); i++) {
				Interval currInt = null;
				currInt = intervalStack.peek();
				if (isOverLapInterval(currInt, intervals.get(i))) {
					intervalStack.pop();
					intervalStack.push(new Interval(getLesserValue(currInt.start, intervals.get(i).start), getGreaterValue(currInt.end, intervals.get(i).end)));
				} else {
					intervalStack.push(intervals.get(i));
				}
			}
			
			ArrayList<Interval> resultList = new ArrayList<Interval>();
			
			for (int i =intervalStack.size()-1; i >=0; i--) {
				resultList.add(intervalStack.pollLast());			
			}
			return resultList;
		} else {
			intervals = handleNonOverlapping(intervals, newInterval);
		}

		return intervals;
	}

	public ArrayList<Interval> insert_old_latest(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> resultIntervalList = new ArrayList<Interval>();
		int i = 0;

		if (intervals.size() == 0 || (intervals.get(intervals.size() - 1).start < newInterval.start && intervals.get(intervals.size() - 1).end < newInterval.end)) {
			intervals.add(new Interval(getLesserValue(newInterval.start, newInterval.end), getGreaterValue(newInterval.start, newInterval.end)));
			return intervals;
		}

		if (intervals.get(0).start > newInterval.start && intervals.get(0).end > newInterval.end) {
			resultIntervalList.add(new Interval(getLesserValue(newInterval.start, newInterval.end), getGreaterValue(newInterval.start, newInterval.end)));
			for (Interval it : intervals) {
				resultIntervalList.add(it);
			}
			return resultIntervalList;
		}

		while (i < intervals.size() && intervals.get(i).start <= newInterval.start && intervals.get(i).end <= newInterval.start) {
			resultIntervalList.add(intervals.get(i));
			i++;
			continue;
		}
		if (i < intervals.size() && intervals.get(i).start <= newInterval.start && intervals.get(i).end > intervals.get(i).start) {
			Interval currIt = new Interval();
			currIt.start = intervals.get(i).start;
			while (i < intervals.size() && intervals.get(i).end < newInterval.end) {
				i++;
			}
			if (i < intervals.size() && intervals.get(i).end >= newInterval.end) {
				if (i < intervals.size() && intervals.get(i).start < newInterval.end) {
					currIt.end = getGreaterValue(intervals.get(i).end, newInterval.end);
					i++;
				} else
					currIt.end = getGreaterValue(intervals.get(i - 1).end, newInterval.end);
			} else {
				currIt.end = newInterval.end;
			}
			currIt.start = getLesserValue(currIt.start, currIt.end);
			currIt.end = getGreaterValue(currIt.start, currIt.end);
			resultIntervalList.add(currIt);
		} else if (i < intervals.size() && intervals.get(i).start > newInterval.start && intervals.get(i).end > newInterval.end) {
			if (intervals.get(i).start > newInterval.end)
				resultIntervalList.add(new Interval(getLesserValue(newInterval.start, newInterval.end), getGreaterValue(newInterval.start, newInterval.end)));
			else {
				resultIntervalList.add(new Interval(newInterval.start, intervals.get(i).end));
				i++;
			}
		} else if (i < intervals.size() && intervals.get(i).start > newInterval.start && intervals.get(i).end < newInterval.end) {
			Interval currIt = new Interval();
			currIt.start = newInterval.start;
			while (i < intervals.size() && intervals.get(i).end <= newInterval.end) {
				i++;
			}
			currIt.end = newInterval.end;
			resultIntervalList.add(currIt);
		}
		while (i < intervals.size()) {
			resultIntervalList.add(intervals.get(i));
			i++;
			continue;
		}

		return resultIntervalList;
	}
}
