import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] ints = new int[10][10];

    //색종이 크기별 남은 갯수
    static int[] papers = { 0, 5, 5, 5, 5, 5 };
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DFS
        DFS(0, 0, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    public static void DFS(int x, int y, int cnt) {
        //끝까지 왔으므로 결과를 비교하고 종료
        if (x >= 9 && y >= 9) {
            ans = Math.min(cnt, ans);
            return;
        }

        //이미 기존의 결과보다 커지면 더이상 탐색이 불필요: 가지치기
        if (cnt >= ans) {
            return;
        }

        //끝까지 왔으므로 다음 줄로 이동한다.
        if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }

        if (ints[x][y] == 1) {
            //색종이가 큰거부터 붙인다.
            for (int i = 5; i >= 1; i--) {
                if (papers[i] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0);
                    papers[i]--;
                    //색종이를 붙인 경우를 탐색하게 된다.
                    DFS(x, y+1, cnt + 1);
                    attach(x, y, i, 1);     //다시 원상 복구
                    papers[i]++;        //색종이를 붙이지 않고 넘어간 케이스를 탐색한다.
                }
            }
        } else {
            DFS(x, y + 1, cnt);
        }
    }

    public static void attach(int x, int y, int s, int N) {
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                ints[i][j] = N;
            }
        }
    }

    public static boolean isAttach(int x, int y, int s) {
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }

                if (ints[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

