class Solution {
    public int solution(int[][] sizes) {
        int size = sizes.length;
        int[][] changedSizes = new int[size][2];

        int max_0 = 0;
        int max_1 = 0;
        for (int i = 0; i < size; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                if (sizes[i][0] > max_0) max_0 = sizes[i][0];
                if (sizes[i][1] > max_1) max_1 = sizes[i][1];
            } else {
                if (sizes[i][1] > max_0) max_0 = sizes[i][1];
                if (sizes[i][0] > max_1) max_1 = sizes[i][0];
            }
        }

        return max_0 * max_1;
    }
}