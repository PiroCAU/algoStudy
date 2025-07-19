import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dolls = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
		}
		// 투 포인터
		int start = 0;
		int end = 0;
		
		int lion_num = isLion(dolls[0]);
		int minDoll = N + 1;
		
		while(end < N) {
			if(lion_num < K) {
				if(end + 1 >= N) break;
				end++;
				lion_num += isLion(dolls[end]);
			}
			else {
				if(lion_num == K) {
					minDoll = Math.min(end - start + 1, minDoll);
				}
				lion_num -= isLion(dolls[start]);
				start++;
			}
		}
		if(minDoll <= N){
			System.out.println(minDoll);
		}
		else {
			System.out.println(-1);
		}
		
	}
	private static int isLion(int n) {
		if (n == 1) return 1;
		else return 0;
	}

}
