import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] ints = new int[n + 1];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            Queue<Integer> que = new ArrayDeque<>();

            // 그래프 초기화
            for (int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }

            //연결 데이터를 입력받는다.
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                map.get(a).add(b);
                map.get(b).add(a);
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (ints[i] != 0) {
                    continue;
                }

                count += 1;

                DFS(i, ints, count, map);
            }
            System.out.println("#" + test_case + " " + count);
        }
        sc.close();
    }

    public static void DFS(Integer num, int[] ints, int count, HashMap<Integer, List<Integer>> map) {
        if (ints[num] == 0) {
            ints[num] = count;
            List<Integer> integers = map.get(num);

            //만약 연결된 노드들이 있다면
            if (!integers.isEmpty()) {
                for (Integer integer : integers) {
                    DFS(integer, ints, count, map);
                }
            }
        }
    }
}
