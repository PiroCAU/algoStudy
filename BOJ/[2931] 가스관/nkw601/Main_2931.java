import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2931 {
    static int R, C;
    static int[] moscow, zagreb;
    static char[][] map;
    static ArrayList<int[]> blocks;
    static Map<Character, Integer> charToMask = new HashMap<>();
    static Map<Integer, Character> maskToChar = new HashMap<>();
    
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map= new char[R][C];
        moscow = new int[2];
        zagreb = new int[2];
        blocks = new ArrayList<>();
        
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'M') {
                    moscow[0] = i;
                    moscow[1] = j;
                } else if(map[i][j] == 'Z') {
                    zagreb[0] = i;
                    zagreb[1] = j;
                } else if(map[i][j] != '.'){
                    blocks.add(new int[] {i, j});
                }
            }
        }
        
        // 시작점: moscow
        initMask();
        find();
    }
    
    static private void find() {
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			char cur = map[i][j];
    			// . 칸 중 열려야 하는 칸이 있으면 return
    			if(cur != '.') continue;
    			// 내 주변 4방향의 칸 중 나랑 통하는 파이프가 있다면 내가 지워진 칸
    			int need = 0;
    			for(int d = 0; d < 4; d++) {
    				int nr = i + dr[d];
    				int nc = j + dc[d];
    				
    				if(!isIn(nr, nc)) continue;
                    char next = map[nr][nc];
    				if (next == '.' || next =='M' || next == 'Z') continue;
    				int mask = charToMask.get(next);

    				if((mask & (1 << getOpp(d))) != 0) {
    					need |= (1 << d); // 필요로 하는 방향을 합하기
    				}
    			}
    			
    			int k = Integer.bitCount(need);
    			if (k >= 3) {
    			    need = 0b1111;
    			}
    			Character block = maskToChar.get(need);
                if (block != null) {
                    System.out.printf("%d %d %c\n", i + 1, j + 1, block);
                    return;
                }
    		}
    	}    	
    }
    private static int getOpp(int d) {
    	return (d + 2) % 4;
    }
    private static boolean isIn(int r, int c) {
    	return 0 <= r && r < R && 0 <= c && c < C;
    }
    // 상우하좌 가능 0b: 이진수
    // 이진수라서 왼쪽부터 시작
    private static void initMask() {
        charToMask.put('|', 0b0101);
        charToMask.put('-', 0b1010);
        charToMask.put('+', 0b1111);
        charToMask.put('1', 0b0110);
        charToMask.put('2', 0b0011);
        charToMask.put('3', 0b1001);
        charToMask.put('4', 0b1100);
        charToMask.put('M', 0b1111);
        charToMask.put('Z', 0b1111);

        maskToChar.put(0b0101, '|');
        maskToChar.put(0b1010, '-');
        maskToChar.put(0b1111, '+');
        maskToChar.put(0b0110, '1');
        maskToChar.put(0b0011, '2');
        maskToChar.put(0b1001, '3');
        maskToChar.put(0b1100, '4');
    }
}

/*
 * 입력
 * R C
 * R: 맵 정보
 * 
 * 출력
 * 지워진 블록의 행 열, 어떤 블록인지
 * 
 * 생각
 * 뭔 소리야 이게
 * 뭔가 비트마스킹으로 풀면 쉬울 것 같은 문제
 * 근데 난 비트마스킹을 못해...
 * 와 근데 어떻게 하지?
 * 블록들 위치를 입력받고
 * 모스크바에서 시작 -> 흐름 따라 ㄱㄱ 근데 어느 방향으로 가야하는지는 어케 알지?
 * 갈 수 있는 양방향 모두 살펴서 -> 그 방향에 블록이 존재하면 흐름 확인
 * 이야 막막해
 * 아니다 그냥 전체를 돌면서
 * .의 주위를 살핌 -> 만약 길이 통해야하면 거기가 문제
 * 
 * 이해
 * 블록 ㅣ - + 1 2 3 4
 * 
 * 지워진 한 칸 찾기
 */
