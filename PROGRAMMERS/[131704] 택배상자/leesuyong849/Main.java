import java.util.*;

class Solution {
    public static int solution(int[] order) {

        int nextIndex = 0;      //
        int nextValue = 1;
        Stack<Integer> stack = new Stack<>();       //추가 밸트

        while(nextIndex < order.length) {
            if (nextValue == order[nextIndex]) {
                nextIndex++;
                nextValue++;
            } else if (!stack.isEmpty() && stack.peek() == order[nextIndex]) {
                nextIndex++;
                stack.pop();
            } else if (nextValue <= order.length){
                stack.push(nextValue);
                nextValue++;
            } else {
                break;
            }
        }

        return nextIndex;
    }
}