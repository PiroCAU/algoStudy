import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        // [요청시각, 소요시간, 원래 인덱스]를 요청시각 기준으로 정렬
        int[][] sortedJobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedJobs[i][0] = jobs[i][0];
            sortedJobs[i][1] = jobs[i][1];
            sortedJobs[i][2] = i;
        }
        Arrays.sort(sortedJobs, (a, b) -> a[0] - b[0]);

        // 대기 큐: 소요시간 -> 요청시각 -> 번호 순으로 우선순위
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        long totalTurnaround = 0;
        long currentTime = 0;
        int idx = 0;
        int processed = 0;

        while (processed < n) {
            // 도착한 작업 큐에 넣기
            while (idx < n && sortedJobs[idx][0] <= currentTime) {
                pq.offer(sortedJobs[idx]);
                idx++;
            }

            //일 없으면다음 작업까지 점프
            if (pq.isEmpty()) {
                currentTime = sortedJobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            currentTime += job[1];
            totalTurnaround += (currentTime - job[0]);
            processed++;
        }

        return (int) (totalTurnaround / n);
    }
}