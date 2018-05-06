package backtracking;

import java.util.ArrayList;

public class Sudoku {

	public static void main(String[] args) {
		Character a = '9';
		int b = 9;
		System.out.println(a - 48 == b);
		Character c=(char)(b+48);
		System.out.println(c);
	}

	class Index {
		int row;
		int col;
	}

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solveSudokuUtil(a);
	}

	public boolean isUnassigned( ArrayList<ArrayList<Character>> a, Index index) {
		for (index.row = 0; index.row < a.size(); index.row++) {
			for (index.col = 0; index.col < a.get(index.row).size(); index.col++) {
				if ((a.get(index.row).get(index.col)) == '.')
					return true;
			}
		}
		return false;
	}

	public boolean isUsable(int num, ArrayList<ArrayList<Character>> a, Index index) {

		return isUsableRow(num, a, index) && isUsableCol(num, a, index) && isUsableBlock(num, a, index.row - (index.row % 3), index.col - (index.col % 3));
	}

	public boolean isUsableRow(int num, ArrayList<ArrayList<Character>> a, Index index) {
		for (int i = 0; i < a.size(); i++) {
			if ((a.get(index.row).get(i) - 48) == num) {
				return false;
			}
		}
		return true;
	}

	public boolean isUsableCol(int num, ArrayList<ArrayList<Character>> a, Index index) {
		for (int i = 0; i < a.get(index.row).size(); i++) {
			if ((a.get(i).get(index.col) - 48) == num) {
				return false;
			}
		}
		return true;
	}

	public boolean isUsableBlock(int num, ArrayList<ArrayList<Character>> a, int rowStartingIndex, int colStartedIndex) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((a.get(i + rowStartingIndex).get(j + colStartedIndex) - 48) == num)
					return false;
			}
		}
		return true;
	}

	public boolean solveSudokuUtil(ArrayList<ArrayList<Character>> a) {
		 Index index = new Index();
		if(!isUnassigned(a,index))
			return true;
		for(int num =1;num<=9;num++){
			if(isUsable(num,a,index)){
				a.get(index.row).set(index.col, (char)(num+48));
				
				if(solveSudokuUtil(a))
					return true;
				
				a.get(index.row).set(index.col, '.');
			}
		}
		return false;
	}
}
