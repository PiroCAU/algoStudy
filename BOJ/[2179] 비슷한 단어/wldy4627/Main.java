package boj.b2179.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static class Word {
		String str;
		int idx;

		Word(String str, int idx) {
			this.str = str;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] original = new String[N];
		Word[] words = new Word[N];
		for (int i = 0; i < N; i++) {
			original[i] = br.readLine();
			words[i] = new Word(original[i], i);
		}

		// 사전 순 정렬
		Arrays.sort(words, (a, b) -> a.str.compareTo(b.str));

		int maxCnt = Integer.MIN_VALUE;
		for (int i = 0; i < N - 1; i++) {
			maxCnt = Math.max(maxCnt, commonPrefixLength(words[i].str, words[i + 1].str));
		}

		int bestA = Integer.MAX_VALUE;
		int bestB = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			int nowCnt = commonPrefixLength(words[i].str, words[i + 1].str);
			if (nowCnt != maxCnt) continue;

			String prefix = words[i].str.substring(0, maxCnt);

			// prefix가 동일한 다른 쌍이 있는지 확인
			int j = i;
			int first = Integer.MAX_VALUE;
			int second = Integer.MAX_VALUE;

			while (j < N && words[j].str.startsWith(prefix)) {
				int idx = words[j].idx;

				if (idx < first) {
					second = first;
					first = idx;
				} else if (idx < second) {
					second = idx;
				}

				j++;
			}

			if (first < bestA || (first == bestA && second < bestB)) {
				bestA = first;
				bestB = second;
			}
		}

		System.out.println(original[bestA]);
		System.out.println(original[bestB]);
	}

	static int commonPrefixLength(String s1, String s2) {
		int count = 0;
		int len = Math.min(s1.length(), s2.length());

		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}
}
