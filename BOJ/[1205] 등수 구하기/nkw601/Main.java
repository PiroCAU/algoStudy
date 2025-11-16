import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, sco, P;
		N = Integer.parseInt(st.nextToken()); // 주어질 점수의 개수
		sco = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
		P = Integer.parseInt(st.nextToken()); // 랭킹에 오를 수 있는 수
		
		// 내가 첨 등장
		if (N == 0) {
            System.out.println(1);
            return;
        }
		
		// 일단 0으로 초기화
		Integer[] ranks = new Integer[P];
		Arrays.fill(ranks, 0);
		
		// 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ranks[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(ranks, Collections.reverseOrder());	
		
		// 못 들어감
		if (N == P && sco <= ranks[N - 1]) {
            System.out.println(-1);
            return;
        }
		
		// 위치 찾기
		int beforeMe = 0;
		for (int i = 0; i < N; i++) {
            if (ranks[i] > sco) {
                beforeMe++;
            } else {
                break;
            }
        }
		
		System.out.println(beforeMe + 1);
	}

}