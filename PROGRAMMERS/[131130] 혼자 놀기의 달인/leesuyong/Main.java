class Solution_131130 {
    public int solution(int[] cards) {

        int n = cards.length;
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        int max = 0;


        for (int i = 0; i < n; i++) {
            if (visited[i+1]) continue; // 이미 방문한 그룹이면 패스

            int count = 0;
            int current = i+1;

            while (true) {
                if (visited[current] == false) {
                    visited[current] = true;
                    count++;
                    current = cards[current-1];
                } else {
                    break;
                }
            }
            sizes.add(count);


            Collections.sort(sizes, Collections.reverseOrder());
        }

        if (sizes.size() >= 2) {
            return sizes.get(0) * sizes.get(1);
        } else
            return 0;
    }
}