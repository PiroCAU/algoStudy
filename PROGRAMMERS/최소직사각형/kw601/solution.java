import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int max_row = 0;
        int max_col = 0;
        
        for (int[] size : sizes){
            int row = Math.max(size[0], size[1]);
            int col = Math.min(size[0], size[1]);
            
            max_row = Math.max(row, max_row);
            max_col = Math.max(col, max_col);
            
        }
        return max_row * max_col;
    }
}