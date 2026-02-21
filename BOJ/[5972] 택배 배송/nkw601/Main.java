import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] stovers; // stovers: i번째 헛간까지 도착하는 최소 여물 수
	private static ArrayList<int[]>[] barns;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기화
		stovers = new int[N + 1];
		Arrays.fill(stovers, Integer.MAX_VALUE);
		barns = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			barns[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 인접리스트 만들기
			barns[a].add(new int[] {b, c});
			barns[b].add(new int[] {a, c});
		}
		
		dijkstra(1, N);
		System.out.println(stovers[N]);
	}
	
	
	private static void dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		stovers[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int curBarn = cur[0];
			int curWei = cur[1];
			
			if(curWei > stovers[curBarn]) continue; // 방문처리
			
			for(int[] next : barns[curBarn]) {
				int nextBarn = next[0];
				int nextWei = next[1] + curWei;
				
				if(nextWei < stovers[nextBarn]) {
					pq.offer(new int[] {nextBarn, nextWei});
					stovers[nextBarn] = nextWei;
				}
			}
		}
	}
}
/*
 * 입력
 * N M
 * M: A_i B_i C_i
 * 
 * 출력
 * 농부 현서가 가져가야하는 최소 여물
 * 
 * 이해
 * N개의 헛간, M개의 양방향 길
 * 각각의 길의 가중치 C(소 수)
 * 
 * 헛간 1 -> 헛간 N
 * 
 * 생각
 * 최단 거리 with 가중치 -> 다익스트라
 */