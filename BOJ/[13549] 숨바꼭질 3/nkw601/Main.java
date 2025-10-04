import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static int[][] medals;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		medals = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			medals[num][0] = Integer.parseInt(st.nextToken()); // 금
			medals[num][1] = Integer.parseInt(st.nextToken()); // 은
			medals[num][2] = Integer.parseInt(st.nextToken()); // 동
		}
		
		int winner = 0;
		int gold = medals[K][0];
		int silv = medals[K][1];
		int bron = medals[K][2];

		for(int i = 1; i <= N; i++) {
			if(i == K) continue;
			
			if(medals[i][0] > gold) winner++;
			else if(medals[i][0] < gold) continue;
			else {
				if(medals[i][1] > silv) winner++;
				else if(medals[i][1] < silv) continue;
				else {
					if(medals[i][2] > bron) winner++;
					else continue;
				}
			}
		}
		System.out.println(winner + 1);
	}

}
