package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static int N, M, maxCnt = 0;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기화
		map = new int[N][M];
		
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select(0, 0);
		
		System.out.println(maxCnt);
	}
    // 3개 선택
	private static void select(int cur, int cnt) {
		if(cnt == 3) {
			spreadVirus();
			return;
		}
		if (cur >= N * M) return;
		
		int r = cur / M;
		int c = cur % M;
		
		// 선택 x
        select(cur + 1, cnt);

        // 선택 o
		if (map[r][c] == 0) {			
			map[r][c] = 1;
            select(cur + 1, cnt + 1);
            map[r][c] = 0;
        }
    }
	
    // 바이러스 퍼뜨리기
	private static void spreadVirus() {
		int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) temp[i] = map[i].clone();
        
		Queue<int[]> q = new ArrayDeque<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}
				
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(isIn(nr, nc) && temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					q.offer(new int[] {nr, nc});
				}
					
			}
		}
        
		// 안전구역 수 세기
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 0) cnt++;
			}
		}
		
		maxCnt = Math.max(maxCnt, cnt);
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
