import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static HashMap<Integer, ArrayList<Integer>> ranks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 6명 참여, 점수는 상위 네 명 주자의 점수 합하여 계산
		// 결승선을 통과한 순서대로 점수를 받고, 가장 낮은 팀이 우승
		// 6명 참여 X시 점수 계산 제외
		// 동점: 다섯 번째 주자가 가장 먼저 들어온 팀이 우승
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			ranks = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			
			int[] teams = new int[201];
			int[] players = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			// 일단 저장
			for(int i = 0; i < N; i++) {
				int teamNum = Integer.parseInt(st.nextToken());
				teams[teamNum]++;
				players[i] = teamNum;
			}
			
			int rank = 1;
			for(int i = 0; i < N; i++) {
				int teamNum = players[i];
				
				// 6명 안되면 넘어가
				if(teams[teamNum] < 6) continue;
				
				// 이미 존재하면 rank 추가해줌
				if(ranks.containsKey(teamNum)) {
					ranks.get(teamNum).add(rank++);
				} else { // 처음 등장하는 팀이면 ArrayList 새로 만들어서 넣어줌
					ArrayList<Integer> team = new ArrayList<>();
					team.add(rank++);
					ranks.put(teamNum, team);
				}				
			}
			
			int winner = -1;
			int minSum = Integer.MAX_VALUE;
			int fifth = Integer.MAX_VALUE;
			
			for(int key : ranks.keySet()) {
				ArrayList<Integer> cur = ranks.get(key);
				if(cur.size() < 6) continue;
				int sum = 0;
				
				Collections.sort(cur);
				// 결승선 통과한 사람들 더하기
				for(int i = 0; i < 4; i++) {
					sum += cur.get(i);
				}

				if(minSum > sum) { // 더 빠르면
					winner = key;
					minSum = sum;
					fifth = cur.get(4);
				} else if(minSum == sum) {
					if(fifth > cur.get(4)) {
						winner = key;
						fifth = cur.get(4);
					}
				}
			}
			sb.append(winner).append("\n");
		}
		System.out.println(sb);
	}

}
