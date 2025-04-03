import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int[] graph;
    private int[] pass;

    private void solution() throws IOException {

        graph = new int[101];
        pass = new int[101];        //해당 위치에서 어디로 이동하는지 저장

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<M+N; i++){
            st = new StringTokenizer(bf.readLine());
            pass[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        //BFS 탐색을 위해 저장하는 곳
        Queue<Integer> q = new ArrayDeque<>();      //위치 값을 저장
        graph[1] = 1;   //초기화: 이 위치에 오기 위해 몇 번 움직였는지 저장
        q.add(1);

        while(graph[100]==0){
            int cur = q.poll();

            for(int i=1; i<=6; i++){
                int nextp = cur+i;
                if(nextp>100 || graph[nextp]!=0) continue;

                graph[nextp] = graph[cur]+1;
                if(pass[nextp]!=0 && graph[pass[nextp]]==0){
                    nextp = pass[nextp];
                    graph[nextp] = graph[cur]+1;
                    q.add(nextp);
                }
                else if(pass[nextp]==0)
                    q.add(nextp);
            }
        }
        System.out.println(graph[100]-1);
    }

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
