package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		Interval i = new Interval(3, 13);
		Interval i1 = new Interval(1, 17);
		Interval i2 = new Interval(1, 32);
		ArrayList<Interval> returnList = new ArrayList<Interval>();
		returnList.add(i);
		returnList.add(i1);
		returnList.add(i2);
		System.out.println(new MergeOverlappingIntervals().mergeNewest(returnList));
	}

	//Correct Solution
	public ArrayList<Interval> mergeNewest( final ArrayList<Interval> intervals) {
		ArrayList<Interval> returnList = new ArrayList<Interval>();

		Collections.sort(intervals, new startParamComaparator());
		int max = 0;
		int min = 0;
		if(intervals.size()<=1)
			return intervals;
		returnList.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval resInte=	returnList.get(returnList.size()-1);
			max = (intervals.get(i).start > resInte.start) ? intervals.get(i).start : resInte.start;
			min = (intervals.get(i).end < resInte.end) ? intervals.get(i).end : resInte.end;
			if (max <= min) {
				resInte.end = (intervals.get(i).end > resInte.end) ? intervals.get(i).end : resInte.end;
			}else{
				returnList.add(intervals.get(i));
			}
		}

		return returnList;

	}
	
	public ArrayList<Interval> mergeNew(ArrayList<Interval> intervals) {
		ArrayList<Interval> returnList = new ArrayList<Interval>();

		Collections.sort(intervals, new startParamComaparator());
		int max = 0;
		int min = 0;
		for (int i = 0; i < intervals.size(); i++) {
			Interval resInte = new Interval();
			resInte.start = intervals.get(i).start;
			resInte.end = intervals.get(i).end;
			if ((i + 1) < intervals.size()) {
				max = (intervals.get(i).start > intervals.get(i + 1).start) ? intervals.get(i).start : intervals.get(i + 1).start;
				min = (intervals.get(i).end < intervals.get(i + 1).end) ? intervals.get(i).end : intervals.get(i + 1).end;
				if (max <= min) {
					resInte.start = intervals.get(i).start;
					resInte.end = (intervals.get(i).end > intervals.get(i + 1).end) ? intervals.get(i).end : intervals.get(i + 1).end;
				}
			}
			if (returnList.size() == 0) {
				returnList.add(resInte);
				continue;
			}
			if (returnList.get(returnList.size() - 1).end < resInte.end)
				returnList.add(resInte);
			

		}

		return returnList;

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> returnList = new ArrayList<Interval>();

		Collections.sort(intervals, new startParamComaparator());

		for (int i = 0; i < intervals.size(); i++) {
			Interval resInte = new Interval();
			resInte.start = intervals.get(i).start;
			resInte.end = 0;
			if ((i + 1) < intervals.size()) {
				if (intervals.get(i).end >= intervals.get(i + 1).start) {
					resInte.end = (intervals.get(i + 1).end > intervals.get(i).end) ? intervals.get(i + 1).end : intervals.get(i).end;
				}
			}
			if (resInte.end == 0)
				resInte.end = intervals.get(i).end;
			if (returnList.size() == 0) {
				returnList.add(resInte);
				continue;
			}

			if (returnList.get(returnList.size() - 1).end < resInte.end)
				returnList.add(resInte);
		}

		return returnList;

	}

}

class startParamComaparator implements Comparator<Interval> {

	public int compare(Interval o1, Interval o2) {
		if (o1.start == o2.start)
			return 0;
		if (o1.start > o2.start)
			return 1;
		return -1;
	}

}

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
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}