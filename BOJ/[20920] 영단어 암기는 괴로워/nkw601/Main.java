import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int N, M; // 지문에 나오는 단어 수, 외울 단어의 길이 기준(M 이상만 외움)
	private static HashMap<String, Integer> words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 입력, 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new HashMap<>();		
	
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			// 길이가 M 이상일 때에만 외움
			if(word.length() >= M) {
				// getOrDefault
				words.put(word, words.getOrDefault(word, 0) + 1);
			}
		}
		
		// 자주 나오는 단어면 앞에
		// 단어의 길이가 길면 앞에
		// 알파벳 사전 순으로 앞이면 앞에
		ArrayList<String> wordsList = new ArrayList<>(words.keySet());
		Collections.sort(wordsList, (o1, o2) -> {
		    int f1 = words.get(o1), f2 = words.get(o2);
		    if (f1 != f2) return Integer.compare(f2, f1);      // 빈도
		    int l1 = o1.length(), l2 = o2.length();
		    if (l1 != l2) return Integer.compare(l2, l1);      // 길이
		    return o1.compareTo(o2);                           // 사전순
		});

		
		for(String word : wordsList) {
			sb.append(word).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
