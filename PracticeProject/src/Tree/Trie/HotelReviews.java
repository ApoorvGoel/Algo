package Tree.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class HotelReviews {

	public static void main(String[] args) {
		ReviewTrie trie = new ReviewTrie();
		trie.insert("dog");
		trie.insert("dove");
		trie.insert("duck");
		System.out.println(trie.searchString("d"));
	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		String goodWords[] = A.split("_");
		ReviewTrie trie = new ReviewTrie();
		for (String string : goodWords) {
			trie.insert(string);
		}
		//TreeMap<Integer, Integer> map = new TreeMap<>();  -- tree map does not store 0 as key. hense using arraylist
		ArrayList<GoodReviewCounter> counter = new ArrayList<GoodReviewCounter>();
		for (int i = 0; i < B.size(); i++) {
			String review[] = B.get(i).split("_");
			int count = 0;
			for (String string : review) {
				count += trie.searchString(string);
			}
		//	map.put(count, i);
			counter.add(new GoodReviewCounter(i, count));
		}
		
		Collections.sort(counter,new CounterComparator());
		ArrayList<Integer> result = new ArrayList<>();
		for (GoodReviewCounter goodReviewCounter : counter) {
			result.add(goodReviewCounter.id);
		}
		
	/*	for (Integer integer : map.keySet()) {
			result.add(map.get(integer));
		}*/
		
		return result;
	}
}

class CounterComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GoodReviewCounter gc1=(GoodReviewCounter)o1;
		GoodReviewCounter gc2=(GoodReviewCounter)o2;
		return Integer.compare(gc2.count,gc1.count);
	}
	
}

class GoodReviewCounter{
	int id;
	int count;
	public GoodReviewCounter(int id, int count) {
		super();
		this.id = id;
		this.count = count;
	}	
}
class Node {
	char val;
	HashMap<Character, Node> children;
	boolean isEndOfWord;

	public Node(char val) {
		super();
		this.val = val;
		children = new HashMap<>();
		isEndOfWord = false;
	}

	@Override
	public String toString() {
		return "TrieNode [val=" + val + ", children=" + children + ", isEndOfWord=" + isEndOfWord + "]";
	}
}

class ReviewTrie {
	Node root;

	public ReviewTrie() {
		root = new Node((char) 0);
	}

	public void insert(String word) {
		int length = word.length();
		Node crawl = root;
		for (int level = 0; level < length; level++) {
			HashMap<Character, Node> children = crawl.children;
			char c = word.charAt(level);
			if (children.containsKey(c)) {
				crawl = children.get(c);
			} else {
				crawl = new Node(c);
				children.put(c, crawl);
			}
		}
		crawl.isEndOfWord = true;
	}

	public int searchString(String word) {
		int length = word.length();
		Node crawl = root;

		for (int level = 0; level < length; level++) {
			HashMap<Character, Node> children = crawl.children;
			char c = word.charAt(level);
			if (children.containsKey(c)) {
				crawl = children.get(c);
			} else {
				return 0;
			}

		}
		if (crawl.isEndOfWord)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Trie [root=" + root + "]";
	}

}