import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int T, K;
	private static String W;
	private static int[] alphas;
	private static char[] sent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			alphas = new int[26];
			W = br.readLine().toLowerCase();
			K = Integer.parseInt(br.readLine());
			
			sent = W.toCharArray();
			
			alphas = new int[26];
			
			// 알파벳 cnt
			for(int i = 0; i < W.length(); i++) {
				alphas[sent[i] - 'a']++;
			}
			
			int min = W.length();
			int max = 0;
			
			boolean find = false;
			int len = W.length();
			
			// K = 1일 때
			if(K == 1) {
				sb.append("1 1\n");
				continue;
			}
			
			for(int i = 0; i < len; i++) {
				if(alphas[sent[i] - 'a'] < K) continue; // K개 안되면 볼 필요 없음
				
				int cnt = 1; // 나 포함!
				
				for(int j = i + 1; j < len; j++) {
					if(sent[i] == sent[j]) cnt++;
					
					if(cnt == K) {
						find = true;
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break; // 더 보면 안됨! 뒤에 같은 문자 나오는 순간 K개가 아니게 되니까
					}
				}
			}
			
			if(find) sb.append(min).append(" ").append(max).append("\n");
			else sb.append(-1).append("\n");			
		}
		System.out.println(sb);
	}


}
