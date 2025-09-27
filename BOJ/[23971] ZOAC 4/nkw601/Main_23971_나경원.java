import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23971_나경원 {
    static int h, w, n, m, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0, 0에 앉히고 1. 가로 거리 차에 앉히고 2. 세로거리 차에 앉히고
        // n줄, m칸 뗴고 앉힘 -> 다음 앉히는 자리는 n+1, m+1
        for(int i = 0; i < h; i += (n + 1)){
            for(int j = 0; j < w; j += (m + 1)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}