import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	private static int[] heights;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			heights = new int[21]; // 1번부터 시작
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int i = 1; i <= 20; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			// 뒤로 이동하는 수: 나보다 큰 사람이 앞에 있는 만큼
			for (int i = 1; i <= 20; i++) {
                for (int j = 1; j < i; j++) {
                    if (heights[j] > heights[i]) ans++;
                }
            }
			
			sb.append(tc).append(" ").append(ans).append('\n');
		}
		
		
		System.out.println(sb);
	}
}
