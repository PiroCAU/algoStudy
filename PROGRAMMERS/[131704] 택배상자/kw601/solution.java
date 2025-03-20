import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        
        int curBox = 1;
        int orderIdx = 0;
        
        while (orderIdx < order.length) {
            // 1. 실어야 할 순번 > 지금 박스 번호
            // 박스 stack에 넣기
            if (curBox <= order[orderIdx]) {
                stack.push(curBox);
                curBox++;
            } 
            // 2. 실어야 할 순번 == 지금 박스 번호
            // pop
            else if (stack.peek() == order[orderIdx]) {
                stack.pop();
                orderIdx++;
            } 

            else {
                return orderIdx;
            }
        }

        return orderIdx;
    }
}