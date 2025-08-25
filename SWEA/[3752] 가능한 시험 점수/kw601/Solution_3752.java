import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_3752 {
	static int[] scores;
	static boolean[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			scores = new int[N];

			int total = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				total += scores[i];
			}
			
			dp = new boolean[total + 1];
			dp[0] = true;
			
			// scores에 있는 모든 s에 대해
			for (int s : scores) {
				// total부터, 0까지 쭉 오면서...
				// 중복 갱신 방지를 위해 뒤에서부터 돌아야한다고 함.
                for (int i = total; i >= 0; i--) {
                    // i 만드는게 가능하다면, i + s도 가능함
                	if (dp[i]) dp[i + s] = true;
                }
            }
            
            int cnt = 0;
            for (boolean b : dp) {
            	if (b) cnt++;
            }
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		
		}
		System.out.println(sb);
	}
}

/* 
 * 입력
 * T
 * N
 * 문제의 배점
 * 
 * 출력
 * 학생들이 받을 수 있는 점수 경우의 수
 * 
 * 그냥 dfs 아닌가...
 * 가지치기 조건: 이미 받은 적 있는 점수면 return
 * 시간 초과...
 * 
 * DP라고 합니다...
 * 만들 수 있으면 true, 없으면 false
 */