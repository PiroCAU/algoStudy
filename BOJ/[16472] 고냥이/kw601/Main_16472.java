import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] alpha = new int[26]; // 알파벳
        int start = 0, end = 0;
        int appear = 0;
        int maxLen = 0;

        while (end < s.length()) {
        	// 지금 알파벳
            int c = s.charAt(end) - 'a';
            // 존재 안했으면 appear++
            if (alpha[c] == 0) appear++;
            
            // 알파벳 개수 ++
            alpha[c]++;
            
            // 뒤로 한 칸 이동
            end++;
            
            // N개 이상 등장하면
            while (appear > N) {
            	// 지금 start 빼고, start 뒤로 한 칸
            	int cur = s.charAt(start++) - 'a';
                alpha[cur]--;
                // 하나만 있었으면 종류 하나 빼기
                if (alpha[cur] == 0) appear--;
                
            }
            maxLen = Math.max(maxLen, end - start);
        }

        System.out.println(maxLen);
    }
}


/*
 * 입력
 * N
 * 문자열
 * 
 * 출력
 * 번역기가 인식할 수 있는 문자열의 최대 길이
 * 
 * 이해
 * N개 종류의 알파벳을 가진 연속된 문자열 인식
 * 
 * 생각
 * 투포인터? 슬라이딩 윈도우?
 * 알파벳 저장하는 배열 하나 만들고
 * while(end < len(sent))
 * if 선택 <= N: end++
 * max 갱신
 * else:
 * 	start++
 */
