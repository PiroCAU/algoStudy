import java.util.*;

class Solution {
	static class Node {
		String word;
		int depth;

		Node(String word, int depth) {
			this.word = word;
			this.depth = depth;
		}
	}
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		int answer = 0;

		visited = new boolean[words.length];
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(begin, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.word.equals(target)) {
				answer = now.depth;
				break;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && canChange(now.word, words[i])) {
					q.offer(new Node(words[i], now.depth + 1));
					visited[i] = true;
				}
			}
		}

		return answer;
	}

	static boolean canChange(String s1, String s2) {
		int diff = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
		}

		return diff == 1;
	}
}