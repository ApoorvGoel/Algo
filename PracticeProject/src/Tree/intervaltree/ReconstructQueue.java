package Tree.intervaltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class ReconstructQueue {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
		tm.put(5, 0);
		tm.put(3, 1);
		tm.put(2, 2);
		tm.put(6,0);
		tm.put(1, 3);
		tm.put(4, 2);
		for (Entry<Integer, Integer> entry : tm.entrySet()) {
			System.out.println(entry);
		}
		Set<Entry<Integer,Integer>> set=tm.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

	public ArrayList<Integer> reconstructQuue(ArrayList<Integer> A, ArrayList<Integer> B) {
		TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < A.size(); i++) {
			tm.put(A.get(i), B.get(i));
		}
		
		Set<Entry<Integer,Integer>> set=tm.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		IntervalTree tree = null;
		if(it.hasNext())		
		tree= new IntervalTree(it.next());
		
		while(it.hasNext()){
			Entry<Integer, Integer> person = it.next();
			tree.insertPerson(tree.root,person ,person.getValue() );
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		tree.inOrderTraversal(result, tree.root);
		return result;
	}

}
class IntervalTree{
	IntervalTreeNode root;
	
	
	public IntervalTree(Entry<Integer, Integer> person) {
		this.root = new IntervalTreeNode(person);
	}


	public void insertPerson(IntervalTreeNode root,Entry<Integer, Integer> person,int value){
		if(value<root.value){
			if(root.left==null)
				root.left= new IntervalTreeNode(person);
			else{
				insertPerson(root.left,person,value);
			}
			root.value+=1;
		}else{
			if(root.right==null)
				root.right= new IntervalTreeNode(person);
			else{
				insertPerson(root.right,person,value-root.value);
			}
		}
	}
	
	public void inOrderTraversal(ArrayList<Integer> result,IntervalTreeNode root){
		if(root==null)
			return;
		inOrderTraversal(result,root.left);
		result.add(root.person.getKey());
		inOrderTraversal(result,root.right);
	}
}
class IntervalTreeNode {
	IntervalTreeNode left;
	IntervalTreeNode right;
	Entry<Integer, Integer> person;
	int value;

	public IntervalTreeNode(Entry<Integer, Integer> person) {
		super();
		this.person = person;
		value=1;
	}
}