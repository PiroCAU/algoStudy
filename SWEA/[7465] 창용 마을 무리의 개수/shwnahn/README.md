# 알고리즘

DFS사용.
N 값으로 graph 이차원배열 틀을 짠다. 이 때, 노드번호갸 1~N이므로 i=0 부터 N포함으로 처리.

이렇게 하면 0번 인덱스는 그냥 사용하지 않으면서, graph.get(N) 할 때 용이함.

그 후 M 값으로 순회하며 값을 넣는다.

넣은 값을 따라서 dfs 시행


        // (1) 입력값으로 graph를 먼저 만든다.
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // (2) 이를 바탕으로 dfs 를 시행한다. visited가 false일때만.
        // 초기화
        visited = new boolean[N+1];
        // (3) 새로 시행한 dfs 회수만큼 무리가 있다고 볼 수 있음.
        int groupCount = 0;

        // 모든 사람 대상으로 dfs 수행
        for (int i = 0; i <= N; i++) {
            if (!visited[i]) {
                groupCount++;
                dfs(i);
            }
        }

# 어려운 점
처음에는 이게 무슨 알고리즘문제일까..? 가늠이 잘 안 갔다.

DFS였다. DFS 자체를 이해하는 게 어렵다.
GPT를 많이 사용했음.