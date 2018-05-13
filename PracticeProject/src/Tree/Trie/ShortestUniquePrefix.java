package Tree.Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("dog");
		trie.insert("dove");
		trie.insert("duck");
		//System.out.println(trie);
		System.out.println(trie.shortestPrefix("duck"));
	}

	public ArrayList<String> prefix(ArrayList<String> A) {
		Trie trie = new Trie();
		ArrayList<String> result = new ArrayList<>();
		for (String string : A) {
			trie.insert(string);
		}
		
		for (String string : A) {
			result.add(trie.shortestPrefix(string));
		}
		
		return result;
	}

}

class TrieNode {
	char val;
	HashMap<Character, TrieNode> children;
	boolean isEndOfWord;
	int noOfOccurence;
	

	public TrieNode(char val) {
		super();
		this.val = val;
		children = new HashMap<>();
		isEndOfWord = false;
		noOfOccurence = 1;
	}


	@Override
	public String toString() {
		return "TrieNode [val=" + val + ", children=" + children + ", isEndOfWord=" + isEndOfWord + ", noOfOccurence=" + noOfOccurence + "]";
	}
	
	
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode((char)0);
	}
	public void insert(String word){
		int length=word.length();
		TrieNode crawl=root;
		
		for(int level=0;level<length;level++){
			HashMap<Character, TrieNode> children=crawl.children;
			char c=word.charAt(level);
			if(children.containsKey(c)){
				crawl=children.get(c);
				crawl.noOfOccurence++;
			}else{
				crawl=new TrieNode(c);
				children.put(c, crawl);
			}
		}
		crawl.isEndOfWord=true;
	}
	
	public String shortestPrefix(String word){
		int length=word.length();
		TrieNode crawl=root;
		StringBuilder result=new StringBuilder();
		
		for(int level=0;level<length;level++){
			HashMap<Character, TrieNode> children=crawl.children;
			char c=word.charAt(level);
			crawl=children.get(c);
			if(crawl.noOfOccurence==1 || crawl.isEndOfWord){
				return result.append(c).toString();
			}
			result.append(c);
		}
		
		return result.toString();
	}
	@Override
	public String toString() {
		return "Trie [root=" + root + "]";
	}
	
	
}