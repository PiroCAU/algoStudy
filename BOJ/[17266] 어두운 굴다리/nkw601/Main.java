import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, maxHei;
	private static int[] lights;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		lights = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		maxHei = 0;
		for(int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			lights[i] = cur;
			
			if(i > 0) {
				int hei = (int) Math.ceil((lights[i] - lights[i - 1]) / 2.0);
				maxHei = Math.max(maxHei, hei);
			}
		}

		frontAndBack();
		
		System.out.println(maxHei);
	}

	private static void frontAndBack() {
		int start = 0;
		int last = M - 1;
		
		int sHei = lights[start];
		maxHei = Math.max(maxHei, sHei);
		
		int eHei = (int) Math.ceil((N - lights[last]));
		maxHei = Math.max(maxHei, eHei);

	}
}

/*
 * 처음 시도: boolean 배열 만들어서 hei까지 가면서 풀기 -> 0, 5에 가로등 설치한 경우 3이어야 하는데 idx로 처리하니까 2만에 끝남
 * 두 번째: 가운데까지의 최대 거리
 * (스타트지점, 끝지점까지 고려해야할듯)
 */