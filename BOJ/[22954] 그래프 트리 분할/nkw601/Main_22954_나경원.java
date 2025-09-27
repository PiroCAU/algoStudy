import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_22954_나경원 {
    static class Edge {
        int to, idx;

        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx; }
    }
    private static ArrayList<Edge> edges = new ArrayList<>();
    private static int[] parents;
    private static int n, m;


    static ArrayList<Edge>[] graph; // 그래프 인접 리스트
    static boolean[] visited;

    // 현재 컴포넌트에서 수집 중인 정점/간선
    static ArrayList<Integer> currentVertices;
    static ArrayList<Integer> currentEdges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for(int i = 1; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,i));
            graph[v].add(new Edge(u,i));
        }


        // 간선 줄여서 트리 2개로 분할하기... 어케하지
        // 일단 빼? 근데 union 해체 어케하는지 모르는데
        // 지피티 찬스 -> 간선 번호를 저장하고 번호를 같이 포함한대...
        // 전혀 이해가 안감...
        // 아니 유니온 파인드가 필요가 없는거였대...
        // 코드를 봐도 이해가 가질 않습니다...

//      컴포넌트 ≥ 3 → 불가능(-1).
//		컴포넌트 = 2 → 두 컴포넌트 정점 수 같으면 불가능, 다르면 그대로 출력.
//		컴포넌트 = 1 → 리프 정점 하나 떼어서 (1, n−1) 두 트리로 나누기.
//		리프 찾기: degree=1인 정점.
//		그 리프에 연결된 간선을 제외하면 됨.
        // 이게 무슨 소리일까?
        // 간선을 n-2개 고른단건 알겠음

    }
    private static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(pu < pv) parents[pv] = pu;
        else parents[pu] = pv;
    }
    private static int find(int n){
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
    private static void init() {
//        parents = new int[n + 1];
//        for(int i = 1; i <= n; i++){
//            parents[i] = i;
//        }
    }
}