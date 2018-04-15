package InterviewBit;

import java.util.ArrayList;

/*
 * 

You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 

You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2

It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.

 * 
 */
public class MinStepsinInfiniteGrid {

}
 class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    
    int getDifference(int x, int y){
        if ((x-y)>0)
        return x-y;
        else
        return y-x;
    }
    
    int getMaxDifference(int x1, int x2, int y1, int y2){
        int x= getDifference(x1,x2);
        int y= getDifference(y1,y2);
        
        return (x>y)?x:y;
    }
    
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x=0;
        int y=0;
        int x1=0;
        int y1=0;
        int counter=0;
        
        
        if (X.size()==0)
        return 0;
        
        x=X.get(0);
        y=Y.get(0);
        
        for(int i=1;i<X.size();i++){
            x1=X.get(i);
            y1=Y.get(i);
            
            counter = counter + getMaxDifference(x,x1,y,y1);
            
            x=x1;
            y=y1;
        }
        
        return counter;
    }
}
